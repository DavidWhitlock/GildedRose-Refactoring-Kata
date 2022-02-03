package com.gildedrose;

public abstract class NonConjuredItem extends Item {
    public NonConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public abstract void updateQuality();

    protected void incrementQuality() {
        if (this.quality < 50) {
            this.quality++;
        }
    }
}
