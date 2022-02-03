package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BackstagePassTest {

    @Test
    void qualityIncreaseBy2When10DaysLeft() {
        BackstagePass pass = new BackstagePass(10, 0);
        pass.updateQuality();
        assertThat(pass.quality, equalTo(2));
    }

    @Test
    void qualityIncreasesBy3When5DaysLeft() {
        BackstagePass pass = new BackstagePass(5, 0);
        pass.updateQuality();
        assertThat(pass.quality, equalTo(3));
    }

    @Test
    void sameQualityAfter10Days() {
        sameQualityAfter10Days(15, 20);
        sameQualityAfter10Days(10, 49);
        sameQualityAfter10Days(5, 49);
    }

    private void sameQualityAfter10Days(int sellIn, int quality) {
        BackstagePass item = new BackstagePass(sellIn, quality);
        BackstagePass gildedRoseItem = new BackstagePass(sellIn, quality);

        GildedRose rose = new GildedRose(new Item[] { gildedRoseItem });

        for (int day = 0; day < 10; day++) {
            rose.updateQuality();
            item.updateQuality();

            assertThat("Failed sellIn on day " + 0, item.sellIn, equalTo(gildedRoseItem.sellIn));
            assertThat("Failed quality on day " + 0, item.quality, equalTo(gildedRoseItem.quality));

        }
    }

}
