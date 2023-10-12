package org.example;

public class RangedWeapon extends Weapon {
    private int usesRemaining;

    public RangedWeapon(String name, String description, int damage, int uses) {
        super(name, description, damage);
        this.usesRemaining = uses;
    }

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.RANGED;
    }

    public int getUsesRemaining() {
        return usesRemaining;
    }

    public boolean canUse() {
        return usesRemaining > 0;
    }

    public int use() {
        if (canUse()) {
            this.usesRemaining--;
        }
        return 0;
    }
}
