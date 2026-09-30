package com.netlab.frontend.objects.items;

import com.badlogic.gdx.graphics.Color;
import com.netlab.frontend.objects.Collidable;
import com.netlab.frontend.objects.GameObject;
import com.netlab.frontend.objects.Player;

public class Item extends GameObject {
    private ItemType itemTypeEnum;
    private String itemType;
    private long scoreValue;

    public Item(float x, float y, ItemType itemTypeEnum) {
        super(x, y, 16, 16, 100f, Color.WHITE);
        this.itemTypeEnum = itemTypeEnum;
        this.itemType = itemTypeEnum.name();
        this.scoreValue = itemTypeEnum.getScoreValue();
    }

    public Item(float x, float y, float width, float height, float speed, String itemType) {
        super(x, y, width, height, speed, Color.WHITE);
        this.itemType = itemType;
        this.itemTypeEnum = ItemType.POINT;
        this.scoreValue = 1000L;
    }

    public Item(float x, float y, float width, float height, float speed, String itemType, long scoreValue) {
        super(x, y, width, height, speed, Color.WHITE);
        this.itemType = itemType;
        this.itemTypeEnum = ItemType.POINT;
        this.scoreValue = scoreValue;
    }

    public Item(float x, float y, float width, float height, float speed, ItemType itemTypeEnum, long scoreValue) {
        super(x, y, width, height, speed, Color.WHITE);
        this.itemTypeEnum = itemTypeEnum;
        this.itemType = itemTypeEnum.name();
        this.scoreValue = scoreValue;
    }

    @Override
    public void update(float delta) {
        // Linear movement downwards
        this.y -= speed * delta;
    }

    @Override
    public void onCollision(Collidable other) {
        if (other instanceof Player) {
            // Item collected logic handled by Player
        }
    }

    public ItemType getItemTypeEnum() { return itemTypeEnum; }
    public String getItemType() { return itemType; }
    public long getScoreValue() { return scoreValue; }
    public void setScoreValue(long scoreValue) { this.scoreValue = scoreValue; }
}
