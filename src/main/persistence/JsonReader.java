package persistence;

import model.Item;
import model.ListOfItem;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ListOfItem read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseListOfItem(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private ListOfItem parseListOfItem(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        ListOfItem li = new ListOfItem(name);
        addItems(li, jsonObject);
        return li;
    }

    // MODIFIES: li
    // EFFECTS: parses items from JSON object and adds them to workroom
    private void addItems(ListOfItem li, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("items");
        for (Object json : jsonArray) {
            JSONObject nextItem = (JSONObject) json;
            addThingy(li, nextItem);
        }
    }

    // MODIFIES: li
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addThingy(ListOfItem li, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Double cost = jsonObject.getDouble("cost");
        Double price = jsonObject.getDouble("price");
        int sales = jsonObject.getInt("sales");

        Item item = new Item(name, cost, price, sales);
        li.addItem(item);
    }
}

// Inspiration taken from JsonSerializationDemo