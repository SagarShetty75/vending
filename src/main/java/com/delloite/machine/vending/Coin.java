package com.delloite.machine.vending;

import java.util.HashMap;
import java.util.Map;

public enum Coin {

	PENNY(1), NICKLE(5), DIME(10), QUARTER(15);

	private int price;

	private Coin(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	static final Map<Integer, Coin> typesByValue = new HashMap<Integer, Coin>();

	static {
		for (Coin type : Coin.values()) {
			typesByValue.put(type.getPrice(), type);
		}
	}
}
