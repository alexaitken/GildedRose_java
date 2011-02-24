package com.alexaitken.gildedrose;


public class ConjuredItemUpdater extends ItemUpdater {

	public ConjuredItemUpdater(Item item) {
		super(item);
	}

	@Override
	protected int quantityAdjustment() {
		return super.quantityAdjustment() * 2;
	}

	
	
}
