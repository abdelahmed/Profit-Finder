package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

 class ItemTest {

     private Item orange;
     private Item apple;
     private Item banana;

     @BeforeEach
     void setup() {
         orange = new Item("orange", 5, 5, 6);
         apple = new Item("apple", 3,4,5);
         banana = new Item("apple", 44.85, 4.9, 5);
     }
     @Test
     public void ItemConstructorTest() {
         assertEquals("apple", apple.getName());
         assertEquals("orange", orange.getName());
    }

    @Test
    public void testGetName() {
         assertEquals(orange.getName(), "orange");
        }

     @Test
     public void testGetSales() {
         assertEquals(orange.getSales(), 6);
     }

     @Test
     public void testGetCost() {
         assertEquals(orange.getCost(), 5);
     }

     @Test
     public void testGetPrice() {
         assertEquals(orange.getPrice(), 5);
     }

     @Test
     public void testChangePrice() {
         orange.changePrice(5);
         assertEquals(orange.getPrice(), 5);
         orange.changePrice(2);
         assertEquals(orange.getPrice(), 2);
         orange.changePrice(0);
         assertEquals(orange.getPrice(), 0);
         orange.changePrice(-1);
         assertEquals(orange.getPrice(), 0);
     }

     @Test
     public void testChangeCost() {
         orange.changeCost(5);
         assertEquals(orange.getCost(), 5);
         orange.changeCost(2);
         assertEquals(orange.getCost(), 2);
         orange.changeCost(0);
         assertEquals(orange.getCost(), 0);
         orange.changeCost(-1);
         assertEquals(orange.getCost(), 0);
     }

     @Test
     public void testGetProfit() {
         assertEquals(orange.getProfit(), 25);
         assertEquals(banana.getProfit(), -20.35);
     }

     @Test
     public void testChangeName() {
         orange.changeName("apple");
         assertEquals(orange.getName(), "apple");
         orange.changeName("banana");
         orange.changeName("pineapple");
         assertEquals(orange.getName(), "pineapple");
     }

     @Test
     public void testChangeSales() {
         orange.changeSales(3);
         assertEquals(orange.getSales(), 3);
         orange.changeSales(34);
         orange.changeSales(35);
         assertEquals(orange.getSales(), 35);
         orange.changeSales(0);
         assertEquals(orange.getSales(), 0);
         orange.changeSales(-1);
         assertEquals(orange.getSales(), 0);
     }

 }
