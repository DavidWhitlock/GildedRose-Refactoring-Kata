package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SulfurasTest {

    @Test
    void sameQualityAfter10Days() {
        sameQualityAfter10Days(0, 80);
        sameQualityAfter10Days(-1, 80);
    }

    private void sameQualityAfter10Days(int sellIn, int quality) {
        Sulfuras item = new Sulfuras(sellIn, quality);
        Sulfuras gildedRoseItem = new Sulfuras(sellIn, quality);

        GildedRose rose = new GildedRose(new Item[] { gildedRoseItem });

        for (int day = 0; day < 10; day++) {
            rose.updateQuality();
            item.updateQuality();

            assertThat("Failed sellIn on day " + 0, item.sellIn, equalTo(gildedRoseItem.sellIn));
            assertThat("Failed quality on day " + 0, item.quality, equalTo(gildedRoseItem.quality));

        }
    }

}
