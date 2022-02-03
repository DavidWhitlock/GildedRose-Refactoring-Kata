package com.gildedrose;

public class NonConjuredItem extends Item {
    public NonConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        if (this.quality > 0) {
            this.quality--;
        }

        this.sellIn--;

        if (this.sellIn < 0) {
            if (this.quality > 0) {
                this.quality--;
            }
        }
    }

    protected void incrementQuality() {
        if (this.quality < 50) {
            this.quality++;
        }
    }
}
