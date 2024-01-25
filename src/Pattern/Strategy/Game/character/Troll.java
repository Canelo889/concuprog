package Pattern.Strategy.Game.character;

import Pattern.Strategy.Game.weapon.AxeBehavior;

/**
 * Lab 1
 * @author scz
 */
public class Troll extends Character {
    
    public Troll() {
        System.out.println("[character.Troll]");
        this.setWeapon(new AxeBehavior());
    }
}
