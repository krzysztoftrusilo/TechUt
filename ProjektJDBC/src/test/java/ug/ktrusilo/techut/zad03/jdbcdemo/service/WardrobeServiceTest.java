package ug.ktrusilo.techut.zad03.jdbcdemo.service;
import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ug.ktrusilo.techut.zad03.jdbcdemo.domain.Wardrobe;
import ug.ktrusilo.techut.zad03.jdbcdemo.service.WardrobeServiceJDBC;

public class WardrobeServiceTest {
	
	WardrobeServiceJDBC service = new WardrobeServiceJDBC();
	
	private final String WARDROBE1_NAME = "Ikea";
	private final int WARDROBE1_DOORS = 3;
	private final double WARDROBE1_WEIGHT = 3.2;
	@SuppressWarnings("deprecation")
	private final Date WARDROBE1_DATE = new Date(2015,10,10);
	
	private final String WARDROBE2_NAME = "RedWhite";
	private final int WARDROBE2_DOORS = 4;
	private final double WARDROBE2_WEIGHT = 3.4;
	@SuppressWarnings("deprecation")
	private final Date WARDROBE2_DATE = new Date(2011,10,10);

	private final String WARDROBE3_NAME = "Wardrobes";
	private final int WARDROBE3_DOORS = 5;
	private final double WARDROBE3_WEIGHT = 3.6;
	@SuppressWarnings("deprecation")
	private final Date WARDROBE3_DATE = new Date(2013,10,10);
	
	private final String WARDROBE4_NAME = "Cornics";
	private final int WARDROBE4_DOORS = 1;
	private final double WARDROBE4_WEIGHT = 3.2;
	@SuppressWarnings("deprecation")
	private final Date WARDROBE4_DATE = new Date(2015,10,10);
	
	@Test
	public void checkConnection() {
		assertNotNull(service.getConnection());
	}
	
	@Test
	public void checkAddWardrobe() {
		Wardrobe wardrobe4 = new Wardrobe(WARDROBE4_NAME, WARDROBE4_DOORS, WARDROBE4_WEIGHT, WARDROBE4_DATE);
		service.addWardrobe(wardrobe4);
		Wardrobe retWardrobe = service.getWardrobeById(service.getWardrobeByName(WARDROBE4_NAME).getId());
		assertEquals(WARDROBE4_NAME, retWardrobe.getName());
		assertEquals(WARDROBE4_WEIGHT, retWardrobe.getWeight(),0);
		assertEquals(WARDROBE4_DOORS, retWardrobe.getDoors());
		assertEquals(WARDROBE4_DATE, retWardrobe.getDate());
	}
	
	@Test
	public void checkAddAllWardrobes()
	{
		List<Wardrobe> wardrobeList = new ArrayList<Wardrobe>();
		
		wardrobeList.add(new Wardrobe("TEST1", WARDROBE1_DOORS, WARDROBE1_WEIGHT, WARDROBE1_DATE));
		
		wardrobeList.add(new Wardrobe("TEST2", WARDROBE1_DOORS, WARDROBE1_WEIGHT, WARDROBE1_DATE));
		
		service.addAllWardrobes(wardrobeList);
		
		int size = service.getAllWardrobes().size();
		assertEquals(5, size);
	}
	
	@Test
	public void checkGetWardrobeByName()
	{
		Wardrobe retWardrobe = service.getWardrobeByName(WARDROBE2_NAME);
		assertEquals(WARDROBE2_NAME, retWardrobe.getName());
	}
	
	@Test
	public void checkDeleteAllWardrobes()
	{
		service.deleteAllWardrobes();
		int size = service.getAllWardrobes().size();
		assertEquals(0, size);
	}
	
	@Test
	public void checkGetAllWardrobesDoorsMoreOrEqual() {
		List<Wardrobe> retWardrobeList = service.getAllWardrobesDoorsMoreThanOrEqual(4);
		assertEquals(2, retWardrobeList.size());
	}
	
	
	@Test
	public void checkGetAllWardrobesDateBetween() {
		@SuppressWarnings("deprecation")
		List<Wardrobe> retWardrobeList = service.getAllWardrobesDateBetween(new Date(2012,10,10),  new Date(2017,10,10));
		assertEquals(2, retWardrobeList.size());
	}
	
	@Test
	public void checkDeleteById() {
		Wardrobe retWardrobe = service.getWardrobeByName(WARDROBE2_NAME);
		service.deleteWardrobeById(retWardrobe.getId());

		List<Wardrobe> wardrobelist = service.getAllWardrobes();
		assertEquals(2, wardrobelist.size());
		for(Wardrobe wardrobe : wardrobelist)
		{
			assertNotEquals(retWardrobe.getId(), wardrobe.getId());
		}
	}
	
	@Before
	public void fillDb()
	{
		Wardrobe wardrobe1 = new Wardrobe(WARDROBE1_NAME, WARDROBE1_DOORS, WARDROBE1_WEIGHT, WARDROBE1_DATE);
		Wardrobe wardrobe2 = new Wardrobe(WARDROBE2_NAME, WARDROBE2_DOORS, WARDROBE2_WEIGHT, WARDROBE2_DATE);
		Wardrobe wardrobe3 = new Wardrobe(WARDROBE3_NAME, WARDROBE3_DOORS, WARDROBE3_WEIGHT, WARDROBE3_DATE);

		service.addWardrobe(wardrobe1);
		service.addWardrobe(wardrobe2);
		service.addWardrobe(wardrobe3);
	}
	
	@After
	public void clearTable()
	{
		service.deleteAllWardrobes();
	}
}
