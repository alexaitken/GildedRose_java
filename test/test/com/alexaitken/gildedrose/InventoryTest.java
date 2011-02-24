package test.com.alexaitken.gildedrose;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.alexaitken.gildedrose.Inventory;
import com.alexaitken.gildedrose.Item;


public class InventoryTest {
//	new Item("+5 Dexterity Vest", 10, 20), 
//	new Item("Aged Brie", 2, 0),
//	new Item("Elixir of the Mongoose", 5, 7),
//	new Item("Sulfuras, Hand of Ragnaros", 0, 80),
//	new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
//	new Item("Conjured Mana Cake", 3, 6)
	
	@Test
	public void should_never_changes_quailty_of_Sulfuras() throws Exception {
		Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
		
		Inventory sut = new Inventory((Item[]) Arrays.asList(new Item("Sulfuras, Hand of Ragnaros", 0, 80)).toArray());
		
		sut.updateQuality();
		
		assertEquals(80, sulfuras.getQuality());
		
		
	}
	@Test
	public void should_never_changes_sellIn_of_Sulfuras() throws Exception {
		Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
		
		Inventory sut = new Inventory((Item[]) Arrays.asList(sulfuras).toArray());
		
		sut.updateQuality();
		
		assertEquals(0, sulfuras.getSellIn());
		
		
	}
	
	
	
	@Test
	public void should_lower_the_sellIn_by_one_for_normal_items() throws Exception {
		Item normalItem = new Item("+5 Dexterity Vest", 10, 20);
		
		Inventory sut = new Inventory((Item[]) Arrays.asList(normalItem).toArray());
		
		sut.updateQuality();
		
		
		assertEquals(9, normalItem.getSellIn());
	}
	
	@Test
	public void should_lower_the_quality_by_one_for_normal_items() throws Exception {
		Item normalItem = new Item("+5 Dexterity Vest", 10, 20);
		
		Inventory sut = new Inventory((Item[]) Arrays.asList(normalItem).toArray());
		
		sut.updateQuality();
		
		
		assertEquals(19, normalItem.getQuality());
	}
	
	@Test
	public void should_not_lower_the_quality_below_zero() throws Exception {
		Item normalItem = new Item("+5 Dexterity Vest", 10, 0);
		
		Inventory sut = new Inventory((Item[]) Arrays.asList(normalItem).toArray());
		
		sut.updateQuality();
		
		
		assertEquals(0, normalItem.getQuality());
	}
	
	@Test
	public void should_lower_the_quality_twice_as_fast_once_the_sell_in_date_has_passed() throws Exception {
		Item normalItem = new Item("+5 Dexterity Vest", -1, 25);
		
		Inventory sut = new Inventory((Item[]) Arrays.asList(normalItem).toArray());
		
		sut.updateQuality();
		
		
		assertEquals(23, normalItem.getQuality());
	}
	
	
	@Test
	public void should_increase_the_quality_of_aged_brie_as_it_gets_older() throws Exception {
		Item agedBrie = new Item("Aged Brie", 10, 25);
		
		Inventory sut = new Inventory((Item[]) Arrays.asList(agedBrie).toArray());
		
		sut.updateQuality();
		
		
		assertEquals(26, agedBrie.getQuality());
	}
	
	@Test
	public void should_double_the_increase_in_quality_of_aged_brie_after_its_sell_by_date_has_passed() throws Exception {
		Item agedBrie = new Item("Aged Brie", -2, 25);
		
		Inventory sut = new Inventory((Item[]) Arrays.asList(agedBrie).toArray());
		
		sut.updateQuality();
		
		
		assertEquals(27, agedBrie.getQuality());
	}
	
	
	@Test
	public void should_not_increase_the_quality_of_aged_brie_over_50() throws Exception {
		Item agedBrie = new Item("Aged Brie", 10, 50);
		
		Inventory sut = new Inventory((Item[]) Arrays.asList(agedBrie).toArray());
		
		sut.updateQuality();
		
		
		assertEquals(50, agedBrie.getQuality());
	}
	
	@Test
	public void should_lower_backstage_passes_to_zero_quality_once_concert_has_happened() throws Exception {
		Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20);
		
		Inventory sut = new Inventory((Item[]) Arrays.asList(backStagePass).toArray());
		
		sut.updateQuality();
		
		
		assertEquals(0, backStagePass.getQuality());
	}
	
	@Test
	public void should_increase_backstage_passes_quality_by_1_when_the_concert_is_more_than_10_days_away() throws Exception {
		Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);
		
		Inventory sut = new Inventory((Item[]) Arrays.asList(backStagePass).toArray());
		
		sut.updateQuality();
		
		
		assertEquals(21, backStagePass.getQuality());
	}
	
	@Test
	public void should_increase_backstage_passes_quality_by_2_when_the_concert_is_10_days_or_less_away() throws Exception {
		Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 27);
		
		Inventory sut = new Inventory((Item[]) Arrays.asList(backStagePass).toArray());
		
		sut.updateQuality();
		
		
		assertEquals(29, backStagePass.getQuality());
	}
	
	@Test
	public void should_increase_backstage_passes_quality_by_3_when_the_concert_is_5_days_or_less_away() throws Exception {
		Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 44);
		
		Inventory sut = new Inventory((Item[]) Arrays.asList(backStagePass).toArray());
		
		sut.updateQuality();
		
		
		assertEquals(47, backStagePass.getQuality());
	}
	
	@Test
	public void should_not_increase_backstage_passes_above_a_quality_of_50() throws Exception {
		Item backStagePassMoreThan10DaysAway = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50);
		
		Item backStagePass10DaysAway = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
		Item backStagePass5DaysAway = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48);
		
		Inventory sut = new Inventory((Item[]) Arrays.asList(backStagePassMoreThan10DaysAway, backStagePass10DaysAway, backStagePass5DaysAway).toArray());
		
		sut.updateQuality();
		
		
		assertEquals(50, backStagePassMoreThan10DaysAway.getQuality());
		assertEquals(50, backStagePass10DaysAway.getQuality());
		assertEquals(50, backStagePass5DaysAway.getQuality());
	}
	
	
	@Test
	public void should_reduce_conjured_item_by_2_when_sell_in_date_has_not_passed() throws Exception {
		Item conjuredItem = new Item("Conjured Mana Cake", 3, 6);
		
		Inventory sut = new Inventory((Item[]) Arrays.asList(conjuredItem).toArray());
		
		sut.updateQuality();
		
		
		assertEquals(4, conjuredItem.getQuality());
	}
	
	@Test
	public void should_reduce_conjured_item_by_4_when_sell_in_date_has_passed() throws Exception {
		Item conjuredItem = new Item("Conjured Mana Cake", 0, 6);
		
		Inventory sut = new Inventory((Item[]) Arrays.asList(conjuredItem).toArray());
		
		sut.updateQuality();
		
		
		assertEquals(2, conjuredItem.getQuality());
	}
	
	
	
	
}
