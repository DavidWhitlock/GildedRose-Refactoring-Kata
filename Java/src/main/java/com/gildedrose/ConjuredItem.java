package com.gildedrose;

public class ConjuredItem extends NormalItem {
    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected int getDecrement() {
        return 2;
    }
}
