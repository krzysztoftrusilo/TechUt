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

import ug.ktrusilo.javaut.zad04.domain.Evidence;
import ug.ktrusilo.javaut.zad04.service.EvidenceManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class EvidenceManagerTest {
	
	final private String NAME_1 = "xhjgki";
	final private String NAME_2 = "poprawnyniepoprawny";
	final private String NAME_3 = "autorjestglodny";

	
	@Autowired
	EvidenceManager manager;

	@Test
	public void addEvidenceCheck()
	{
		Evidence evidence = new Evidence();
		evidence.setCode(NAME_3);
		manager.addEvidence(evidence);
		Evidence ret = manager.getById(3L);
		assertEquals(NAME_3, ret.getCode());
	}
	
	@Test
	public void getEvidenceByIdCheck()
	{
		Evidence ret = manager.getById(2L);
		assertEquals(NAME_2, ret.getCode());
	}
	
	@Test
	public void getAllEvidenceCheck()
	{
		List<Evidence> list = manager.getAll();
		assertEquals(2, list.size());
	}
	
	@Test
	public void deleteEvidenceCheck()
	{
		List<Evidence> list = manager.getAll();
		assertEquals(2, list.size());
		manager.deleteEvidence(list.get(0));
		list = manager.getAll();
		assertEquals(1, list.size());
	}
	
	@Test
	public void updateEvidenceCheck() {
		
		Evidence ret = manager.getAll().get(0);
		ret.setCode("Evidence Update");
		manager.updateEvidence(ret);
		assertEquals("Evidence Update", manager.getAll().get(0).getCode());
	}
	
	@Before
	public void fillDb()
	{
		Evidence evidence1 = new Evidence();
		evidence1.setCode(NAME_1);
		manager.addEvidence(evidence1);
		
		Evidence evidence2 = new Evidence();
		evidence2.setCode(NAME_2);
		manager.addEvidence(evidence2);
	}
	@After
	public void deleteAll(){
		manager.clearTable();
	}
}
