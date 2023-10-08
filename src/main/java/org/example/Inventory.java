package org.example;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;
    private Weapon equippedWeapon;

    public Inventory() {
        items = new ArrayList<>();
        equippedWeapon = null;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void equipWeapon(Weapon weapon) {
        equippedWeapon = weapon;
    }

    public void unequipWeapon() {
        equippedWeapon = null;
    }

    public Item getItemByName(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public Weapon getWeaponByName(String weaponName) {
        for (Item item : items) {
            if (item instanceof Weapon && item.getName().equalsIgnoreCase(weaponName)) {
                return (Weapon) item;
            }
        }
        return null;
    }
}
