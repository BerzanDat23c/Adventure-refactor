package org.example;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private List<Item> items;
    private List<Weapon> weapons;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.weapons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item getItemByName(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("No items in the room.");
        } else {
            System.out.println("Items in the room:");
            for (Item item : items) {
                System.out.println("- " + item.getName());
            }
        }
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    public Weapon getWeaponByName(String weaponName) {
        for (Weapon weapon : weapons) {
            if (weapon.getName().equalsIgnoreCase(weaponName)) {
                return weapon;
            }
        }
        return null;
    }

    public void removeWeapon(Weapon weapon) {
        weapons.remove(weapon);
    }

    public void displayWeapons() {
        if (weapons.isEmpty()) {
            System.out.println("No weapons in the room.");
        } else {
            System.out.println("Weapons in the room:");
            for (Weapon weapon : weapons) {
                System.out.println("- " + weapon.getName());
            }
        }
    }
}
