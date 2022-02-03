package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ConjuredItemTest {

    @Test
    void degradeInQualityTwiceAsFastAsNormal() {

        ConjuredItem item = new ConjuredItem("Conjured", 10, 2);
        item.updateQuality();
        assertThat(item.quality, equalTo(0));
    }
}
