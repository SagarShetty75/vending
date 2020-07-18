package com.delloite.machine.vending;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineServiceImpl implements VendingMachineService {

	Coin insertedCoin;
	private Map<Item, Integer> itemInventory = new HashMap<>();
	private Map<Coin, Integer> cashInMachine = new HashMap<>();
	int coinInSystem = 0;
	List<Coin> change = null;

	public VendingMachineServiceImpl() {

		// Add some money to the system
		for (Coin coin : Coin.values()) {
			cashInMachine.put(coin, 2);
			coinInSystem += coin.getPrice() * 2;
		}
		// Keep some stocks of the item
		for (Item item : Item.values()) {
			itemInventory.put(item, 2);
		}
	}

	@Override
	public List<Item> insertCoin(Coin coin) {
		insertedCoin = coin;
		List<Item> itemsToSelect = new ArrayList<>();
		itemInventory.forEach((k, v) -> {
			itemsToSelect.add(k);
		});
		return itemsToSelect;
	}

	@Override
	public VendingResponse selectItem(Item item) {

		return calculateChange(item);

	}

	@Override
	public VendingResponse calculateChange(Item item) {
		//if(itemInventory.containsKey(item)) {
		change=new ArrayList();
		if (insertedCoin.getPrice() < item.getPrice()) {
			return new VendingResponse("Selected item costs more than the inserted coin.Please collect your coin",
					Arrays.asList(insertedCoin));
		} else if (insertedCoin.getPrice() > item.getPrice()) {
			if (coinInSystem < (item.getPrice() - insertedCoin.getPrice())) {
				return new VendingResponse(
						"Machine does not have enough money in it. Please collect your inserted Coin",
						Arrays.asList(insertedCoin));
			} else {
				VendingResponse result = new VendingResponse();
				List<Coin> dispenseChange = dispenseChange(insertedCoin.getPrice() - item.getPrice());
				if (dispenseChange != null) {
					result.setChange(dispenseChange);
					result.setMessage("Enjoy your item");
					result.setSelectedItem(item);
					itemInventory.put(item, itemInventory.get(item) - 1);
					cashInMachine.put(insertedCoin, cashInMachine.get(insertedCoin) + 1);
					coinInSystem += insertedCoin.getPrice();
				} else {
					return new VendingResponse("Machine does not have change in it. Please Collect your inserted coin",
							Arrays.asList(insertedCoin));
				}
				return result;
			}
		} else {
			itemInventory.put(item, itemInventory.get(item) - 1);
			cashInMachine.put(insertedCoin, cashInMachine.get(insertedCoin) + 1);
			coinInSystem += insertedCoin.getPrice();
			return new VendingResponse(null, item, "Enjoy your item");
		}
//		}
//		else {
//			return new VendingResponse("Item not avilable",
//					Arrays.asList(insertedCoin)); 
//		}
	}

	private List<Coin> dispenseChange(int balance) {
		while (balance != 0) {
			Coin balanceCoin = Coin.typesByValue.get(balance);
			if (cashInMachine.containsKey(balanceCoin) && cashInMachine.get(balanceCoin) != 0) {
				change.add(balanceCoin);
				coinInSystem -= balanceCoin.getPrice();
				cashInMachine.put(balanceCoin, cashInMachine.get(balanceCoin) - 1);
				balance-=balanceCoin.getPrice();
			} else {
				return null;
			}
		}
		return change;
	}


}
