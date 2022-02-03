package com.gildedrose;

public abstract class AbnormalItem extends AbstractItem {

    public AbnormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected void incrementQuality() {
        if (this.quality < 50) {
            this.quality++;
        }
    }

}
