package com.delloite.machine.vending;

import java.util.List;

public class VendingResponse {

	List<Coin> change;
	Item selectedItem;
	String message;

	public VendingResponse() {
	}

	public VendingResponse(String message, List<Coin> change) {
		super();
		this.message = message;
		this.change = change;
	}

	public VendingResponse(List<Coin> change, Item selectedItem, String message) {
		super();
		this.change = change;
		this.selectedItem = selectedItem;
		this.message = message;
	}

	public List<Coin> getChange() {
		return change;
	}

	public Item getSelectedItem() {
		return selectedItem;
	}

	public String getMessage() {
		return message;
	}

	public void setChange(List<Coin> change) {
		this.change = change;
	}

	public void setSelectedItem(Item selectedItem) {
		this.selectedItem = selectedItem;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
