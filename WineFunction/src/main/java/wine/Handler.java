package wine;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.kms.model.NotFoundException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;

import wine.controller.WineController;
import wine.entity.Wine;

public class Handler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private static final AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
    private static final DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);

    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        WineController c = new WineController(Handler.dynamoDBMapper);
        try {
            String output = "";
            switch (input.getHttpMethod()) {
                case "GET":
                    output = new Gson().toJson(c.getWines());
                    break;
                case "POST":
                    c.saveWine((Wine) (new Gson().fromJson(input.getBody(), Wine.class)));
                    break;
            }
            return response.withStatusCode(200).withBody(output);
        } catch (NotFoundException e) {
            return response.withStatusCode(404);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return response.withStatusCode(500);
        }
    }
}
