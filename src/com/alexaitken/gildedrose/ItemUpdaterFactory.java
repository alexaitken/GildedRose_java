package com.alexaitken.gildedrose;


public class ItemUpdaterFactory {

	public static ItemUpdater createItemUpdator(Item item) {
		if (isLegendaryItem(item)) {
			return new LegendaryItemUpdater(item);
		}
		if (isItemAgedBrie(item)) {
			return new BrieUpdater(item);
		}
		if (isItemBackStagePass(item)) {
			return new BackStagePassItemUpdater(item);
		}
		
		if (isConjuredItem(item)) {
			return new ConjuredItemUpdater(item);
		}

		return new ItemUpdater(item);

	}


	private static boolean isConjuredItem(Item item) {
		return item.getName().equals("Conjured Mana Cake");
	}


	private static boolean isItemAgedBrie(Item item) {
		return item.getName().equals("Aged Brie");
	}

	private static boolean isItemBackStagePass(Item item) {
		return item.getName().equals(
				"Backstage passes to a TAFKAL80ETC concert");
	}

	private static boolean isLegendaryItem(Item item) {
		return item.getName().equals("Sulfuras, Hand of Ragnaros");
	}

}
