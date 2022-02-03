package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        String itemName = "foo";
        Item[] items = new Item[] { new Item(itemName, 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(itemName, app.items[0].name);
    }

}
