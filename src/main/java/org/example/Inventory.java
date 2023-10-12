package org.example;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;
    private Weapon equippedWeapon; // Nyt felt for det aktuelt udstyrede våben


    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return (List<Item>) items;
    }

    public Item getItemByName(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon weapon) {
        equippedWeapon = weapon;
    }
    public void unequipWeapon() {
        equippedWeapon = null;
    }
}

