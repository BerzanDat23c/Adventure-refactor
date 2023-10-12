package org.example;

public class Enemy {
    private String name;
    private String description;
    private int health;
    private Weapon weapon;

    public Enemy(String name, String description, int health, Weapon weapon) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void attack(Player player) {
        int damage = weapon.getDamage(); // Beregn skade baseret på våbnets styrke
        player.changeHealth(-damage); // Spilleren mister helbred
    }

    public void hit(int damage) {
        health -= damage;
        if (health <= 0) {
            // Fjenden er død, drop våbnet eller andet og fjern fjenden fra rummet
        }
    }
}
