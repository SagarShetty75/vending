package com.delloite.machine.vending;

public enum Item {

	PEPSI("Pepsi", 10), LAYS("Lays", 5), DAIRYMILK("DairyMilk", 5), ECLAIRS("Eclairs", 15);

	private String itemName;
	private int price;

	private Item(String itemName, int price) {
		this.itemName = itemName;
		this.price = price;
	}

	public String getItemName() {
		return itemName;
	}

	public int getPrice() {
		return price;
	}

}
