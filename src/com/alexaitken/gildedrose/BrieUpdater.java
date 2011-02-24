package com.alexaitken.gildedrose;

public class BrieUpdater extends ItemUpdater {

	public BrieUpdater(Item item) {
		super(item);
	}

	@Override
	protected int quantityAdjustment() {
		return 1;
	}

	
	

}
