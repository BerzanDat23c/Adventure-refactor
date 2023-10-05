package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Room currentRoom;
    private Map map;
    private int health;
    private List<Item> inventory;
    private UserInterface ui;

    public Player(Map map, UserInterface ui) {
        this.map = map;
        this.currentRoom = map.getCurrentRoom();
        this.health = 100;
        this.inventory = new ArrayList<>();
        this.ui = ui;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void move(String direction) {
        Room newRoom = null;

        switch (direction) {
            case "north":
                newRoom = currentRoom.getNorth();
                break;
            case "east":
                newRoom = currentRoom.getEast();
                break;
            case "south":
                newRoom = currentRoom.getSouth();
                break;
            case "west":
                newRoom = currentRoom.getWest();
                break;
        }

        if (newRoom != null) {
            currentRoom = newRoom;
            ui.displayMessage("You have moved to the " + direction + ".");
        } else {
            ui.displayMessage("You cannot go that way.");
        }
    }

    public void changeHealth(int deltaHealth) {
        health += deltaHealth;
        if (health > 100) {
            health = 100;
        }
        if (health < 0) {
            health = 0;
            ui.displayMessage("You died. Game over!");
        }
    }

    public int getHealth() {
        return health;
    }

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    public void removeItemFromInventory(Item item) {
        inventory.remove(item);
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public Item getItemByName(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void displayInventory() {
        ui.displayMessage("Inventory:");
        for (Item item : inventory) {
            ui.displayMessage("- " + item.getName());
        }
    }

    public void interactWithItem() {
        // Implementer interaktion med genstande her
    }

    public void takeItem() {
        ui.displayMessage("Enter the name of the item you want to take: ");
        String itemName = ui.getUserChoice("Enter the name of the item you want to take: ");
        Room currentRoom = getCurrentRoom();
        Item item = currentRoom.getItemByName(itemName);

        if (item != null) {
            addItemToInventory(item);
            currentRoom.removeItem(item);
            ui.displayMessage("You took the " + item.getName() + ".");
        } else {
            ui.displayMessage("There is no such item in this room.");
        }
    }

    public void dropItem() {
        ui.displayInventory();
        ui.displayMessage("Enter the name of the item you want to drop: ");
        String itemName = ui.getUserChoice("Enter the name of the item you want to drop: ");
        Item playerItem = getItemByName(itemName);

        if (playerItem != null) {
            removeItemFromInventory(playerItem);
            getCurrentRoom().addItem(playerItem);
            ui.displayMessage("You dropped the " + playerItem.getName() + ".");
        } else {
            ui.displayMessage("You don't have that item in your inventory.");
        }
    }

    public void eatItem() {
        ui.displayInventory();
        ui.displayMessage("Enter the name of the item you want to eat: ");
        String itemName = ui.getUserChoice("Enter the name of the item you want to eat: ");
        Item item = getItemByName(itemName);

        if (item != null && item instanceof Food) {
            Food food = (Food) item;
            food.eat(this);
            removeItemFromInventory(food);
            ui.displayMessage("You ate the " + food.getName() + ". It had an effect on your health.");
        } else {
            ui.displayMessage("You don't have that food item in your inventory.");
        }
    }
}
