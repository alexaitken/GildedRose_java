/**
 * 
 */
package com.alexaitken.gildedrose;

public class Item {

	private String name;
	private int sellIn;

	private int quality;

	public Item(String name, int sellIn, int quality) {
		super();
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSellIn() {
		return sellIn;
	}

	public void setSellIn(int sellIn) {
		this.sellIn = sellIn;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}
}