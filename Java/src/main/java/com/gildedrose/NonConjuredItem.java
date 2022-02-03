package com.gildedrose;

public class NonConjuredItem extends Item {
    public NonConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        decrementQuality();

        this.sellIn--;

        if (this.sellIn < 0) {
            decrementQuality();
        }
    }

    private void decrementQuality() {
        if (this.quality > 0) {
            this.quality--;
        }
    }

    protected void incrementQuality() {
        if (this.quality < 50) {
            this.quality++;
        }
    }
}
