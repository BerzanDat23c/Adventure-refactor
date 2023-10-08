package org.example;

public class RangedWeapon extends Weapon {
    private int remainingAmmo;

    public RangedWeapon(String name, String description, int damage, int remainingAmmo) {
        super(name, description, damage);
        this.remainingAmmo = remainingAmmo;
    }

    public int getRemainingAmmo() {
        return remainingAmmo;
    }

    public void use() {
        if (remainingAmmo > 0) {
            remainingAmmo--;
        }
    }
}
