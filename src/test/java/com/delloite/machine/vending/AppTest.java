package com.delloite.machine.vending;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Unit test for simple App.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)	
public class AppTest {
	private static VendingMachineService service = new VendingMachineServiceImpl();

	//firstTestCaseGreaterCoin
	@Test
	public void a() {
		List<Item> item = service.insertCoin(Coin.QUARTER);
		VendingResponse response = service.selectItem((Item.LAYS));
		assertEquals(response.getMessage(),"Enjoy your item");
		assertEquals(response.change, Arrays.asList(Coin.DIME));
	}
	
	//secondTestCaseGreaterCoin
	@Test
	public void b() {
		//gives u a list of items when you insert your coin
		List<Item> item = service.insertCoin(Coin.QUARTER);
		//select the item
		VendingResponse response = service.selectItem((Item.DAIRYMILK));
		assertEquals(response.getChange(),Arrays.asList(Coin.DIME));
		assertEquals(response.getMessage(),"Enjoy your item");
	}
	
	
	//thirdTestCaseLessThanItemPrice
	@Test
	public void c() {
		List<Item> item = service.insertCoin(Coin.PENNY);
		VendingResponse response = service.selectItem(Item.PEPSI);
		assertEquals(response.getMessage(),"Selected item costs more than the inserted coin.Please collect your coin");
		assertEquals(response.getChange(),Arrays.asList(Coin.PENNY));
	}
	//fourthNoChangeExact
	@Test
	public void d() {
		//gives u a list of items when you insert your coin
		List<Item> item = service.insertCoin(Coin.QUARTER);
		//select the item
		VendingResponse response = service.selectItem((Item.ECLAIRS));
		assertEquals(response.getMessage(),"Enjoy your item");
	}
	
	//fifthDifferntChangeValue
	@Test
	public void e() {
		//gives u a list of items when you insert your coin
		List<Item> item = service.insertCoin(Coin.QUARTER);
		//select the item
		VendingResponse response = service.selectItem((Item.LAYS));
		assertEquals(Arrays.asList(Coin.NICKLE,Coin.NICKLE), response.getChange());
		assertEquals(response.getMessage(),"Enjoy your item");
	}
	
	
	//No Change in system
		@Test
		public void f() {
			//gives u a list of items when you insert your coin
			List<Item> item = service.insertCoin(Coin.QUARTER);
			//select the item
			VendingResponse response = service.selectItem((Item.DAIRYMILK));
			assertEquals(Arrays.asList(Coin.QUARTER), response.getChange());
			assertEquals(response.getMessage(),"Machine does not have change in it. Please Collect your inserted coin");
		}
}
