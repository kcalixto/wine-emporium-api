package wine.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.google.gson.Gson;

import wine.entity.Wine;

public class WineController {

    private DynamoDBMapper mapper;

    public WineController(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    public String getWines() {
        try {
            Map<String, AttributeValue> eav = new HashMap<>();
            eav.put(":skPrefix", new AttributeValue().withS("WINE#"));

            DynamoDBQueryExpression<Wine> queryExpression = new DynamoDBQueryExpression<Wine>()
                    .withKeyConditionExpression("sortKey BEGINS_WITH :skPrefix")
                    .withExpressionAttributeValues(eav);

            List<Wine> wines = mapper.query(Wine.class, queryExpression);

            System.out.print("gotten wines:");
            wines.forEach(wine -> System.out.print(wine + " | "));

            return new Gson().toJson(wines);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
    }
}
