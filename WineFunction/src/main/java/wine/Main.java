package wine;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

public class Main {
    public static void main(String[] args) {
        String body = "{\"name\":\"wine1\",\"price\":\"1\",\"slug\":\"wine1\",\"country\":\"country1\",\"countrySlug\":\"country1\",\"winery\":\"winery1\",\"winerySlug\":\"winery1\",\"taste\":\"taste1\",\"tasteSlug\":\"taste1\",\"age\":\"age1\",\"ratings\":\"ratings1\"}";
        APIGatewayProxyResponseEvent res = new Handler()
                .handleRequest(new APIGatewayProxyRequestEvent().withHttpMethod("POST").withBody(body), null);
        System.out.println(res.toString());
    }
}
