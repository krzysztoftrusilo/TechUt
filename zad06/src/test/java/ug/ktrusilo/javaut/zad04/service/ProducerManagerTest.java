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

import ug.ktrusilo.javaut.zad04.domain.Producer;
import ug.ktrusilo.javaut.zad04.service.ProducerManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class ProducerManagerTest {
	
	final private String NAME_1 = "Komandor";
	final private String NAME_2 = "Ikea";
	final private String NAME_3 = "Red&White";
	final private String NAME_4 = "Kepno";
	@Autowired
	ProducerManager manager;

	@Test
	public void addProducerCheck()
	{
		Producer producer = new Producer();
		producer.setName(NAME_3);
		manager.addProducer(producer);
		Producer ret = manager.getProducerById(3L);
		assertEquals(NAME_3, ret.getName());
	}
	
	@Test
	public void getProducerByIdCheck()
	{
		Producer retProducer = manager.getProducerById(2L);
		assertEquals(NAME_2, retProducer.getName());
	}
	
	@Test
	public void getAllProducersCheck()
	{
		List<Producer> list = manager.getAllProducers();
		assertEquals(2, list.size());
	}
	
	@Test
	public void deleteProducerCheck()
	{
		List<Producer> list = manager.getAllProducers();
		assertEquals(2, list.size());
		manager.deleteProducer(list.get(0));
		list = manager.getAllProducers();
		assertEquals(1, list.size());
	}
	
	@Test
	public void updateProducerCheck() {
		
		Producer retProducer = manager.getProducerByName(NAME_2);
		retProducer.setName(NAME_4);
		manager.updateProducer(retProducer);
		assertEquals(NAME_4, manager.getProducerByName(NAME_4).getName());
	}
	
	@Test
	public void getProducerByNameCheck()
	{
		Producer retProducer = manager.getProducerByName(NAME_1);
		assertEquals(NAME_1, retProducer.getName());
	}
	
	@Before
	public void fillDb()
	{
		Producer producer = new Producer();
		producer.setName(NAME_1);
		manager.addProducer(producer);
		Producer producer2 = new Producer();
		producer2.setName(NAME_2);
		manager.addProducer(producer2);
	}
	@After
	public void deleteAll(){
		manager.clearTable();
	}
}
