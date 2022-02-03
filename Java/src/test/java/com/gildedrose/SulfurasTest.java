package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SulfurasTest extends NonConjuredItemTest {

    @Test
    public void qualityNeverChanges() {
        int quality = 100;
        Sulfuras sulfuras = new Sulfuras(10, quality);
        for (int day = 0; day < 100; day++) {
            assertThat(sulfuras.quality, equalTo(quality));
        }
    }

    @Test
    void sameQualityAfter10Days() {
        sameQualityAfter10Days(0, 80);
        sameQualityAfter10Days(-1, 80);
    }

    @Override
    protected Sulfuras createNonConjuredObject(int sellIn, int quality) {
        return new Sulfuras(sellIn, quality);
    }

}
