package com.gildedrose;

public class BackstagePass extends Item {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);

    }

    public void updateQuality() {
        incrementQuality();

        if (this.sellIn < 11) {
            incrementQuality();

            if (this.sellIn < 6) {
                incrementQuality();
            }
        }

        this.sellIn--;

        if (sellIn < 0) {
            this.quality = 0;
        }

    }

    private void incrementQuality() {
        if (this.quality < 50) {
            this.quality++;
        }
    }
}
