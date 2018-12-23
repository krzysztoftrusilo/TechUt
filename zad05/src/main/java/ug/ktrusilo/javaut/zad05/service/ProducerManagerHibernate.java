package ug.ktrusilo.javaut.zad05.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ug.ktrusilo.javaut.zad05.domain.Producer;

@Component
@Transactional
public class ProducerManagerHibernate implements ProducerManager{

	@Autowired
	SessionFactory session;
	
	@Override
	public void addProducer(Producer producer) {
		session.getCurrentSession().persist(producer);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producer> getAllProducers() {
		return session.getCurrentSession().getNamedQuery("producer.all").list();
	}

	@Override
	public Producer getProducerById(long id) {
		return (Producer) session.getCurrentSession().get(Producer.class, id);
	}

	@Override
	public void deleteProducer(Producer producer) {
		session.getCurrentSession().delete(producer);
		
	}

	@Override
	public void updateProducer(Producer producer) {
		session.getCurrentSession().saveOrUpdate(producer);
	}

	@Override
	public Producer getProducerByName(String name) {
		return (Producer) session.getCurrentSession().getNamedQuery("producer.name").setString("name", name).uniqueResult();
	}
	
	public void clearTable()
	{
		session.getCurrentSession().createSQLQuery("TRUNCATE TABLE PRODUCER RESTART IDENTITY AND COMMIT NO CHECK").executeUpdate();
	}
}
