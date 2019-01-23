package ug.ktrusilo.javaut.zad04.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ug.ktrusilo.javaut.zad04.domain.Wardrobe;
@Component
@Transactional
public class WardrobeManagerHibernate implements WardrobeManager{

	@Autowired
	SessionFactory session;
	
	@Override
	public void addWardrobe(Wardrobe wardrobe) {
		session.getCurrentSession().persist(wardrobe);
	}

	@Override
	public Wardrobe getById(long id) {
		return (Wardrobe) session.getCurrentSession().get(Wardrobe.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Wardrobe> getAllWardrobes() {
		return (List<Wardrobe>) session.getCurrentSession().getNamedQuery("wardrobe.all").list();
	}

	@Override
	public void deleteWardrobe(Wardrobe wardrobe) {
		session.getCurrentSession().delete(wardrobe);
	}

	@Override
	public void updateWardrobe(Wardrobe wardrobe) {
		session.getCurrentSession().saveOrUpdate(wardrobe);
	}
	public void clearTable()
	{
		session.getCurrentSession().createSQLQuery("TRUNCATE TABLE OWNER RESTART IDENTITY AND COMMIT NO CHECK").executeUpdate();
		session.getCurrentSession().createSQLQuery("TRUNCATE TABLE NUMEREW RESTART IDENTITY AND COMMIT NO CHECK").executeUpdate();
		session.getCurrentSession().createSQLQuery("TRUNCATE TABLE PRODUCER RESTART IDENTITY AND COMMIT NO CHECK").executeUpdate();
		session.getCurrentSession().createSQLQuery("TRUNCATE TABLE WARDROBE_OWNER RESTART IDENTITY AND COMMIT NO CHECK").executeUpdate();
		session.getCurrentSession().createSQLQuery("TRUNCATE TABLE KORNIK RESTART IDENTITY AND COMMIT NO CHECK").executeUpdate();
		session.getCurrentSession().createSQLQuery("TRUNCATE TABLE WARDROBE_KORNIK RESTART IDENTITY AND COMMIT NO CHECK").executeUpdate();
		session.getCurrentSession().createSQLQuery("TRUNCATE TABLE WARDROBE RESTART IDENTITY AND COMMIT NO CHECK").executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Wardrobe> getAllWardrobesByProducerName(String name) {
		return (List<Wardrobe>) session.getCurrentSession().getNamedQuery("processor.allProcessorsByProducer").setString("name", name).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Wardrobe> getallWardrobesNameMatchString(String match) {
		return (List<Wardrobe>) session.getCurrentSession().getNamedQuery("wardrobe.allWardrobesNameMatchString").setString("search", "%"+match+"%").list();
	}

	@Override
	public void deleteWardrobes(List<Wardrobe> wardrobes) {
		for(Wardrobe ret : wardrobes)
			session.getCurrentSession().delete(ret);
	}

}
