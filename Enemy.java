// Finished by Danica

/**
Represents an enemy the hero will encounter
*/

import java.util.Random;

public class Enemy extends Entity {

  /**
  Creates the enemy's name and hp
  */
  public Enemy(String n,int mhp) {
    super(n,mhp);
  } 

  /**
  Does some damage and returns how much damage occured
  */
  @Override
  public String attack(Entity e) {
    Random r = new Random();
    int randomDamage = r.nextInt(11) + 1; 
    e.takeDamage(randomDamage);
    return super.getName() + " attacks " + e.getName() + " for " + randomDamage + " damage. ";
  } 
}