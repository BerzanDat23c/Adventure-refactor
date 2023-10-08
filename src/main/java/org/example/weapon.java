package org.example;

public class Weapon extends Item {
    private int damage;

    public Weapon(String name, int damage) {
        super(name); // Kalder superklassens constructor uden det ekstra argument
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
