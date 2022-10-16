package ui;

import model.Item;
import model.ListOfItem;

import java.util.Locale;
import java.util.Scanner;

// Retail application
public class RetailApp {
    private ListOfItem itemList;
    private Scanner input;

    // EFFECTS: runs the retail application
    public RetailApp() {
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
        System.out.println("\ti -> Analyze an Item");
        System.out.println("\tq -> Quit");
    }

    // MODIFIES: this
    // EFFECTS: initializes ListOfItems
    private void initialize() {
        itemList = new ListOfItem();
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
        } else if (command.equals("i")) {
            analyzeItem();
        } else {
            System.out.println("Sorry, your selection is invalid! Please try again");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds an item (built by the user) to itemList
    private void addItem() {
        System.out.println("Enter Item name:");
        String itemName = input.next();
        System.out.println("Enter the Items Cost ($):");
        double itemCost = input.nextDouble();
        System.out.println("Enter the Items Price ($):");
        double itemPrice = input.nextDouble();
        System.out.println("Enter the Items Sales ($):");
        double itemSales = input.nextDouble();
        itemList.addItem(new Item(itemName,
                itemCost,
                itemPrice,
                itemSales));
        System.out.println((itemName) + " has been added to your list of Items:");

    }

    // EFFECTS: displays names of all items in itemList
    private void viewItems() {
        for (Item i: itemList.getListOfItems()) {
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
            System.out.println(itemName + " has been removed from your list of items:");
        } else {
            System.out.println("Sorry, your selection is invalid! Please try again");
        }

    }

    // MODIFIES: this
    // EFFECTS: gives user option to view or make changes to items of their choice
    public void analyzeItem() {
        System.out.println("Enter the name of the item you would like to analyze:");
        String itemName = input.next();
        if (itemList.getItemNames().contains(itemName)) {
            int n = itemList.getItemNames().indexOf(itemName);
            System.out.println("\nSelect an Option!");
            System.out.println("\tcc -> Change Item Cost");
            System.out.println("\tcp -> Change Item Price");
            System.out.println("\tcs -> Change Item Sales");
            System.out.println("\td -> View Item Details");
            if (input.next().equals("cc")) {
                System.out.println("Enter the new cost $: ");
                itemList.getListOfItems().get(n).changeCost(input.nextDouble());
            } else if (input.next().equals("cp")) {
                System.out.println("Enter the new price $: ");
                itemList.getListOfItems().get(n).changePrice(input.nextDouble());
            } else if (input.next().equals("d")) {
                displayItemDetails(n);
            } else {
                System.out.println("Sorry, your selection is invalid! Please try again");
            }
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
}


