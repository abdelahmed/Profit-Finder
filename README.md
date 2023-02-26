# Profit Finder
Profit Finder is a simple Java desktop application for tracking the cost, price, and sales of items in order to calculate their profit. It allows the user to add items to a list, view the details of each item, and save/load the list to/from a JSON file.

## Getting Started
###Prerequisites
In order to run Profit Finder, you must have the following software installed on your computer:

- Java Development Kit (JDK) 8 or later
- Apache Maven 3.0 or later
## Installation
1. Clone this repository to your local machine.

2. Navigate to the project directory in your terminal or command prompt.

3. Run the following command to build the application:

mvn clean install

4. Run the following command to start the application:

java -jar target/profit-finder-1.0-SNAPSHOT.jar

## Usage
Upon launching the application, you will see a window with a title bar, a list of items, and several buttons. Here's what each button does:

- Add Item: Click this button to add a new item to the list. You will be prompted to enter the item's name, cost, price, and sales.
- Save: Click this button to save the current list of items to a JSON file.
- Load: Click this button to load a list of items from a JSON file.
- Details: Click this button to view the details of the currently selected item.
To calculate the profit of an item, the application uses the following formula:
