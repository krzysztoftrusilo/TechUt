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

import ug.ktrusilo.javaut.zad04.domain.Kornik;
import ug.ktrusilo.javaut.zad04.service.KornikManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class KornikManagerTest {
	
	final private String NAME_1 = "Grzesiu";
	final private String NAME_2 = "Zdzisiu";
	final private String NAME_3 = "Misiu";
	
	@Autowired
	KornikManager manager;

	@Test
	public void addKornikCheck()
	{
		Kornik kornik = new Kornik();
		kornik.setName(NAME_3);
		manager.addKornik(kornik);
		Kornik ret = manager.getById(3L);
		assertEquals(NAME_3, ret.getName());
	}
	
	@Test
	public void getRegisterByIdCheck()
	{
		Kornik ret = manager.getById(2L);
		assertEquals(NAME_2, ret.getName());
	}
	
	@Test
	public void getAllKorniksCheck()
	{
		List<Kornik> list = manager.getAll();
		assertEquals(2, list.size());
	}
	
	@Test
	public void deleteKornikCheck()
	{
		List<Kornik> list = manager.getAll();
		assertEquals(2, list.size());
		manager.deleteKornik(list.get(0));
		list = manager.getAll();
		assertEquals(1, list.size());
	}
	
	@Test
	public void updateKornikCheck() {
		
		Kornik ret = manager.getAll().get(0);
		ret.setName("Register Update");
		manager.updateKornik(ret);
		assertEquals("Kornik Update", manager.getAll().get(0).getName());
	}
	
	@Before
	public void fillDb()
	{
		Kornik kornik1 = new Kornik();
		kornik1.setName(NAME_1);
		manager.addKornik(kornik1);
		
		Kornik kornik2 = new Kornik();
		kornik2.setName(NAME_2);
		manager.addKornik(kornik2);
	}
	@After
	public void deleteAll(){
		manager.clearTable();
	}
}
