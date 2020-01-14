package interview.disney;

public class Shelf implements Comparable<Shelf> {
	private int shelfId;
	private ShelfType shelfType;
	private boolean occupied;
	
	// for MVP version we assume that 1 shelf only can store 1 item
	private Item item;
	
	public Shelf(int shelfId, ShelfType shelfType) {
		this.setShelfId(shelfId);
		this.setShelfType(shelfType);
	}
	
	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public ShelfType getShelfType() {
		return shelfType;
	}


	public void setShelfType(ShelfType shelfType) {
		this.shelfType = shelfType;
	}

	@Override
	public int compareTo(Shelf o) {
		return shelfType.ordinal() - o.getShelfType().ordinal();
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getShelfId() {
		return shelfId;
	}

	public void setShelfId(int shelfId) {
		this.shelfId = shelfId;
	}

	enum ShelfType {
		SMALL, MEDIUM, LARGE;
	}
}
