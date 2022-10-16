package model;

import java.util.ArrayList;

// Represents a list of items having an item count and an arraylist containing items
public class ListOfItem {
    private final ArrayList<Item> items;  // list of items
    private int itemCount;  // number of items in the list of items

    /*
     * EFFECTS: itemCount is set to zero, items is set to an empty ArrayList
     */
    public ListOfItem() {
        itemCount = 0;
        items = new ArrayList<>();
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
}







