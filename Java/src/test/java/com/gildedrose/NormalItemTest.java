package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class NormalItemTest extends AbstractItemTestCase {

    @Test
    void qualityDegradesTwiceAsFastAfterSellBy() {
        AbstractItem item = createNonConjuredObject(0, 2);
        item.updateQuality();
        assertThat(item.quality, equalTo(0));
    }

    @Test
    void sameQualityAfter10Days() {
        sameQualityAfter10Days(10, 20);
        sameQualityAfter10Days(5, 7);
    }


    @Override
    protected AbstractItem createNonConjuredObject(int sellIn, int quality) {
        return new NormalItem("Non Conjured", sellIn, quality);
    }
}
