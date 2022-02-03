package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AgedBrieTest extends NonConjuredItemTest {

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
        sameQualityAfter10Days(2, 0);
    }

    @Override
    protected NonConjuredItem createNonConjuredObject(int sellIn, int quality) {
        return new AgedBrie(sellIn, quality);
    }
}
