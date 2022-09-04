// Finished by Danica

/**
Describes user that is represented by the character
*/

import java.awt.Point;
import java.util.Random;
import java.io.FileNotFoundException;

public class Hero extends Entity implements Magical {
  private Map map;
  private Point loc;
  private int level;

  /**
  Creates a hero with a map, hp, and new Map starting at level 1
  */
  public Hero(String n) {
    super(n, 25); 
    level = 1;
    map = new Map();
    try{
      map.loadMap(level);
    } catch (FileNotFoundException e) {
      System.out.println("File was not found.");
    }
    loc = new Point(map.findStart());
  }

  /**
  Displays the hero, hp/maxHp, level, and map
  */
  @Override
  public String toString() {
    return (super.getName() + "\nHP: " + super.getHP() + "/" + super.getMaxHP() + "\nLevel: " + level + "\n" + map.mapToString(loc)); 
  }

  /**
  Does a different amount of damage and returns how much damage occured through a String
  */
  @Override
  public String attack(Entity e) {
    int damage = 0;
    damage = (int) (Math.random() * (3) + 1);
    e.takeDamage(damage);
    return (super.getName() + " attacks " + e.getName() + " for " + damage + " damage. ");
  }

  /**
  Increases the hero's level and loads the next map
  */
  public void levelUp() { 
    level = level + 1;
    if(level % 3 == 0) {
      try{
        map.loadMap(3);
        loc = map.findStart();
      }
      catch (FileNotFoundException e) {
        System.out.println("File was not found.");
      }
    }
    if (level % 3 == 1) { 
      try{
        map.loadMap(1);
        loc = map.findStart();
      } 
      catch (FileNotFoundException e) {
        System.out.println("File was not found.");
      }
    }
    if(level % 3 == 2) {
      try{
        map.loadMap(2);
        loc = map.findStart();
      }
      catch (FileNotFoundException e) {
        System.out.println("File was not found.");
      }
    }
  }

  /**
  Changes the hero's location by going North
  Then reveals and gets the character at the location
  */
  public char goNorth(){
    map.removeCharAtLoc(loc);
    loc.translate(-1, 0);     // Goes up
    if (loc.getX() < 0) { 
      System.out.println("Out of bounds.");
      loc.translate(1, 0);
    }
    map.reveal(loc);
    return map.getCharAtLoc(loc);
  }

  /**
  Changes the hero's location by going South
  Then reveals and gets the character at the location
  */
  public char goSouth(){
    map.removeCharAtLoc(loc);
    loc.translate(1, 0);      // Goes down
    if (loc.getX() > 4){
      System.out.println("Out of bounds.");
      loc.translate(-1, 0);
    }
    map.reveal(loc);
    return map.getCharAtLoc(loc);
  }

  /**
  Changes the hero's location by going West
  Then reveals and gets the character at the location
  */
  public char goWest(){
    map.removeCharAtLoc(loc);
    loc.translate(0, -1);     // Goes left
    if (loc.getY() < 0){
      System.out.println("Out of bounds.");
      loc.translate(0, 1);
    }
    map.reveal(loc);
    return map.getCharAtLoc(loc);
  }

  /**
  Changes the hero's location by going East
  Then reveals and gets the character at the location
  */
  public char goEast(){
    map.removeCharAtLoc(loc);
    loc.translate(0, 1);      // Goes right
    if (loc.getY() > 4){
      System.out.println("Out of bounds.");
      loc.translate(0, -1);
    }
    map.reveal(loc);
    return map.getCharAtLoc(loc);
  }

  /**
  Magic Missile randomly does an amount of damage and returns how much damage occured
  */
  @Override
  public String magicMissile(Entity e) {
    Random r = new Random();
    int randomDamage = r.nextInt(4) + 1; 
    e.takeDamage(randomDamage);
    return (super.getName() + " hits " + e.getName() + " with a Magical Missile for " + randomDamage + " damage. ");
  }

  /**
  Fireball randomly does an amount of damage and returns how much damage occured
  */
  @Override
  public String fireball(Entity e) {
    Random r = new Random();
    int randDamage = r.nextInt(1) + 1;
    e.takeDamage(randDamage);
    return (super.getName() + " hits " + e.getName() + " with a Fireball for " + randDamage + " damage. ");
  }

  /**
  Thunderclap randomly does an amount of damage and returns how much damage occured
  */
  @Override
  public String thunderclap(Entity e) {
    Random r = new Random();
    int randDamage = r.nextInt(6) + 1; 
    e.takeDamage(randDamage);
    return (e.getName() + " zaps " + super.getName() + " with a Thunderclap for " + randDamage + " damage. ");
  }
}