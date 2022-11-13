package ui;

import model.Item;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class ItemDetails extends JFrame {

    public ItemDetails(Item item) {
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(800,300);
        this.setVisible(true);
        this.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("NAME: " + item.getName());
        nameLabel.setHorizontalTextPosition(JLabel.CENTER);
        nameLabel.setVerticalTextPosition(JLabel.CENTER);

        JLabel costLabel = new JLabel("COST: " + "$" + String.valueOf(item.getCost()));

        JLabel priceLabel = new JLabel("PRICE: " + "$" + String.valueOf(item.getPrice()));

        JLabel salesLabel = new JLabel("SALES: " + String.valueOf(item.getSales()));

        JLabel profitLabel = new JLabel("PROFIT: " + "$" + String.valueOf(item.getProfit()));
        profitLabel.setHorizontalTextPosition(JLabel.CENTER);
        profitLabel.setVerticalTextPosition(JLabel.CENTER);

        ImageIcon image = new ImageIcon(getClass().getResource("dollar.png"));

        JLabel imageLabel = new JLabel(image);
        nameLabel.setHorizontalTextPosition(JLabel.CENTER);
        nameLabel.setVerticalTextPosition(JLabel.BOTTOM);

        add(imageLabel);



        this.add(nameLabel);
        this.add(costLabel);
        this.add(priceLabel);
        this.add(salesLabel);
        this.add(profitLabel);



    }

}
