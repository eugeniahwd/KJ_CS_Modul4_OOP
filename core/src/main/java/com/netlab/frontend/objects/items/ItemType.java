package com.netlab.frontend.objects.items;

public enum ItemType {
    POWER(100L, 1),   // +100 score, +1 power bonus
    POINT(1000L, 0),  // +1000 score, +0 power bonus
    BOMB(500L, 0),    // +500 score, +1 spellcard bonus
    LIFE(2000L, 0);   // +2000 score, +20 HP bonus

    private final long scoreValue;
    private final int powerBonus;

    ItemType(long scoreValue, int powerBonus) {
        this.scoreValue = scoreValue;
        this.powerBonus = powerBonus;
    }

    public long getScoreValue() { return scoreValue; }
    public int getPowerBonus() { return powerBonus; }
}
