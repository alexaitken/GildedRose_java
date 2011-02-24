package com.alexaitken.gildedrose;

public class BackStagePassItemUpdater extends ItemUpdater {

	public BackStagePassItemUpdater(Item item) {
		super(item);
	}

	@Override
	protected int adjustQuantity() {
		if (item.getSellIn() < 0) {
			return -item.getQuality();
		}

		int qualityAdjustment = 1;	

		if (item.getSellIn() < 10) {
			qualityAdjustment += 1;
		}

		if (item.getSellIn() < 5) {
			qualityAdjustment += 1;
		}

		return qualityAdjustment;
	}

}
