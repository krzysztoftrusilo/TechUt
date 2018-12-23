package ug.ktrusilo.javaut.zad05.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ug.ktrusilo.javaut.zad05.domain.NumerEw;
import ug.ktrusilo.javaut.zad05.domain.Wardrobe;
import ug.ktrusilo.javaut.zad05.service.WardrobeManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class WardrobeManagerTest {

	@Autowired
	WardrobeManager manager;
	
	
	final private String NAME_1 = "i3";
	final private String NAME_4 = "i6";
	final private double WEIGHT = 13.74;
	final private int DOORS = 2;
	final private String PRODUCTION_DATE = "2017-12-12";
	
	@Test
	public void addWardrobeCheck()
	{
		Wardrobe newWardrobe = new Wardrobe();
		newWardrobe.setWeight(WEIGHT);
		newWardrobe.setDoors(DOORS);
		newWardrobe.setName(NAME_4);
		newWardrobe.setProductionDate(PRODUCTION_DATE);
		manager.addWardrobe(newWardrobe);
		Wardrobe wardrobe = manager.getById(4L);
		assertEquals(NAME_4, wardrobe.getName());
	}
	
	@Test
	public void getWardrobeByIdCheck()
	{
		Wardrobe retWardrobe = manager.getById(1);
		assertEquals(NAME_1, retWardrobe.getName());
	}
	
	@Test
	public void getAllWardrobesCheck()
	{
		List<Wardrobe> list = manager.getAllWardrobes();
		assertEquals(3, list.size());
	}
	
	@Test
	public void updateWardrobeCheck()
	{
		Wardrobe wardrobe = manager.getAllWardrobes().get(0);
		wardrobe.setName("UPDATE");
		manager.updateWardrobe(wardrobe);
		Wardrobe retwardrobe = manager.getAllWardrobes().get(0);
		assertEquals("UPDATE", retwardrobe.getName());
		
	}
	
	@Test
	public void deleteWardrobeCheck()
	{
		Wardrobe ret = manager.getById(1L);
		List<Wardrobe> list = manager.getAllWardrobes();
		manager.deleteWardrobe(ret);
		List<Wardrobe> list2 = manager.getAllWardrobes();
		assertEquals(list.size()-1, list2.size());
	}
	
	@Before
	public void fillDb()
	{
		NumerEw numerEw = new NumerEw();
		numerEw.setCode(123);
		Wardrobe wardrobe1 = new Wardrobe();
		wardrobe1.setDoors(DOORS);
		wardrobe1.setWeight(WEIGHT);
		wardrobe1.setName(NAME_1);
		wardrobe1.setProductionDate(PRODUCTION_DATE);
		wardrobe1.setNumerEw(numerEw);
		manager.addWardrobe(wardrobe1);
	}
	
	@After
	public void deleteAll(){
		manager.clearTable();
	}
}
