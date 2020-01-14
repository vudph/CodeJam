package interview.disney;

public class Item {
	private String name;
	private ItemSize itemSize;
	
	public Item(String name, ItemSize itemSize) {
		this.setName(name);
		this.setItemSize(itemSize);
	}
	
	public ItemSize getItemSize() {
		return itemSize;
	}

	public void setItemSize(ItemSize itemSize) {
		this.itemSize = itemSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	enum ItemSize {
		SMALL, MEDIUM, LARGE;
	}
}
