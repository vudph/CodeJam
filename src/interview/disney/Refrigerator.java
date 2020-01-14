package interview.disney;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interview.disney.Item.ItemSize;
import interview.disney.Shelf.ShelfType;

public class Refrigerator {
	
	private Map<String, Shelf> internalMap = new HashMap<>();
	private List<Shelf> shelves;
	
	public Refrigerator(List<Shelf> shelves) {
		this.shelves = shelves;
		//sort the shelves from small to large
		Collections.sort(shelves);
	}
	
	public void put(Item item) throws NotEnoughSpaceException {
		//lookup correct shelves which are enough and available to put the item with size
		for (Shelf sh : shelves) {
			if (!sh.isOccupied() && sh.getShelfType().ordinal() >= item.getItemSize().ordinal()) {
				sh.setOccupied(true);
				sh.setItem(item);
				internalMap.put(item.getName(), sh);
				return;
			}
		}
		throw new NotEnoughSpaceException("There is no shelf to put the item!");
	}
	
	public Item get(String itemName){
		Shelf sh = internalMap.remove(itemName);
		if (sh == null) {
			throw new ItemNotFoundInRefrigeratorException("Item " + itemName + " not found in the refrigerator!");
		}
		sh.setOccupied(false);
		return sh.getItem();
	}

	public static void main(String[] args) {
		List<Shelf> shelves = new ArrayList<Shelf>();
		shelves.add(new Shelf(1, ShelfType.SMALL));
		shelves.add(new Shelf(2, ShelfType.SMALL));
		shelves.add(new Shelf(3, ShelfType.MEDIUM));
		shelves.add(new Shelf(4, ShelfType.MEDIUM));
		shelves.add(new Shelf(5, ShelfType.MEDIUM));
		shelves.add(new Shelf(6, ShelfType.LARGE));
		
		Refrigerator refrigerator = new Refrigerator(shelves);
		refrigerator.put(new Item("Meat", ItemSize.SMALL));
		refrigerator.put(new Item("Fruit", ItemSize.MEDIUM));
		refrigerator.put(new Item("Beer", ItemSize.MEDIUM));
		refrigerator.put(new Item("Water", ItemSize.LARGE));
		Item i1 = refrigerator.get("Fruit");		
		refrigerator.put(new Item("Rice", ItemSize.LARGE));
		Item i2 = refrigerator.get("Rice");	
		
	}
}
