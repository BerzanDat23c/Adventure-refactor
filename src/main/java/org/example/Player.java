package org.example;

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

        // Tilføj genstande til spillerens inventar
        Food apple = new Food("Apple", "A red apple", 10);
        Food sandwich = new Food("Sandwich", "A tasty sandwich", 15);
        Food burger = new Food("Burger", "A delicious burger", 20);
        Food carrot = new Food("Carrot", "A fresh carrot", 5);
        Food energyBar = new Food("EnergyBar", "An energy bar", 25);

        inventory.addItem(apple);
        inventory.addItem(sandwich);
        inventory.addItem(burger);
        inventory.addItem(carrot);
        inventory.addItem(energyBar);
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
            ui.displayRoom(currentRoom); // Vis det nye rum
        } else {
            ui.displayMessage("You cannot go that way.");
        }
    }

    public int getHealth() {
        return health;
    }

    private void updateHealthDisplay() {
        ui.displayMessage("Your health: " + health);
    }

    public void changeHealth(int deltaHealth) {
        health += deltaHealth;
        if (health > 100) {
            health = 100;
        }
        if (health <= 0) {
            health = 0;
            ui.displayMessage("You died. Game over!");
        }
    }



    public void takeItem() {
        ui.displayInventory(currentRoom.getItems()); // Vis genstande i det aktuelle rum
        ui.displayMessage("Enter the name of the item you want to take: ");
        String itemName = ui.getUserChoice("Enter the name of the item you want to take: ");
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
        ui.displayInventory(inventory.getItems()); // Vis genstande i spillerens inventar
        ui.displayMessage("Enter the name of the item you want to drop: ");
        String itemName = ui.getUserChoice("Enter the name of the item you want to drop: ");
        Item playerItem = inventory.getItemByName(itemName);

        if (playerItem != null) {
            inventory.removeItem(playerItem);
            currentRoom.addItem(playerItem);
            ui.displayMessage("You dropped the " + playerItem.getName() + ".");
        } else {
            ui.displayMessage("You don't have that item in your inventory.");
        }
    }

    public void eatItem() {
        ui.displayInventory(inventory.getItems()); // Vis genstande i spillerens inventar
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

    public void displayInventory() {
        ui.displayInventory(inventory.getItems()); // Vis genstande i spillerens inventar
    }

    public void attack() {
        Weapon getEquippedWeapon = inventory.getEquippedWeapon();
        if (inventory.getEquippedWeapon() == null) {
            ui.displayMessage("You need to equip a weapon to attack.");
            return;
        }

        if (inventory.getEquippedWeapon() instanceof RangedWeapon) {
            RangedWeapon rangedWeapon = (RangedWeapon) inventory.getEquippedWeapon();
            if (rangedWeapon.canUse()) {
                // Implementer logik for ranged weapon attack her
                ui.displayMessage("You fired your " + rangedWeapon.getName() + ".");
                rangedWeapon.use();
            } else {
                ui.displayMessage("Your " + rangedWeapon.getName() + " is out of ammo.");

                inventory.unequipWeapon();
            }
        } else if (inventory.getEquippedWeapon() instanceof MeleeWeapon) {
            // Implementer logik for melee weapon attack her
            MeleeWeapon meleeWeapon = (MeleeWeapon) inventory.getEquippedWeapon();
            ui.displayMessage("You attacked with your " + meleeWeapon.getName() + ".");
        }
        }
}

