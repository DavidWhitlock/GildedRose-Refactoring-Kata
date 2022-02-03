package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    public void updateQuality() {
        incrementQuality();

        this.sellIn--;

        if (this.sellIn < 0) {
            incrementQuality();
        }
    }

    private void incrementQuality() {
        if (this.quality < 50) {
            this.quality++;
        }
    }
}
