package org.example;

//Dette er en simpel MeleeWeapon-klasse, der tager et navn og en skadede som argumenter og arver resten af sin funktionalitet fra den overordnede Weapon-klasse.
// Når getWeaponType() kaldes for MeleeWeapon, returnerer den WeaponType.MELEE, hvilket angiver, at det er et melee våben.

public class MeleeWeapon extends Weapon {
    public MeleeWeapon(String name,String description, int damage) {
        super(name, description, damage);
    }

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.MELEE;
    }
}