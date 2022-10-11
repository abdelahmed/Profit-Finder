package model;

public class Item {
    private String name;
    private int price;
    private int cost;
    private int sales;
    private int buys;



    public Item(String itemName, int itemCost, int itemPrice, int itemSales, int itemBuys) {
        name = itemName;
        cost = itemCost;
        price = itemPrice;
        sales = itemSales;
        buys = itemBuys;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCost() {
        return cost;
    }

    public int getSales() {
        return sales;
    }

    public int getBuys() {
        return buys;
    }

    public int getProfit() {
        return (sales * price - cost * buys);
    }

}
