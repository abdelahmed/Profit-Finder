package ui;

import model.Item;
import model.ListOfItem;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ProfitFinder extends JFrame {
    private static final String JSON_STORE = "./data/workroom.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    private ListOfItem list;
    private Title title;
    private ButtonPanel buttonPanel;
    private JButton addItem;
    private JButton save;
    private JButton load;
    private JButton yes;






    public ProfitFinder() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,700);
        this.setVisible(true);
        this.setBackground(Color.BLACK);

        title = new Title();
        list = new ListOfItem("My List of Items");
        buttonPanel = new ButtonPanel();

        this.add(title,BorderLayout.NORTH);
        this.add(buttonPanel,BorderLayout.SOUTH);
        addList(list);

        addItem = buttonPanel.getAddItem();
        save = buttonPanel.getSave();
        load = buttonPanel.getLoad();
        addListeners();
        addSave();
        addLoad();

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

    }

    public void addList(ListOfItem listOfItem) {

        for (Item item : listOfItem.getListOfItems()) {
            list.add(item);

            item.getDetails().addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    new ItemDetails(item);
                }
            });

        }
        this.add(list);
        this.setVisible(true);
    }

    private void saveListOfItems(ListOfItem itemList) {
        try {
            jsonWriter.open();
            jsonWriter.write(itemList);
            jsonWriter.close();
            JOptionPane.showMessageDialog(null,"Saved " + JSON_STORE + itemList.getListOfItems().size());
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Unable to save file " + JSON_STORE);
        }

    }

    private void loadListOfItems() {
        try {
            list = jsonReader.read();
            JOptionPane.showMessageDialog(yes,"Loaded " + list.getName() + " from " + JSON_STORE);
            new ItemDetails(list.getListOfItems().get(0));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Unable to read from file: " + JSON_STORE);
        }
    }

    public void addListeners() {
        addItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String name = JOptionPane.showInputDialog("Enter the Items name");
                double cost = Double.parseDouble(JOptionPane.showInputDialog("Enter the Items cost ($)"));
                double price = Double.parseDouble(JOptionPane.showInputDialog("Enter the Items price ($)"));
                int sales = Integer.parseInt(JOptionPane.showInputDialog("Enter the Items sales"));

                Item item = new Item(name,cost,price,sales);
                list.getListOfItems().add(item);
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

    public void addSave() {
        save.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    jsonWriter.open();
                    jsonWriter.write(list);
                    jsonWriter.close();
                    JOptionPane.showMessageDialog(null,"Saved " + JSON_STORE + " " + list.getListOfItems().size());
                } catch (FileNotFoundException er) {
                    JOptionPane.showMessageDialog(null,"Unable to save file " + JSON_STORE);
                }
            }

        });

        revalidate();
    }

    public void addLoad() {
        load.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    list = jsonReader.read();
                    JOptionPane.showMessageDialog(yes,"Loaded " + list.getName() + " from " + JSON_STORE);
                    addList(list);

                } catch (IOException er) {
                    JOptionPane.showMessageDialog(null,"Unable to read from file: " + JSON_STORE);
                }
            }

        });

        revalidate();

    }










}