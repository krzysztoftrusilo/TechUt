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

import ug.ktrusilo.javaut.zad04.domain.Owner;
import ug.ktrusilo.javaut.zad04.service.OwnerManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class OwnerManagerTest {
	
	final private String FIRSTNAME_1 = "Janek";
	final private String FIRSTNAME_2 = "Franek";
	
	final private String LASTNAME_1 = "Kowalski";
	final private String LASTNAME_2 = "Dolas";
	
	final private String FIRSTNAME_3 = "Robert";
	final private String LASTNAME_3 = "Bez";
	
	@Autowired
	OwnerManager manager;

	@Test
	public void addOwnerCheck()
	{
		Owner owner = new Owner();
		owner.setFirstName(FIRSTNAME_3);
		owner.setLastName(LASTNAME_3);
		manager.addOwner(owner);
		Owner ret = manager.getById(3L);
		assertEquals(FIRSTNAME_3, ret.getFirstName());
		assertEquals(LASTNAME_3, ret.getLastName());
	}
	
	@Test
	public void getOwnerByIdCheck()
	{
		Owner ret = manager.getById(2L);
		assertEquals(FIRSTNAME_2, ret.getFirstName());
		assertEquals(LASTNAME_2, ret.getLastName());
	}
	
	@Test
	public void getAllOwnersCheck()
	{
		List<Owner> list = manager.getAll();
		assertEquals(2, list.size());
	}
	
	@Test
	public void deleteOwnerCheck()
	{
		List<Owner> list = manager.getAll();
		assertEquals(2, list.size());
		manager.deleteOwner(list.get(0));
		list = manager.getAll();
		assertEquals(1, list.size());
	}
	
	@Test
	public void updateOwnerCheck() {
		
		Owner ret = manager.getAll().get(0);
		ret.setFirstName("Hanna");
		manager.updateOwner(ret);
		assertEquals("Hanna", manager.getAll().get(0).getFirstName());
	}
	
	@Before
	public void fillDb()
	{
		Owner owner1 = new Owner();
		owner1.setFirstName(FIRSTNAME_1);
		owner1.setLastName(LASTNAME_1);
		manager.addOwner(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName(FIRSTNAME_2);
		owner2.setLastName(LASTNAME_2);
		manager.addOwner(owner2);
	}
	@After
	public void deleteAll(){
		manager.clearTable();
	}
}
