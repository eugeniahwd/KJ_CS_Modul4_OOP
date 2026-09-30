package com.netlab.frontend.objects.enemies;

import com.badlogic.gdx.graphics.Color;
import com.netlab.frontend.objects.Collidable;
import com.netlab.frontend.objects.Player;

public class Fairy extends Enemy {
    public Fairy(String name, int hp) {
        super(150, 380, 24, 24, Color.PINK, name, hp, 500L);
    }

    public Fairy(float x, float y, String name, int hp) {
        super(x, y, 24, 24, Color.PINK, name, hp, 500L);
    }

    @Override
    public void onCollision(Collidable other) {
        if (other instanceof Player) {
            System.out.println("Player touches fairy");
        }
    }
}
