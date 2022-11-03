package model;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Represents a list of items having an item count and an arraylist containing items
public class ListOfItem extends JPanel {
    private String name;
    private final ArrayList<Item> items;  // list of items
    private int itemCount;  // number of items in the list of items

    /*
     * EFFECTS: itemCount is set to zero, items is set to an empty ArrayList
     * name is set to inputted string
     */
    public ListOfItem(String name) {
        GridLayout layout = new GridLayout(10,1);
        layout.setVgap(5);

        this.setLayout(layout);
        this.setBackground(Color.CYAN);
        this.setVisible(true);

        itemCount = 0;
        items = new ArrayList<>();
        this.name = name;
    }

    /*
     * EFFECTS: adds newItem to items, increases itemCount by 1
     */
    public void addItem(Item newItem) {
        items.add(newItem);
        itemCount += 1;
    }

    /*
     * EFFECTS: removes removedItem from items, decreases itemCount by 1
     */
    public void removeItem(Item removedItem) {
        if (items.contains(removedItem)) {
            items.remove(removedItem);
            itemCount -= 1;
        }
    }

    /*
     * EFFECTS: constructs and returns a list of the names of each item in items.
     */
    public ArrayList<String> getItemNames() {
        ArrayList<String> nameList = new ArrayList<>();
        for (Item i: items) {
            nameList.add(i.getName());
        }
        return nameList;
    }



    public ArrayList<Item> getListOfItems() {
        return items;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getName() {
        return name;
    }


    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("items", itemsToJson());
        return json;
    }

    // returns items in ListOfItems as JSON array
    private JSONArray itemsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Item i : items) {
            jsonArray.put(i.toJson());
        }

        return jsonArray;
    }
}







