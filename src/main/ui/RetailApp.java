package ui;

import model.Item;
import model.ListOfItem;
import persistence.JsonWriter;
import persistence.JsonReader;


import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.Locale;

// Retail application, took inspiration from Cpsc 210 TellerApp
public class RetailApp {

    private static final String JSON_STORE = "./data/workroom.json";
    private ListOfItem itemList;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    JMenuBar menuBar;
    JMenu itemListMenu;
    JLabel itemListTitle;



    // EFFECTS: runs the retail application
    public RetailApp() {

        input = new Scanner(System.in);
        itemList = new ListOfItem("Abdel's List of Items");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runApp();
    }


    // MODIFIES: this
    // EFFECTS: processes user input
    public void runApp() {
        boolean keepGoing = true;
        String command = null;

        initialize();

        while (keepGoing) {
            menu();
            command = input.next();
            command = command.toLowerCase(Locale.ROOT);

            if (command.equals("q")) {
                keepGoing = false;
                System.out.println("Thank you for using the Profit Finder!");
            } else {
                processCommand(command);
            }
        }
    }

    // EFFECTS: displays menu of options for user to select
    private void menu() {
        System.out.println("\nWelcome to the Profit Finder!");
        System.out.println("\nSelect from:");
        System.out.println("\tv -> View your list of Items");
        System.out.println("\ta -> Add an Item");
        System.out.println("\tr -> Remove an Item");
        System.out.println("\tm -> Modify an Item/View Item Details");
        System.out.println("\ts -> Save a List Of Items");
        System.out.println("\tl -> Load a List Of Items");
        System.out.println("\tq -> Quit");
    }

    // MODIFIES: this
    // EFFECTS: initializes ListOfItems
    private void initialize() {
        itemList = new ListOfItem("Abdel's List of Item");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            addItem();
        } else if (command.equals("r")) {
            removeItem();
        } else if (command.equals("v")) {
            viewItems();
        } else if (command.equals("m")) {
            modifyItem();
        } else if (command.equals("s")) {
            saveListOfItems();
        } else if (command.equals("l")) {
            loadListOfItems();
        } else {
            System.out.println("Sorry, your selection is invalid! Please try again");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds an item (built by the user) to itemList
    private void addItem() {
        System.out.println("Enter Item name:");
        String itemName = input.next();
        if (itemList.getItemNames().contains(itemName)) {
            System.out.println("Sorry, this name has already been used for another item.");
        } else {
            System.out.println("Enter the Items Cost ($):");
            double itemCost = input.nextDouble();
            System.out.println("Enter the Items Price ($):");
            double itemPrice = input.nextDouble();
            System.out.println("Enter the Items Sales:");
            int itemSales = input.nextInt();
            itemList.addItem(new Item(itemName,
                    itemCost,
                    itemPrice,
                    itemSales));
            System.out.println((itemName) + " has been added to your list of Items:");
            itemListMenu.add(itemName);
        }
    }


    // EFFECTS: displays names of all items in itemList
    private void viewItems() {
        for (Item i : itemList.getListOfItems()) {
            System.out.println(i.getName());
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: removes an item (chosen by user bases on name input)
                from itemList
    */
    private void removeItem() {
        System.out.println("Enter the name of the item you would like to remove:");
        String itemName = input.next();
        if (itemList.getItemNames().contains(itemName)) {
            int n = itemList.getItemNames().indexOf(itemName);
            itemList.getItemNames().remove(n);
            itemList.getListOfItems().remove(n);
            System.out.println(itemName + " has been removed from your list of items");
        } else {
            System.out.println("Sorry, your selection is invalid! Please try again");
        }
    }

    // MODIFIES: this
    // EFFECTS: gives user option to view or make changes to items of their choice
    public void modifyItem() {
        System.out.println("Enter the name of the item you would like to analyze:");
        String itemName = input.next();
        if (itemList.getItemNames().contains(itemName)) {
            int n = itemList.getItemNames().indexOf(itemName);
            displayItemDetails(n);
            displayAnalyzeOptions();
            String command = input.next();
            changeItem(command, n);
        } else {
            System.out.println("Sorry, your selection is invalid! Please try again");
        }
    }

    //REQUIRES: n >= 0
    //MODIFIES: this
    //EFFECTS: gives user option to change cost, price, or sales of item,
    // depending on the input entered by the user.
    public void changeItem(String command, int n) {
        if (command.equals("cc")) {
            System.out.println("Enter the new cost $: ");
            itemList.getListOfItems().get(n).changeCost(input.nextDouble());
            displayItemDetails(n);
        } else if (command.equals("cp")) {
            System.out.println("Enter the new price $: ");
            itemList.getListOfItems().get(n).changePrice(input.nextDouble());
            displayItemDetails(n);
        } else if (command.equals("cs")) {
            System.out.println("Enter the new sales: ");
            itemList.getListOfItems().get(n).changeSales(input.nextInt());
            displayItemDetails(n);
        } else {
            System.out.println("Sorry, your selection is invalid! Please try again");
        }
    }

    // REQUIRES: n >= 0
    // EFFECTS: displays details of certain item (n) in itemList
    public void displayItemDetails(int n) {
        System.out.println("\nItem Details:");
        System.out.println("Name: " + itemList.getListOfItems().get(n).getName());
        System.out.println("Cost: " + itemList.getListOfItems().get(n).getCost());
        System.out.println("Price: " + itemList.getListOfItems().get(n).getPrice());
        System.out.println("Sales: " + itemList.getListOfItems().get(n).getSales());
        System.out.println("Profit: " + itemList.getListOfItems().get(n).getProfit());
    }

    // EFFECTS: displays options for user to input when analyzing an item
    public void displayAnalyzeOptions() {
        System.out.println("\nSelect an Option!");
        System.out.println("\tcc -> Change Item Cost");
        System.out.println("\tcp -> Change Item Price");
        System.out.println("\tcs -> Change Item Sales");
    }

    private void saveListOfItems() {
        try {
            jsonWriter.open();
            jsonWriter.write(itemList);
            jsonWriter.close();
            System.out.println("Saved " + itemList.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadListOfItems() {
        try {
            itemList = jsonReader.read();
            System.out.println("Loaded " + itemList.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}
