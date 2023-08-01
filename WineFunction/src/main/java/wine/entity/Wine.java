package wine.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "wine-emporium-tb")
public class Wine {

    @DynamoDBHashKey(attributeName = "pk")
    private transient String pk;

    @DynamoDBRangeKey(attributeName = "sk")
    private transient String sk;

    @DynamoDBAttribute(attributeName = "name")
    private String name;
    @DynamoDBAttribute(attributeName = "slug")
    private String slug;
    @DynamoDBAttribute(attributeName = "price")
    private String price;
    @DynamoDBAttribute(attributeName = "country_name")
    private String country;
    @DynamoDBAttribute(attributeName = "country_slug")
    private String countrySlug;
    @DynamoDBAttribute(attributeName = "winery_name")
    private String winery;
    @DynamoDBAttribute(attributeName = "winery_slug")
    private String winerySlug;
    @DynamoDBAttribute(attributeName = "wine_taste")
    private String taste;
    @DynamoDBAttribute(attributeName = "wine_taste_slug")
    private String tasteSlug;
    @DynamoDBAttribute(attributeName = "wine_age")
    private String age;
    @DynamoDBAttribute(attributeName = "wine_ratings") // TODO
    private String ratings;

    @Override
    public String toString() {
        return "Wine [pk=" + pk + ", sk=" + sk + ", name=" + name + "]";
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountrySlug() {
        return countrySlug;
    }

    public void setCountrySlug(String countrySlug) {
        this.countrySlug = countrySlug;
    }

    public String getWinery() {
        return winery;
    }

    public void setWinery(String winery) {
        this.winery = winery;
    }

    public String getWinerySlug() {
        return winerySlug;
    }

    public void setWinerySlug(String winerySlug) {
        this.winerySlug = winerySlug;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

}
