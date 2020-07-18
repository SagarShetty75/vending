package com.delloite.machine.vending;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private static VendingMachineService service = new VendingMachineServiceImpl();

	@Test
	public void exactValue() {
		//gives u a list of items when you insert your coin
		List<Item> item = service.insertCoin(Coin.QUARTER);
		//select the item
		VendingResponse response = service.selectItem((Item.LAYS));
		assertEquals(response.getMessage(),"Enjoy your item");
	}
	
	@Test
	public void exactValue1() {
		//gives u a list of items when you insert your coin
		List<Item> item = service.insertCoin(Coin.QUARTER);
		//select the item
		VendingResponse response = service.selectItem((Item.LAYS));
		assertEquals(response.getMessage(),"Enjoy your item");
	}
	
	@Test
	public void greaterValue() {
		List<Item> item = service.insertCoin(Coin.QUARTER);
		VendingResponse response = service.selectItem((Item.LAYS));
		assertEquals(response.getMessage(),"Enjoy your item");
		assertEquals(response.change, Arrays.asList(Coin.DIME));
	}
	
	@Test
	public void lessValue() {
		List<Item> item = service.insertCoin(Coin.PENNY);
		VendingResponse response = service.selectItem(Item.PEPSI);
		assertEquals(response.getMessage(),"Selected item costs more than the inserted coin.Please collect your coin");
	}
	
	@Test
	public void exactValueAgain() {
		//gives u a list of items when you insert your coin
		List<Item> item = service.insertCoin(Coin.QUARTER);
		//select the item
		VendingResponse response = service.selectItem((Item.ECLAIRS));
		assertEquals(response.getMessage(),"Enjoy your item");
	}
}
