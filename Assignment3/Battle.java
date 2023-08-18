
import java.util.*;

class Human {
    String name;
    int hitPoints;
    int attack;
    
    Human(String name, int hitPoints, int attack) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.attack = attack;
    }
    
    void performAttack(Human target) {
        target.receiveDamage(attack);
    }
    
    void receiveDamage(int damage) {
        hitPoints -= damage;
    }
}

class Hero extends Human {
    boolean highIQ;
    
    Hero(String name, int hitPoints, int attack, boolean highIQ) {
        super(name, hitPoints, attack);
        this.highIQ = highIQ;
        if (highIQ) {
            this.attack += 5;
        }
    }
}

class Monster extends Human {
    boolean bigBody;
    
    Monster(String name, int hitPoints, int attack, boolean bigBody) {
        super(name, hitPoints, attack);
        this.bigBody = bigBody;
        if (bigBody) {
            this.hitPoints += 5;
        }
    }
}

public class Battle{
    public static void main(String [] args) { // args []
        List<Human> characters = new ArrayList<>();// list hold object of human class in ArrayList
        
        // Creating heroes
        Hero hero1 = new Hero("Hero1", 50, 10, true);
        Hero hero2 = new Hero("Hero2", 50, 10, false);
        
        // Creating monsters
        Monster monster1 = new Monster("Monster1", 50, 10, true);
        Monster monster2 = new Monster("Monster2", 50, 10, false);
        
        characters.add(hero1);
        characters.add(hero2);
        characters.add(monster1);
        characters.add(monster2);
        
        // Simulate the battle
        Random random = new Random();
        while (characters.size() > 1) {
            Human attacker = characters.get(random.nextInt(characters.size()));
            Human target = characters.get(random.nextInt(characters.size()));
            
            if (attacker != target) {
                attacker.performAttack(target);
                System.out.println(attacker.name + " attacks " + target.name);
                
                if (target.hitPoints <= 0) {
                    characters.remove(target);
                    System.out.println(target.name + " is defeated.");
                }
            }
        }
        
        // Print the winner
        System.out.println("Winner: " + characters.get(0).name);
    }
}

