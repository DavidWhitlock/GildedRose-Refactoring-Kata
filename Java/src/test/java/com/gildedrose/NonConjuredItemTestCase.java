package com.gildedrose;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public abstract class NonConjuredItemTestCase {
    protected void sameQualityAfter10Days(NonConjuredItem item, Item gildedRoseItem) {
        GildedRose rose = new GildedRose(new Item[] {gildedRoseItem});

        for (int day = 0; day < 10; day++) {
            rose.updateQuality();
            item.updateQuality();

            assertThat("Failed sellIn on day " + 0, item.sellIn, equalTo(gildedRoseItem.sellIn));
            assertThat("Failed quality on day " + 0, item.quality, equalTo(gildedRoseItem.quality));

        }
    }

    protected void sameQualityAfter10Days(int sellIn, int quality) {
        sameQualityAfter10Days(createNonConjuredObject(sellIn, quality), createNonConjuredObject(sellIn, quality));
    }

    protected abstract NonConjuredItem createNonConjuredObject(int sellIn, int quality);
}
