import com.google.gson.*;

import java.lang.reflect.Type;

public class ConverterJSON implements JsonSerializer<Goods>, JsonDeserializer<Goods> {

    @Override
    public Goods deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = json.getAsJsonObject();
        String name = object.get("name").getAsString();
        int count = object.get("count").getAsInt();
        float price = object.get("price").getAsFloat();
        int weight = object.get("weight").getAsInt();
        int fat = object.get("fat").getAsInt();
        int rating = object.get("rating").getAsInt();
        int goodsNumber = object.get("goodsNumber").getAsInt();
        return new Goods(name, count, price, weight, fat, rating, goodsNumber);
    }

    @Override
    public JsonElement serialize(Goods milk, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject object = new JsonObject();
        object.addProperty("name", milk.toString());
        object.addProperty("count", milk.toString());
        object.addProperty("price", milk.toString());
        object.addProperty("weight", milk.toString());
        object.addProperty("fat", milk.toString());
        return object;
    }
}
