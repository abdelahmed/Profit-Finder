package model;

public class Item {
    private String name;
    private int cost;
    private int price;
    private int sales;
    private int buys;


    public Item(String name, int cost, int price, int sales, int buys) {
        this.name = name;
        this.cost = cost;
        this.price = price;
        this.sales = sales;
        this.buys = buys;
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

    public void changePrice(int newPrice) {
        if (newPrice < 0) {
            price = price;
        } else {
            price = newPrice;
        }
    }

    public void changeCost(int newCost) {
        if (newCost < 0) {
            cost = cost;
        } else {
            cost = newCost;
        }

    }

    public void changeSales(int newSales) {
        if (newSales < 0) {
            sales = sales;
        } else {
            sales = newSales;
        }
    }

    public void changeBuys(int newBuys) {
        if (newBuys < 0) {
            buys = buys;
        } else {
            buys = newBuys;
        }
    }

    public void changeName(String newName) {
        name = newName;
    }
}







