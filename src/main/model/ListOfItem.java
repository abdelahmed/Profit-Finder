package model;

import java.util.ArrayList;


public class ListOfItem {
    private int itemCount;
    private ArrayList<Item> itemList;

    public ListOfItem() {
        itemList = new ArrayList<>();
        itemCount = 0;
    }

    public void addItem(Item newItem) {
        itemList.add(newItem);
    }

    public void removeItem(Item removedItem) {
        for (Item i: itemList) {
            if (i == removedItem) {
                itemList.remove(i);
            }
        }
    }




}
