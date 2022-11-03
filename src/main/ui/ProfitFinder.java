package ui;

import model.Item;
import model.ListOfItem;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ProfitFinder extends JFrame {

    private ListOfItem list;
    private Title title;
    private ButtonPanel buttonPanel;

    private JButton addItem;


    public ProfitFinder() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,700);
        this.setVisible(true);

        title = new Title();
        list = new ListOfItem("My List of Items");
        buttonPanel = new ButtonPanel();

        this.add(title,BorderLayout.NORTH);
        this.add(buttonPanel,BorderLayout.SOUTH);
        this.add(list, BorderLayout.CENTER);

        addItem = buttonPanel.getAddItem();
        addListeners();

    }

    public void addListeners() {
        addItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String name = JOptionPane.showInputDialog("Enter the Items name");
                int cost = Integer.parseInt(JOptionPane.showInputDialog("Enter the Items cost"));
                int price = Integer.parseInt(JOptionPane.showInputDialog("Enter the Items price"));
                int sales = Integer.parseInt(JOptionPane.showInputDialog("Enter the Items sales"));

                Item item = new Item(name,cost,price,sales);
                list.add(item);

                item.getDetails().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        new ItemDetails(item);

                    }
                });
                revalidate();
            }

        });

    }


}
