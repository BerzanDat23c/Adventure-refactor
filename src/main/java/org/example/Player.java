package org.example;

public class Player {

    public Player(Map map) {

    }

    public void interactWithItem(UserInterface ui) {
        String choice = ui.chooseItemFromInventory(this);
        Item item = getItemByName(choice);

        if (item != null) {
            String action = ui.getUserChoice("What do you want to do with the " + item.getName() + " (take/drop/eat)? ");
            switch (action) {
                case "take":
                    addItemToInventory(item);
                    getCurrentRoom().removeItem((Food) item);
                    System.out.println("You took the " + item.getName() + ".");
                    break;
                case "drop":
                    removeItemFromInventory(item);
                    getCurrentRoom().addItem((Food) item);
                    System.out.println("You dropped the " + item.getName() + ".");
                    break;
                case "eat":
                    if (item instanceof Food) {
                        Food food = (Food) item;
                        food.eat(this);
                        getCurrentRoom().removeItem((Food) item);
                        System.out.println("You ate " + food.getName() + " and gained " + food.getHealthPoints() + " health.");
                    } else {
                        System.out.println("You cannot eat that.");
                    }
                    break;
                default:
                    System.out.println("Invalid action.");
            }
        } else {
            System.out.println("You don't have that item in your inventory.");
        }
    }

    Room getCurrentRoom() {
        return null;
    }

    private void removeItemFromInventory(Item item) {

    }

    private void addItemToInventory(Item item) {

    }

    private Item getItemByName(String choice) {
        return null;
    }

    public void displayInventory() {
    }

    public void move(String direction) {

    }
}
