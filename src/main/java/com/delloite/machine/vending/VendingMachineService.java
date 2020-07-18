package com.delloite.machine.vending;

import java.util.List;

public interface VendingMachineService {

	List<Item> insertCoin(Coin coin);

	VendingResponse selectItem(Item item);

	VendingResponse calculateChange(Item item);
}
