package ui;

import model.Item;

import javax.swing.*;
import java.awt.*;

public class ItemDetails extends JFrame {

    public ItemDetails(Item item) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setVisible(true);
        this.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("NAME: " + item.getName());

        JLabel costLabel = new JLabel("COST: " + "$" + String.valueOf(item.getCost()));

        JLabel priceLabel = new JLabel("PRICE: " + "$" + String.valueOf(item.getPrice()));

        JLabel salesLabel = new JLabel("SALES: " + "$" + String.valueOf(item.getSales()));

        JLabel profitLabel = new JLabel("PROFIT: " + "$" + String.valueOf(item.getCost()));
        profitLabel.setHorizontalTextPosition(JLabel.CENTER);
        profitLabel.setVerticalTextPosition(JLabel.CENTER);


        this.add(nameLabel);
        this.add(costLabel);
        this.add(priceLabel);
        this.add(salesLabel);
        this.add(profitLabel);



    }
}
