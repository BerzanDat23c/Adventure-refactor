package org.example;

//Bemærk, at Weapon er blevet ændret til en abstrakt klasse for at give plads til subklasser, som du skal oprette for MeleeWeapon og RangedWeapon.

public abstract class Weapon extends Item {
    private int damage;
    private int uses; // Track the remaining uses for ranged weapons

    public Weapon(String name, String description, int damage) {
        super(name, description);
        this.damage = damage;
        this.uses = -1; // Set to -1 to indicate unlimited uses by default
    }

   /* public Weapon(String name, int damage, int uses) {
        this.name = name;
        this.damage = damage;
        this.uses = uses; // Set the remaining uses for ranged weapons
    }*/

    public abstract WeaponType getWeaponType();

    public int use() {
        if (uses == 0) {
            System.out.println("This weapon is out of uses.");
            return 0; // Våbnet kan ikke bruges, fordi det er løbet tør for brug
        }

        if (uses > 0) {
            uses--;
        }

        return damage;
    }

    public int getRemainingUses() {
        return uses;
    }

    public int getDamage() {
        return damage;
    }

    public int getUse() {
        return use();
    }

            //public abstract WeaponType getWeaponType();
}