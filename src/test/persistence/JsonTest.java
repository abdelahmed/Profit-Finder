package persistence;

import model.Item;


import static org.junit.jupiter.api.Assertions.assertEquals;



public class JsonTest {
    protected void It(String name, Item item, Double price) {
        assertEquals(name, item.getName());
        assertEquals(price, item.getPrice());
    }
}