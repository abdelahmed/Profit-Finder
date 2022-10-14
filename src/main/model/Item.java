package model;

public class Item {
    private String name;
    private double cost;
    private double price;
    private double sales;
    private double buys;


    public Item(String name, double cost, double price, double sales, double buys) {
        this.name = name;
        this.cost = cost;
        this.price = price;
        this.sales = sales;
        this.buys = buys;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getCost() {
        return cost;
    }

    public double getSales() {
        return sales;
    }

    public double getBuys() {
        return buys;
    }

    public double getProfit() {
        return (sales * price - cost * buys);
    }

    public void changePrice(double newPrice) {
        if (newPrice < 0) {
            price = price;
        } else {
            price = newPrice;
        }
    }

    public void changeCost(double newCost) {
        if (newCost < 0) {
            cost = cost;
        } else {
            cost = newCost;
        }
    }

    public void changeSales(double newSales) {
        if (newSales < 0) {
            sales = sales;
        } else {
            sales = newSales;
        }
    }

    public void changeBuys(double newBuys) {
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







