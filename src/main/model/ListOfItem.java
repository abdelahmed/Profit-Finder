package model;

import java.util.ArrayList;


public class ListOfItem {
    private int itemCount;
    private ArrayList<Item> itemList;

    public ListOfItem() {
        itemCount = 0;
        itemList = new ArrayList<>();
    }

    public void addItem(Item newItem) {
        itemList.add(newItem);
        itemCount += 1;
    }

    public void removeItem(Item removedItem) {
        itemList.remove(removedItem);
        itemCount -= 1;
    }

    public ArrayList<Item> getListOfItems() {
        return itemList;
    }

    public int getItemCount() {
        return itemCount;
    }
}







