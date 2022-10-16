package model;

// Represents an item having a name, cost ($), price ($), and sales ($)
public class Item {
    private String name;  // name of the item
    private double cost;  // total money spent to put this item on sale/ make the item
    private double price; // price of one of the item
    private double sales; // total number of sales of this item

    /*
     * EFFECTS: name of item is set to itemName, cost of item is set to totalCost,
     * price of item is set to itemPrice, sales of the item is set to totalSales.
     */
    public Item(String itemName, double totalCost, double itemPrice, double totalSales) {
        this.name = itemName;
        this.cost = totalCost;
        this.price = itemPrice;
        this.sales = totalSales;
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

    public double getProfit() {
        return (sales * price - cost);
    }

    /*
     * REQUIRES: newPrice >= 0
     * MODIFIES: this
     * EFFECTS: price of Item is set to newPrice
     */
    public void changePrice(double newPrice) {
        if (newPrice >= 0) {
            price = newPrice;
        }
    }

    /*
     * REQUIRES: newCost >= 0
     * MODIFIES: this
     * EFFECTS: cost of Item is set to newCost
     */
    public void changeCost(double newCost) {
        if (newCost >= 0) {
            cost = newCost;
        }
    }

    /*
     * REQUIRES: newSales >= 0
     * MODIFIES: this
     * EFFECTS: sales of Item is set to newSales
     */
    public void changeSales(double newSales) {
        if (newSales >= 0) {
            sales = newSales;
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: name of item is set to newName
     */
    public void changeName(String newName) {
        name = newName;
    }
}







