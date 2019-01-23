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
import ug.ktrusilo.javaut.zad04.domain.Wardrobe;
import ug.ktrusilo.javaut.zad04.domain.Producer;
import ug.ktrusilo.javaut.zad04.domain.Kornik;
import ug.ktrusilo.javaut.zad04.service.WardrobeManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class ProcessorManagerTest {

	@Autowired
	WardrobeManager manager;
	@Autowired
	NumerEwManager numerewmanager;
	@Autowired
	ProducerManager producermanager;
	@Autowired
	OwnerManager ownermanager;
	@Autowired
	KornikManager kornikmanager;
	
	final private String NAME_1 = "Szafa";
	final private String NAME_2 = "Szafa1";
	final private String NAME_3 = "Szafa2";
	final private String NAME_4 = "Szafa3";
	final private double WEIGHT = 100.5;
	final private int DOORS = 3;
	final private String DATE1 = "2016-10-10";
	final private String DATE2 = "2016-10-10";
	final private String DATE3 = "2016-10-10";
	
	final private String FIRSTNAME_1 = "FIRSTNAME1";
	final private String FIRSTNAME_2 = "FIRSTNAME2";
	
	final private String LASTNAME_1 = "LASTNAME1";
	final private String LASTNAME_2 = "LASTNAME2";
	
	final private String FIRSTNAME_3 = "FIRSTNAME3";
	final private String LASTNAME_3 = "LASTNAME3";
	
	final private String PRODUCER_NAME_1 = "Komodor";
	final private String PRODUCER_NAME_2 = "Ikea";
	
	final private String KORNIK_NAME_1 = "Grzesiu";
	final private String KORNIK_NAME_2 = "Zdzisiu";
	final private String KORNIK_NAME_3 = "Wladziu";
	final private String KORNIK_NAME_4 = "Zbysiu";
	final private String KORNIK_NAME_5 = "Basia";
	final private String KORNIK_NAME_6 = "Kasia";
	@Test
	public void addWardrobeCheck()
	{
		Wardrobe newWardrobe = new Wardrobe();
		newWardrobe.setWeight(WEIGHT);
		newWardrobe.setDoors(DOORS);
		newWardrobe.setName(NAME_4);
		newWardrobe.setDate(DATE1);
		manager.addWardrobe(newWardrobe);
		Wardrobe Wardrobe = manager.getById(4L);
		assertEquals(NAME_4, Wardrobe.getName());
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
		Wardrobe Wardrobe = manager.getAllWardrobes().get(0);
		Wardrobe.setName("UPDATE");
		manager.updateWardrobe(Wardrobe);
		Wardrobe retWardrobe = manager.getAllWardrobes().get(0);
		assertEquals("UPDATE", retWardrobe.getName());
		
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
	
	@Test
	public void getAllWardrobesByProducerNameCheck()
	{
		List<Wardrobe> list = manager.getAllWardrobesByProducerName(PRODUCER_NAME_1);
		assertEquals(2, list.size());
	}
	
	@Test
	public void getallWardrobesNameMatchStringCheck()
	{
		List<Wardrobe> list = manager.getallWardrobesNameMatchString("i");
		assertEquals(2, list.size());
	}
	@Test
	public void deleteListOfWardrobes()
	{
		List<Wardrobe> list = manager.getAllWardrobes();
		manager.deleteWardrobes(list);
		List<Wardrobe> list2 = manager.getAllWardrobes();
		assertEquals(0, list2.size());
	}
	
	@Before
	public void fillDb()
	{		
		Producer producer1 = new Producer();
		producer1.setName(PRODUCER_NAME_1);
		producermanager.addProducer(producer1);
		Producer producer2 = new Producer();
		producer2.setName(PRODUCER_NAME_2);
		producermanager.addProducer(producer2);
		
		Owner owner1 = new Owner();
		owner1.setFirstName(FIRSTNAME_1);
		owner1.setLastName(LASTNAME_1);
		ownermanager.addOwner(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName(FIRSTNAME_2);
		owner2.setLastName(LASTNAME_2);
		ownermanager.addOwner(owner2);
		
		Owner owner3 = new Owner();
		owner3.setFirstName(FIRSTNAME_3);
		owner3.setLastName(LASTNAME_3);
		ownermanager.addOwner(owner3);
		
		Kornik kornik1 = new Kornik(KORNIK_NAME_1);
		Kornik kornik2 = new Kornik(KORNIK_NAME_2);
		Kornik kornik3 = new Kornik(KORNIK_NAME_3);
		kornikmanager.addKornik(kornik3);
		kornikmanager.addKornik(kornik2);
		kornikmanager.addKornik(kornik1);
		
		Kornik kornik4 = new Kornik(KORNIK_NAME_4);
		Kornik kornik5 = new Kornik(KORNIK_NAME_5);
		Kornik kornik6 = new Kornik(KORNIK_NAME_6);
		kornikmanager.addKornik(kornik4);
		kornikmanager.addKornik(kornik5);
		kornikmanager.addKornik(kornik6);
		
		Wardrobe Wardrobe1 = new Wardrobe();
		Wardrobe1.setDoors(DOORS);
		Wardrobe1.setWeight(WEIGHT);
		Wardrobe1.setName(NAME_1);
		Wardrobe1.setDate(DATE1);
		Wardrobe1.setProducer(producer1);
		Wardrobe1.getOwnedBy().add(owner1);
		Wardrobe1.getOwnedBy().add(owner2);
		Wardrobe1.getKorniks().add(kornik1);
		Wardrobe1.getKorniks().add(kornik2);
		manager.addWardrobe(Wardrobe1);
		Wardrobe Wardrobe2 = new Wardrobe();
		Wardrobe2.setDoors(DOORS);
		Wardrobe2.setWeight(WEIGHT);
		Wardrobe2.setName(NAME_2);
		Wardrobe2.setDate(DATE2);
		Wardrobe2.setProducer(producer1);
		Wardrobe2.getOwnedBy().add(owner1);
		Wardrobe2.getKorniks().add(kornik3);
		Wardrobe2.getKorniks().add(kornik4);
		manager.addWardrobe(Wardrobe2);
		Wardrobe Wardrobe3 = new Wardrobe();
		Wardrobe3.setDoors(DOORS);
		Wardrobe3.setWeight(WEIGHT);
		Wardrobe3.setName(NAME_3);
		Wardrobe3.setDate(DATE3);
		Wardrobe3.setProducer(producer2);
		Wardrobe3.getOwnedBy().add(owner3);
		Wardrobe3.getOwnedBy().add(owner1);
		Wardrobe3.getKorniks().add(kornik5);
		Wardrobe3.getKorniks().add(kornik6);
		manager.addWardrobe(Wardrobe3);
	}
	
	@After
	public void deleteAll(){
		manager.clearTable();
	}
}
