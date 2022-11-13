package model;

import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;

// Represents an item having a name, cost ($), price ($), and sales ($)
public class Item extends JPanel {

    private String name;  // name of the item
    private double cost;  // total money spent to put this item on sale/ make the item
    private double price; // price of one of the item
    private int sales; // total number of sales of this item

    private JLabel index;
    private JLabel itemNameVisible;
    private JButton details;

    /*
     * EFFECTS: name of item is set to itemName, cost of item is set to totalCost,
     * price of item is set to itemPrice, sales of the item is set to totalSales.
     */
    public Item(String itemName, double totalCost, double itemPrice, int totalSales) {
        this.name = itemName;
        this.cost = totalCost;
        this.price = itemPrice;
        this.sales = totalSales;

        this.setPreferredSize(new Dimension(40,20));
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
        this.setVisible(true);


        details = new JButton("details");
        details.setPreferredSize(new Dimension(60,20));
        details.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        details.setBackground(Color.white);
        this.add(details,BorderLayout.EAST);




        index = new JLabel("");
        index.setPreferredSize(new Dimension(40,20));
        index.setHorizontalAlignment(JLabel.CENTER);
        this.add(index,BorderLayout.WEST);

        itemNameVisible = new JLabel(itemName);
        itemNameVisible.setBorder(BorderFactory.createEmptyBorder());
        itemNameVisible.setFont(new Font("Sans-serif", Font.BOLD,20));
        itemNameVisible.setBackground(Color.red);

        this.add(itemNameVisible,BorderLayout.CENTER);


    }

    public JButton getDetails() {
        return details;
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

    public void addDetailsButton() {
        this.add(details,BorderLayout.EAST);
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
    public void changeSales(int newSales) {
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


    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("cost", cost);
        json.put("price", price);
        json.put("sales", sales);
        return json;
    }
}







