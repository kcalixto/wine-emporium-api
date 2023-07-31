package wine.controller;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.google.gson.Gson;

import wine.entity.Wine;

public class WineController {

    private DynamoDBMapper conn;

    public WineController(DynamoDBMapper conn) {
        this.conn = conn;
    }

    public String getWines() {
        PaginatedQueryList<Wine> w = this.conn.query(Wine.class, new DynamoDBQueryExpression<>());

        System.out.print("gotten wines:");
        w.forEach(wine -> System.out.print(w + " | "));

        return new Gson().toJson(w);
    }
}
