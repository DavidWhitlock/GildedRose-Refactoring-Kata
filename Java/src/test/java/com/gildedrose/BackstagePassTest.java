package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BackstagePassTest extends NonConjuredItemTest {

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

    @Override
    protected NonConjuredItem createNonConjuredObject(int sellIn, int quality) {
        return new BackstagePass(sellIn, quality);
    }

}
