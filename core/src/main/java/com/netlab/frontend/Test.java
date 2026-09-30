package com.netlab.frontend;

import com.netlab.frontend.objects.BulletType;
import com.netlab.frontend.objects.GameObject;
import com.netlab.frontend.objects.Player;
import com.netlab.frontend.objects.bullets.Bullet;
import com.netlab.frontend.objects.enemies.Boss;
import com.netlab.frontend.objects.enemies.Enemy;
import com.netlab.frontend.objects.enemies.Fairy;
import com.netlab.frontend.objects.items.Item;
import com.netlab.frontend.objects.items.ItemType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Test runner = new Test(); // Instantiating Test runner instance

        // ==========================================
        // MODULE 1: BASIC CLASSES & OBJECT INTERACTION
        // ==========================================
        System.out.println("=== TOUHOU OOP PRACTICUM - MODULE 1: BASIC CLASSES & OBJECT INTERACTION ===");

        // Instantiating objects (Player and Enemy)
        Player reimu = new Player("Reimu Hakurei", 100, 15, 3);
        Enemy fairyBoss = new Enemy("Cirno (Stage 2 Boss)", 50);

        System.out.println("\n--- Initial Battle State ---");
        System.out.println("Player: " + reimu.getName() + " | HP: " + reimu.getHp() + " | Power: " + reimu.getPower() + " | SpellCards: " + reimu.getSpellCards());
        System.out.println("Enemy:  " + fairyBoss.getName() + " | HP: " + fairyBoss.getHp());

        System.out.println("\n--- Turn 1: Player Shoots Enemy ---");
        reimu.shoot(fairyBoss);

        System.out.println("\n--- Turn 2: Enemy Counter-attacks ---");
        fairyBoss.attack(reimu, 30);

        System.out.println("\n--- Turn 3: Player Shoots Enemy Finishing Blow ---");
        reimu.shoot(fairyBoss);

        System.out.println("\n--- Turn 4: Enemy Deals Fatal Damage to Reimu ---");
        fairyBoss.attack(reimu, 80);

        System.out.println("\n=== Battle Simulation Complete ===");


        // ==========================================
        // MODULE 2: ENCAPSULATION, INHERITANCE & SCORE SYSTEM
        // ==========================================
        System.out.println("\n\n=== TOUHOU OOP PRACTICUM - MODULE 2: ENCAPSULATION, INHERITANCE & SCORE SYSTEM ===");

        // Instantiating polymorphic objects
        Player reimu2 = new Player("Reimu Hakurei", 100, 15, 3);
        Fairy fairy = new Fairy("Stage 1 Fairy", 20);
        Boss cirno = new Boss("Cirno (Stage 2 Boss)", 150);
        Item pointItem = new Item(200, 450, 12, 12, 120f, "Point Item", 1000L);

        System.out.println("\n--- Testing Encapsulation & Inheritance ---");
        System.out.println("Player: " + reimu2.getName() + " | Position: (" + reimu2.getX() + ", " + reimu2.getY() + ")");
        System.out.println("Fairy:  " + fairy.getName() + " | Defeat Worth: " + fairy.getScoreValue() + " pts");
        System.out.println("Boss:   " + cirno.getName() + " | Defeat Worth: " + cirno.getScoreValue() + " pts | Size: " + cirno.getWidth() + "x" + cirno.getHeight());
        System.out.println("Item:   " + pointItem.getItemType() + " | Value: " + pointItem.getScoreValue() + " pts | Speed: " + pointItem.getSpeed());

        System.out.println("\n--- Testing Item Movement Update ---");
        System.out.println("Initial Item Y: " + pointItem.getY());
        pointItem.update(0.5f);
        System.out.println("Item Y after 0.5s update: " + pointItem.getY() + " (linear downward movement)");

        System.out.println("\n--- Testing Scoring System ---");
        System.out.println("Initial Score: " + reimu2.getScore());
        reimu2.shoot(fairy);
        reimu2.collectItem(pointItem);
        reimu2.shoot(cirno);
        System.out.println("Final Score: " + reimu2.getScore() + " pts");

        System.out.println("\n=== Module 2 Test Completed Successfully ===");


        // ==========================================
        // MODULE 3: POLYMORPHISM, ABSTRACTION & COLLISION HANDLING
        // ==========================================
        System.out.println("\n\n=== TOUHOU OOP PRACTICUM - MODULE 3: POLYMORPHISM & ABSTRACTION ===");

        // 1. Testing Abstraction & Enums
        System.out.println("--- Testing ItemType & BulletType Enums ---");
        System.out.println("Available Item Types: " + ItemType.POWER + ", " + ItemType.POINT + ", " + ItemType.BOMB + ", " + ItemType.LIFE);
        System.out.println("Available Bullet Types: " + BulletType.DANMAKU + ", " + BulletType.AMULET + ", " + BulletType.LASER + ", " + BulletType.MASTER_SPARK);

        // 2. Initializing List<GameObject> entities for iterative updates
        List<GameObject> entities = new ArrayList<>();
        Player p = new Player(100, 100, "Reimu Hakurei", 100, 15, 3);
        Fairy f = new Fairy(100, 100, "Stage 1 Fairy", 20);     // Placed at (100, 100) -> Collides with player!
        Boss b = new Boss(200, 200, "Cirno", 150);
        Item item = new Item(300, 300, ItemType.POWER);

        entities.add(p);
        entities.add(f);
        entities.add(b);
        entities.add(item);

        System.out.println("\n--- Testing Iterative Update on List<GameObject> entities ---");
        System.out.println("Initial Item Y: " + item.getY());
        for (GameObject entity : entities) {
            entity.update(0.5f);
        }
        System.out.println("Item Y after entity.update(0.5s): " + item.getY());

        System.out.println("\n--- Testing Polymorphic Collision Information ---");

        // Test 1: Player at (100, 100) collides with Fairy at (100, 100)
        System.out.println("Simulating collision at (100, 100) (Fairy position):");
        if (p.getCoreHitbox().overlaps(f.getCoreHitbox())) {
            p.onCollision(f);
        }

        // Test 2: Move player to Boss at (200, 200)
        p.setX(200);
        p.setY(200);
        System.out.println("Moving player to (200, 200) (Boss position):");
        if (p.getCoreHitbox().overlaps(b.getCoreHitbox())) {
            p.onCollision(b);
        }

        // Test 3: Move player to Item position at (300, item.getY())
        p.setX(300);
        p.setY(item.getY());
        System.out.println("Moving player to (300, " + item.getY() + ") (Item current position):");
        if (p.getCoreHitbox().overlaps(item.getCoreHitbox())) {
            p.onCollision(item);
        }

        System.out.println("\n=== Module 3 Test Completed Successfully ===");


        // ==========================================
        // MODULE 4: COLLECTIONS, GENERICS & ITERATOR SAFE REMOVAL
        // ==========================================
        System.out.println("\n\n=== TOUHOU OOP PRACTICUM - MODULE 4: COLLECTIONS, GENERICS & ITERATORS ===");

        List<GameObject> gameEntities = new ArrayList<>();

        Player player4 = new Player(200, 50, "Reimu Hakurei", 100, 15, 3);
        Fairy targetFairy = new Fairy(200, 200, "Target Fairy", 20); // Placed at y=200, HP 20

        gameEntities.add(player4);
        gameEntities.add(targetFairy);

        System.out.println("\n--- Initial Entities in List<GameObject> ---");
        System.out.println("Entities Count: " + gameEntities.size());

        System.out.println("\n--- Turn 1: Player Fires Bullet ---");
        Bullet bullet1 = player4.shootBullet();
        bullet1.setX(200); // Align bullet X with Fairy
        bullet1.setY(150); // Placed below Fairy at y=150
        gameEntities.add(bullet1);

        System.out.println("Entities Count before update: " + gameEntities.size());

        System.out.println("\n--- Updating frame: Bullet moves upward & collides with Fairy ---");
        // Simulate collision check
        for (int i = 0; i < gameEntities.size(); i++) {
            for (int j = i + 1; j < gameEntities.size(); j++) {
                GameObject e1 = gameEntities.get(i);
                GameObject e2 = gameEntities.get(j);
                if (e1.getCoreHitbox().overlaps(e2.getCoreHitbox())) {
                    e1.onCollision(e2);
                    e2.onCollision(e1);
                }
            }
        }

        // Test non-static instance method updateAndClean<T extends GameObject>
        runner.updateAndClean(gameEntities, 0.125f, 640, 480);

        System.out.println("Entities Count after generic Iterator cleanup: " + gameEntities.size());

        System.out.println("\n--- Turn 2: Bullet Flies Off-Screen ---");
        Bullet offScreenBullet = new Bullet(200, 450, 400f, BulletType.AMULET, 25);
        gameEntities.add(offScreenBullet);
        System.out.println("Initial Offscreen Bullet Y: " + offScreenBullet.getY());

        System.out.println("Updating frame using non-static generic instance method updateAndClean<T> (0.5s movement):");
        runner.updateAndClean(gameEntities, 0.5f, 640, 480);

        System.out.println("Entities Count after off-screen generic Iterator cleanup: " + gameEntities.size());

        System.out.println("\n=== Module 4 Test Completed Successfully ===");
    }

    // Non-static (Instance) Generic Method with Bounded Type Parameter <T extends GameObject>
    public <T extends GameObject> void updateAndClean(List<T> list, float delta, float screenWidth, float screenHeight) {
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            T entity = iterator.next();
            entity.update(delta);

            if (entity.isOffScreen(screenWidth, screenHeight) || entity.isDestroyed()) {
                if (entity.isOffScreen(screenWidth, screenHeight)) {
                    System.out.println("Removed via Generic Iterator (off-screen): " + entity.getClass().getSimpleName() + " at y=" + entity.getY());
                } else {
                    System.out.println("Removed via Generic Iterator (destroyed): " + entity.getClass().getSimpleName());
                }
                iterator.remove(); // Safe removal using Iterator!
            }
        }
    }
}
