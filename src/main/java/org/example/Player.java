package org.example;

import java.util.List;

public class Player {
    private Room currentRoom;
    private Map map;
    private int health = 100;
    private Inventory inventory;
    private UserInterface ui;

    public Player(Map map, UserInterface ui) {
        this.map = map;
        this.currentRoom = map.getCurrentRoom();
        this.inventory = new Inventory();
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

    public void takeItem() {
        ui.displayMessage("Enter the name of the item you want to take: ");
        String itemName = ui.getUserChoice("Enter the name of the item you want to take: ");
        Room currentRoom = getCurrentRoom();
        Item item = currentRoom.getItemByName(itemName);

        if (item != null) {
            inventory.addItem(item);
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
        Item playerItem = inventory.getItemByName(itemName);

        if (playerItem != null) {
            inventory.removeItem(playerItem);
            getCurrentRoom().addItem(playerItem);
            ui.displayMessage("You dropped the " + playerItem.getName() + ".");
        } else {
            ui.displayMessage("You don't have that item in your inventory.");
        }
    }

    public void eatItem() {
        ui.displayInventory();
        ui.displayMessage("Enter the name of the food item you want to eat: ");
        String itemName = ui.getUserChoice("Enter the name of the food item you want to eat: ");
        Item item = inventory.getItemByName(itemName);

        if (item != null && item instanceof Food) {
            Food food = (Food) item;
            food.eat(this);
            inventory.removeItem(food);
            ui.displayMessage("You ate the " + food.getName() + ". It had an effect on your health.");
        } else {
            ui.displayMessage("You don't have that food item in your inventory.");
        }
    }

    public void equipWeapon() {
        ui.displayInventory();
        ui.displayMessage("Enter the name of the weapon you want to equip: ");
        String weaponName = ui.getUserChoice("Enter the name of the weapon you want to equip: ");
        Weapon weapon = inventory.getWeaponByName(weaponName);

        if (weapon != null) {
            inventory.equipWeapon(weapon);
            ui.displayMessage("You have equipped " + weapon.getName() + ".");
        } else {
            ui.displayMessage("You don't have that weapon in your inventory.");
        }
    }

    public void unequipWeapon() {
        Weapon equippedWeapon = inventory.getEquippedWeapon();

        if (equippedWeapon != null) {
            inventory.unequipWeapon();
            ui.displayMessage("You have unequipped the weapon.");
        } else {
            ui.displayMessage("You don't have any weapon equipped.");
        }
    }

    public void attack() {
        Weapon equippedWeapon = inventory.getEquippedWeapon();

        if (equippedWeapon != null) {
            // Implementer angreb med det udstyrede våben her
            ui.displayMessage("You attacked with " + equippedWeapon.getName() + ".");
        } else {
            ui.displayMessage("You need to equip a weapon first.");
        }
    }

    public void displayInventory() {
        ui.displayMessage("Inventory:");
        for (Item item : inventory.getItems()) {
            ui.displayMessage("- " + item.getName());
        }
    }
}
