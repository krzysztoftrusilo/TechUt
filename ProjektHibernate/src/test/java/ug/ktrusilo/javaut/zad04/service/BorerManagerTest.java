package ug.ktrusilo.javaut.zad04.service;

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

import ug.ktrusilo.javaut.zad04.domain.Borer;
import ug.ktrusilo.javaut.zad04.service.BorerManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class BorerManagerTest {
	
	final private String VALUE_1 = "Gosia";
	final private String VALUE_2 = "Tosia";
	final private String VALUE_3 = "Zosia";
	
	@Autowired
	BorerManager manager;

	@Test
	public void addBorerCheck()
	{
		Borer borer = new Borer();
		borer.setName(VALUE_3);
		manager.addBorer(borer);
		Borer ret = manager.getById(3L);
		assertEquals(VALUE_3, ret.getName());
	}
	
	@Test
	public void getBorerByIdCheck()
	{
		Borer ret = manager.getById(2L);
		assertEquals(VALUE_2, ret.getName());
	}
	
	@Test
	public void getAllBorersCheck()
	{
		List<Borer> list = manager.getAll();
		assertEquals(2, list.size());
	}
	
	@Test
	public void deleteBorerCheck()
	{
		List<Borer> list = manager.getAll();
		assertEquals(2, list.size());
		manager.deleteBorer(list.get(0));
		list = manager.getAll();
		assertEquals(1, list.size());
	}
	
	@Test
	public void updateBorerCheck() {
		
		Borer ret = manager.getAll().get(0);
		ret.setName("Borer Update");
		manager.updateBorer(ret);
		assertEquals("Borer Update", manager.getAll().get(0).getName());
	}
	
	@Before
	public void fillDb()
	{
		Borer borer1 = new Borer();
		borer1.setName(VALUE_1);
		manager.addBorer(borer1);
		
		Borer borer2 = new Borer();
		borer2.setName(VALUE_2);
		manager.addBorer(borer2);
	}
	@After
	public void deleteAll(){
		manager.clearTable();
	}
}
