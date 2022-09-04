// Finished by Danica

/**
Creates random enemies to be encountered
*/

import java.util.Random;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class EnemyGenerator {
  private ArrayList <Enemy> enemylist  = new ArrayList<Enemy>();

  /**
  Reads the Enemies.txt file and adds different enemies to the ArrayList
  */
  public EnemyGenerator() {
    try {
    	File f = new File("Enemies.txt");
    	Scanner scan = new Scanner(f);
    	while(scan.hasNextLine()) {
    		String line = scan.nextLine();
    		String [] details = line.split(",");
    		String name = details[0];
    		int maxHp = Integer.parseInt(details[1]);
    		Enemy e = new Enemy (name, maxHp);
    		enemylist.add(e);
    	}
    } catch(FileNotFoundException e) {
      System.out.println("File was not found.");
    }
  }
  
  /**
  Ranomly picks an enemy from the ArrayList,
  Randomly picks either an Enemy or Magical Enemy,
  Copies the name and hp to create a new enemy
  */
  public Enemy generateEnemy() {
	  Random r = new Random();
	  int randEnemy = r.nextInt(enemylist.size() - 1);
	  Enemy e = enemylist.get(randEnemy);
	  int randType = r.nextInt(2) + 1;
	  if(randType == 1) {
		  Enemy enemy = new MagicalEnemy("Magical " + e.getName(), e.getMaxHP());
		  return enemy; 
	  } else {
		  Enemy enemy = new Enemy(e.getName(), e.getMaxHP());
		  return enemy;
	  }
	}
}