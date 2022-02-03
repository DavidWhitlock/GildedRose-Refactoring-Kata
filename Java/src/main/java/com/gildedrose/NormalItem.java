package com.gildedrose;

public class NormalItem extends AbstractItem {
    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
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

}
