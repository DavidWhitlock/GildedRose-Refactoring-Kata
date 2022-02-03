package com.gildedrose;

import org.junit.jupiter.api.Test;

public class SulfurasTest extends NonConjuredItemTest {

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
