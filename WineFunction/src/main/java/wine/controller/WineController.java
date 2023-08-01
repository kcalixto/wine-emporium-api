package wine.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.kms.model.NotFoundException;

import wine.entity.Wine;

public class WineController {

    private DynamoDBMapper mapper;
    private static final String PK_HOME_PAGE_WINES = "HOME#WINE";
    private static final String SK_WINE = "WINE#";

    private static final String BEGINS_WITH = "pk = :pk and begins_with(sk, :sk)";

    public WineController(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    public List<Wine> getWines() throws Exception {
        Map<String, AttributeValue> eav = new HashMap<>() {
            {
                put(":pk", new AttributeValue().withS(PK_HOME_PAGE_WINES));
                put(":sk", new AttributeValue().withS(SK_WINE));
            }
        };

        DynamoDBQueryExpression<Wine> qe = new DynamoDBQueryExpression<Wine>()
                .withExpressionAttributeValues(eav)
                .withKeyConditionExpression(BEGINS_WITH);

        List<Wine> result = mapper.query(Wine.class, qe);
        if (result.size() == 0) {
            throw new NotFoundException("");
        }

        return result;
    }

    public void saveWine(Wine wine) {
        wine.setPk(PK_HOME_PAGE_WINES);
        wine.setSk(SK_WINE + wine.getSlug());
        mapper.save(wine);
    }
}
