package ug.ktrusilo.javaut.zad04.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ug.ktrusilo.javaut.zad04.domain.Borer;
@Component
@Transactional
public class BorerManagerHibernate implements BorerManager {
	
	@Autowired
	SessionFactory session;
	
	@Override
	public void addBorer(Borer borer) {
		session.getCurrentSession().persist(borer);
	
	}

	@Override
	public Borer getById(long id) {
		return (Borer) session.getCurrentSession().get(Borer.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Borer> getAll() {
		return session.getCurrentSession().getNamedQuery("borer.all").list();
	}

	@Override
	public void deleteBorer(Borer borer) {
		session.getCurrentSession().delete(borer);
		
	}

	@Override
	public void updateBorer(Borer borer) {
		session.getCurrentSession().saveOrUpdate(borer);
		
	}
	
	public void clearTable()
	{
		session.getCurrentSession().createSQLQuery("TRUNCATE TABLE BORER RESTART IDENTITY AND COMMIT NO CHECK").executeUpdate();
	}
}
