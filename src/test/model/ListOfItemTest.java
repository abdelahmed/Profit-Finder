package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListOfItemTest {

    private ListOfItem testList1;
    private Item item1;
    private Item item2;
    private Item item3;

    public ListOfItemTest() {
    }

    @BeforeEach
    public void setup() {

        testList1 = new ListOfItem();
        item1 = new Item("apple", 3, 5, 10);
        item2 = new Item("banana", 2, 10, 10);
        item3 = new Item("guava", 1, 3, 20);
    }

    @Test
    public void listOfItemConstructorTest() {
        ListOfItem testList4 = new ListOfItem();
        assertEquals(testList4.getListOfItems(), new ArrayList<>());
        assertEquals(testList4.getItemCount(), 0);
    }


    @Test
    public void addItemTest() {
        testList1.addItem(item1);
        assertEquals(testList1.getListOfItems().get(0), item1);
        testList1.addItem(item2);
        testList1.addItem(item3);
        assertEquals(testList1.getListOfItems().get(2), item3);

    }

    @Test
    public void removeItemTest() {
        testList1.addItem(item1);
        testList1.addItem(item2);
        testList1.addItem(item3);
        testList1.removeItem(item2);
        assertEquals(testList1.getListOfItems().get(0), item1);
        assertEquals(testList1.getListOfItems().get(1), item3);
        testList1.removeItem(item1);
        assertEquals(testList1.getListOfItems().get(0), item3);
        testList1.removeItem(item3);
        ListOfItem emptyTest = new ListOfItem();
        assertEquals(testList1.getListOfItems(), emptyTest.getListOfItems());

    }

    @Test
    public void testGetItemCount(){
        assertEquals(testList1.getItemCount(), 0);
        testList1.addItem(item1);
        assertEquals(testList1.getItemCount(), 1);
        testList1.addItem(item2);
        testList1.addItem(item3);
        assertEquals(testList1.getItemCount(), 3);
        testList1.removeItem(item2);
        assertEquals(testList1.getItemCount(), 2);
        testList1.removeItem(item2);
        assertEquals(testList1.getItemCount(), 2);
        testList1.removeItem(item1);
        testList1.removeItem(item3);
        assertEquals(testList1.getItemCount(), 0);

    }

    @Test
    public void testGetItemNames() {
        ArrayList<String> testList3 = new ArrayList<>();
        assertEquals(testList1.getItemNames(), testList3);
        testList3.add("apple");
        testList1.addItem(item1);
        assertEquals(testList1.getItemNames(), testList3);

    }

    @Test
    public void getListOfItemsTest() {
        assertEquals(testList1. getListOfItems(), new ArrayList<>());
        testList1.getListOfItems().add(item1);
        List<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        assertEquals(testList1.getListOfItems(), itemList1);
        testList1.getListOfItems().add(item2);
        itemList1.add(item2);
        assertEquals(testList1.getListOfItems(), itemList1);
    }



    }






