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

import ug.ktrusilo.javaut.zad04.domain.NumerEw;
import ug.ktrusilo.javaut.zad04.service.NumerEwManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class LabelManagerTest {
	
	final private int CODE_1 = 44485;
	final private int CODE_2 = 58444;
	
	final private int CODE_3 = 8444;
	
	@Autowired
	NumerEwManager manager;

	@Test
	public void addNumerEwCheck()
	{
		NumerEw numerEw = new NumerEw();
		numerEw.setCode(CODE_3);
		manager.addNumerEw(numerEw);
		NumerEw ret = manager.getById(3L);
		assertEquals(CODE_3, ret.getCode());
	}
	
	@Test
	public void getLabelByIdCheck()
	{
		NumerEw ret = manager.getById(2L);
		assertEquals(CODE_2, ret.getCode());
	}
	
	@Test
	public void getAllNumerEwsCheck()
	{
		List<NumerEw> list = manager.getAll();
		assertEquals(2, list.size());
	}
	
	@Test
	public void deleteNumerEwCheck()
	{
		List<NumerEw> list = manager.getAll();
		assertEquals(2, list.size());
		manager.deleteNumerEw(list.get(0));
		list = manager.getAll();
		assertEquals(1, list.size());
	}
	
	@Test
	public void updateNumerEwCheck() {
		
		NumerEw ret = manager.getAll().get(0);
		manager.updateNumerEw(ret);
		assertEquals("Label Update", manager.getAll().get(0));
	}
	
	@Before
	public void fillDb()
	{
		NumerEw numerEw1 = new NumerEw();
		numerEw1.setCode(CODE_1);
		manager.addNumerEw(numerEw1);
		
		NumerEw numerEw2 = new NumerEw();
		numerEw2.setCode(CODE_2);
		manager.addNumerEw(numerEw2);
	}
	@After
	public void deleteAll(){
		manager.clearTable();
	}
}
