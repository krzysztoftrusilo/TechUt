package ug.ktrusilo.javaut.zad04.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ug.ktrusilo.javaut.zad04.domain.Owner;
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
		session.getCurrentSession().createSQLQuery("TRUNCATE TABLE EVIDENCE RESTART IDENTITY AND COMMIT NO CHECK").executeUpdate();
		session.getCurrentSession().createSQLQuery("TRUNCATE TABLE PRODUCER RESTART IDENTITY AND COMMIT NO CHECK").executeUpdate();
		session.getCurrentSession().createSQLQuery("TRUNCATE TABLE WARDROBE_OWNER RESTART IDENTITY AND COMMIT NO CHECK").executeUpdate();
		session.getCurrentSession().createSQLQuery("TRUNCATE TABLE BORER RESTART IDENTITY AND COMMIT NO CHECK").executeUpdate();
		session.getCurrentSession().createSQLQuery("TRUNCATE TABLE WARDROBE_BORER RESTART IDENTITY AND COMMIT NO CHECK").executeUpdate();
		session.getCurrentSession().createSQLQuery("TRUNCATE TABLE WARDROBE RESTART IDENTITY AND COMMIT NO CHECK").executeUpdate();
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Wardrobe> getAllWardrobesByProducerName(String name) {
		return (List<Wardrobe>) session.getCurrentSession().getNamedQuery("wardrobe.allWardrobesByProducer").setString("name", name).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Owner> getAllOwners(long id) {
		return (List<Owner>) session.getCurrentSession().getNamedQuery("wardrobe.getAllOwners").setLong("id", id).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Wardrobe> getallWardrobesOwnersMoreEqualThan(int number) {
		return (List<Wardrobe>) session.getCurrentSession().getNamedQuery("wardrobe.allWardrobesOwnersMoreEqualThan").setInteger("number", number).list();
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Wardrobe> getAllWardrobesWithDateBetween(String date1, String date2) {
		Date date1p = null;
		Date date2p = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date1p=(df.parse(date1));
			date2p=(df.parse(date2));
			return (List<Wardrobe>) session.getCurrentSession().getNamedQuery("wardrobe.allWardrobesByDateBetween").setDate("date1", date1p).setDate("date2", date2p).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
