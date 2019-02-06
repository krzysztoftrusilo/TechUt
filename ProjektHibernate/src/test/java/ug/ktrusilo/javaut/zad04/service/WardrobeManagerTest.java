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
import ug.ktrusilo.javaut.zad04.domain.Evidence;
import ug.ktrusilo.javaut.zad04.domain.Wardrobe;
import ug.ktrusilo.javaut.zad04.domain.Producer;
import ug.ktrusilo.javaut.zad04.domain.Borer;
import ug.ktrusilo.javaut.zad04.service.OwnerManager;
import ug.ktrusilo.javaut.zad04.service.EvidenceManager;
import ug.ktrusilo.javaut.zad04.service.WardrobeManager;
import ug.ktrusilo.javaut.zad04.service.ProducerManager;
import ug.ktrusilo.javaut.zad04.service.BorerManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class WardrobeManagerTest {

	@Autowired
	WardrobeManager manager;
	@Autowired
	EvidenceManager evidencemanager;
	@Autowired
	ProducerManager producermanager;
	@Autowired
	OwnerManager ownermanager;
	@Autowired
	BorerManager borermanager;
	
	final private String NAME_1 = "Wardrobe111";
	final private String NAME_2 = "Wardrobe122";
	final private String NAME_3 = "Wardrobe123";
	final private String NAME_4 = "Wardrobe114";
	final private double WEIGHT = 27.55;
	final private int DOORS = 4;
	final private String DATE1 = "2015-05-22";
	final private String DATE2 = "2018-11-22";
	final private String DATE3 = "2017-10-21";
	
	final private String FIRSTNAME_1 = "Janek";
	final private String FIRSTNAME_2 = "Franek";
	
	final private String LASTNAME_1 = "Kowalski";
	final private String LASTNAME_2 = "Dolas";
	
	final private String FIRSTNAME_3 = "Robert";
	final private String LASTNAME_3 = "Bez";
	
	final private String EVIDENCE_NAME_1 = "glodny";
	final private String EVIDENCE_NAME_2 = "natchniony";
		
	final private String EVIDENCE_NAME_3 = "Label 3";
	
	final private String PRODUCER_NAME_1 = "Ikea";
	final private String PRODUCER_NAME_2 = "RedWhite";
	
	final private String BORER_VALUE_1 = "Gosia";
	final private String BORER_VALUE_2 = "Zosia";
	final private String BORER_VALUE_3 = "Tosia";
	final private String BORER_VALUE_4 = "Romek";
	final private String BORER_VALUE_5 = "Tomek";
	final private String BORER_VALUE_6 = "Atomek";
	@Test
	public void addWardrobeCheck()
	{
		Wardrobe newWardrobe = new Wardrobe();
		newWardrobe.setWeight(WEIGHT);
		newWardrobe.setDoors(DOORS);
		newWardrobe.setName(NAME_4);
		newWardrobe.setDate(DATE1);
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
	
	@Test
	public void getAllOwnersCheck()
	{
		Wardrobe wardrobe = manager.getAllWardrobes().get(0);
		List<Owner> list = manager.getAllOwners(wardrobe.getId());
		assertEquals(wardrobe.getOwners().size(), list.size());
	}
	
	@Test
	public void getAllWardrobesByProducerNameCheck()
	{
		List<Wardrobe> list = manager.getAllWardrobesByProducerName(PRODUCER_NAME_1);
		assertEquals(2, list.size());
	}
	
	@Test
	public void getAllWardrobesByDateBetweenNameCheck()
	{
		List<Wardrobe> list = manager.getAllWardrobesWithDateBetween(DATE1, DATE2);
		assertEquals(3, list.size());
	}
	
	@Test
	public void getAllWardrobesOwnersMoreThanCheck()
	{
		List<Wardrobe> list = manager.getallWardrobesOwnersMoreEqualThan(2);
		assertEquals(2, list.size());
	}
	@Test
	public void getallWardrobesNameMatchStringCheck()
	{
		List<Wardrobe> list = manager.getallWardrobesNameMatchString("12");
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
		Evidence evidence1 = new Evidence();
		evidence1.setCode(EVIDENCE_NAME_1);
		evidencemanager.addEvidence(evidence1);
		Evidence evidence2 = new Evidence();
		evidence2.setCode(EVIDENCE_NAME_2);
		evidencemanager.addEvidence(evidence2);
		Evidence evidence3 = new Evidence();
		evidence3.setCode(EVIDENCE_NAME_3);
		evidencemanager.addEvidence(evidence3);
		
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
		
		Borer borer1 = new Borer(BORER_VALUE_1);
		Borer borer2 = new Borer(BORER_VALUE_2);
		Borer borer3 = new Borer(BORER_VALUE_3);
		borermanager.addBorer(borer3);
		borermanager.addBorer(borer2);
		borermanager.addBorer(borer1);
		
		Borer borer4 = new Borer(BORER_VALUE_4);
		Borer borer5 = new Borer(BORER_VALUE_5);
		Borer borer6 = new Borer(BORER_VALUE_6);
		borermanager.addBorer(borer4);
		borermanager.addBorer(borer5);
		borermanager.addBorer(borer6);
		
		Wardrobe wardrobe1 = new Wardrobe();
		wardrobe1.setDoors(DOORS);
		wardrobe1.setWeight(WEIGHT);
		wardrobe1.setName(NAME_1);
		wardrobe1.setDate(DATE1);
		wardrobe1.setEvidence(evidence1);
		wardrobe1.setProducer(producer1);
		wardrobe1.getOwners().add(owner1);
		wardrobe1.getOwners().add(owner2);
		wardrobe1.getBorers().add(borer1);
		wardrobe1.getBorers().add(borer2);
		manager.addWardrobe(wardrobe1);
		Wardrobe wardrobe2 = new Wardrobe();
		wardrobe2.setDoors(DOORS);
		wardrobe2.setWeight(WEIGHT);
		wardrobe2.setName(NAME_2);
		wardrobe2.setDate(DATE2);
		wardrobe2.setEvidence(evidence2);
		wardrobe2.setProducer(producer1);
		wardrobe2.getOwners().add(owner1);
		wardrobe2.getBorers().add(borer3);
		wardrobe2.getBorers().add(borer4);
		manager.addWardrobe(wardrobe2);
		Wardrobe wardrobe3 = new Wardrobe();
		wardrobe3.setDoors(DOORS);
		wardrobe3.setWeight(WEIGHT);
		wardrobe3.setName(NAME_3);
		wardrobe3.setDate(DATE3);
		wardrobe3.setEvidence(evidence3);
		wardrobe3.setProducer(producer2);
		wardrobe3.getOwners().add(owner3);
		wardrobe3.getOwners().add(owner1);
		wardrobe3.getBorers().add(borer5);
		wardrobe3.getBorers().add(borer6);
		manager.addWardrobe(wardrobe3);
	}
	
	@After
	public void deleteAll(){
		manager.clearTable();
	}
}
