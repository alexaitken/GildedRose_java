package com.alexaitken.gildedrose;

public class ItemUpdater {

	protected final Item item;
	
	public ItemUpdater(Item item) {
		this.item = item;
	}

	public void updateItem() {
		adjustSellIn();
		adjustQuality();
	}
	
	protected void adjustSellIn() {
		item.setSellIn(item.getSellIn() - 1);
	}
	
	private void adjustQuality() {
		
		int qualityAdjustment = adjustQuantity();
		
		applyAdjustment(item, qualityAdjustment);
	}

	protected int adjustQuantity() {
		int qualityAdjustment = quantityAdjustment();
		
		if (item.getSellIn() < 0) {
			qualityAdjustment *= 2;
		}
		return qualityAdjustment;
	}

	protected int quantityAdjustment() {
		return -1;
	}

	
	private void applyAdjustment(Item item, int qualityAdjustment) {
		int newQuality = item.getQuality() + qualityAdjustment;
		if (newQuality < 0) {
			newQuality = 0;
		}
		if (newQuality > 50) {
			newQuality = 50;
		}
		item.setQuality(newQuality);
	}


}
