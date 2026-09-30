package com.netlab.frontend.objects.bullets;

import com.badlogic.gdx.graphics.Color;
import com.netlab.frontend.objects.BulletType;
import com.netlab.frontend.objects.Collidable;
import com.netlab.frontend.objects.GameObject;
import com.netlab.frontend.objects.enemies.Enemy;

public class Bullet extends GameObject {
    private BulletType bulletType;
    private int damage;

    public Bullet(float x, float y, BulletType bulletType, int damage) {
        super(x, y, 8, 16, 400f, Color.YELLOW);
        this.bulletType = bulletType;
        this.damage = damage;
    }

    public Bullet(float x, float y, float speed, BulletType bulletType, int damage) {
        super(x, y, 8, 16, speed, Color.YELLOW);
        this.bulletType = bulletType;
        this.damage = damage;
    }

    @Override
    public void update(float delta) {
        // Bullet moves upwards linearly
        this.y += speed * delta;
    }

    @Override
    public void onCollision(Collidable other) {
        if (other instanceof Enemy enemy) {
            System.out.println("Bullet hit " + enemy.getName() + " for " + damage + " DMG!");
            boolean defeated = enemy.takeDamage(damage);
            this.destroy(); // Bullet is destroyed on collision
        }
    }

    public BulletType getBulletType() { return bulletType; }
    public int getDamage() { return damage; }
}
