package ui;

import model.Item;
import model.ListOfItem;

import java.util.Locale;
import java.util.Scanner;

public class ItemApp {
    private ListOfItem itemList;
    private Scanner input;

    public ItemApp() {
        runItem();
    }

    public void runItem() {
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

    private void menu() {
        System.out.println("\nWelcome to the Profit Finder!");
        System.out.println("\nSelect from:");
        System.out.println("\tv -> View your list of Items");
        System.out.println("\ta -> Add an Item");
        System.out.println("\tr -> Remove an Item");
        System.out.println("\ti -> Analyze an Item");
        System.out.println("\tq -> Quit");
    }

    private void initialize() {
        itemList = new ListOfItem();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

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

    private void addItem() {
        System.out.println("Enter Item name:");
        String itemName = input.next();
        System.out.println("Enter the Items Cost:");
        double itemCost = input.nextDouble();
        System.out.println("Enter the Items Price:");
        double itemPrice = input.nextDouble();
        System.out.println("Enter the Items Sales:");
        double itemSales = input.nextDouble();
        System.out.println("Enter the Items Buys:");
        double itemBuys = input.nextDouble();
        itemList.addItem(new Item(itemName,
                itemCost,
                itemPrice,
                itemSales,
                itemBuys));
        System.out.println((itemName) + " has been added to your list of Items:");

    }

    private void viewItems() {
        for (Item i: itemList.getListOfItems()) {
            System.out.println(i.getName());
        }
    }

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

    public void analyzeItem() {
        System.out.println("Enter the name of the item you would like to analyze:");
        String itemName = input.next();
        if (itemList.getItemNames().contains(itemName)) {
            int n = itemList.getItemNames().indexOf(itemName);
            System.out.println("\nSelect an Option!");
            System.out.println("\tcc -> Change Item Cost");
            System.out.println("\tcp -> Change Item Price");
            System.out.println("\tcs -> Change Item Sales");
            System.out.println("\tcb -> Change Item Buys");
            System.out.println("\tp -> View Items Profit");
            System.out.println("\td -> View Item Details");
            String option = input.next();
            if (option.equals("cc")) {
                System.out.println("Enter the new cost $: ");
                double newCost = input.nextDouble();
                itemList.getListOfItems().get(n).changeCost(newCost);
            } else if (option.equals("cp")) {
                System.out.println("Enter the new price $: ");
                double newPrice = input.nextDouble();
                itemList.getListOfItems().get(n).changePrice(newPrice);
            } else if (option.equals("cb")) {
                System.out.println("Enter the new number of buys $: ");
                double newBuys = input.nextDouble();
                itemList.getListOfItems().get(n).changeBuys(newBuys);
            } else if (option.equals("p")) {
                System.out.println("The current profit of this item is "
                        + itemList.getListOfItems().get(n).getProfit() + "$");

            } else if (option.equals("d")) {
                System.out.println("\nItem Details:");
                System.out.println("Name: " + itemList.getListOfItems().get(n).getName());
                System.out.println("Cost: " + itemList.getListOfItems().get(n).getCost());
                System.out.println("Price: " + itemList.getListOfItems().get(n).getPrice());
                System.out.println("Buys: " + itemList.getListOfItems().get(n).getBuys());
                System.out.println("Sales: " + itemList.getListOfItems().get(n).getSales());
                System.out.println("Profit: " + itemList.getListOfItems().get(n).getProfit());

            } else {
                System.out.println("Sorry, your selection is invalid! Please try again");
            }

        } else {
            System.out.println("Sorry, your selection is invalid! Please try again");
        }
    }
}


