package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AgedBrieTest {

    @Test
    void agedBrieIncreasesInQualityAsItGetsOlder() {
        AgedBrie brie = new AgedBrie(2, 0);
        brie.updateQuality();
        assertThat(brie.quality, equalTo(1));
    }

    @Test
    void qualityOfAgedBrieCannotExceed50() {
        AgedBrie brie = new AgedBrie(0, 0);
        brie.updateQuality();
        assertThat(brie.quality, equalTo(2));

        for (int day = 1; day <= 50; day++) {
            brie.updateQuality();
        }

        assertThat(brie.quality, equalTo(50));
    }

    @Test
    void gildedRoseQualityAtZeroDays() {
        AgedBrie brie = new AgedBrie(0, 0);
        new GildedRose(new Item[] {brie}).updateQuality();
        assertThat(brie.quality, equalTo(2));
   }

    @Test
    void sameQualityAfter10Days() {
        int sellIn = 2;
        int quality = 0;
        AgedBrie item = new AgedBrie(sellIn, quality);
        AgedBrie gildedRoseItem = new AgedBrie(sellIn, quality);

        GildedRose rose = new GildedRose(new Item[] { gildedRoseItem });

        for (int day = 0; day < 10; day++) {
            rose.updateQuality();
            item.updateQuality();

            assertThat("Failed sellIn on day " + 0, item.sellIn, equalTo(gildedRoseItem.sellIn));
            assertThat("Failed quality on day " + 0, item.quality, equalTo(gildedRoseItem.quality));

        }
    }
}
