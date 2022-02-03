package com.gildedrose;

public class AgedBrie extends NonConjuredItem {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        incrementQuality();

        this.sellIn--;

        if (this.sellIn < 0) {
            incrementQuality();
        }
    }

}
