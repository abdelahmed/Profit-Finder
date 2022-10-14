package model;

import java.util.ArrayList;


public class ListOfItem {
    private int itemCount;
    private final ArrayList<Item> items;

    public ListOfItem() {
        itemCount = 0;
        items = new ArrayList<>();
    }

    public void addItem(Item newItem) {
        items.add(newItem);
        itemCount += 1;
    }

    public void removeItem(Item removedItem) {
        if (items.contains(removedItem)) {
            items.remove(removedItem);
            itemCount -= 1;
        }
    }

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







