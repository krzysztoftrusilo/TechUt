package ug.ktrusilo.javaut.zad04.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ug.ktrusilo.javaut.zad04.domain.NumerEw;
@Component
@Transactional
public class NumerEwManagerHibernate implements NumerEwManager {
	
	@Autowired
	SessionFactory session;
	
	@Override
	public void addNumerEw(NumerEw numerEw) {
		session.getCurrentSession().persist(numerEw);
		
	}

	@Override
	public NumerEw getById(long id) {
		return (NumerEw) session.getCurrentSession().get(NumerEw.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NumerEw> getAll() {
		return session.getCurrentSession().getNamedQuery("numerEw.all").list();
	}

	public void deleteNumerEw(NumerEw numerEw) {
		session.getCurrentSession().delete(numerEw);
		
	}

	public void updateNumerEw(NumerEw numerEw) {
		session.getCurrentSession().saveOrUpdate(numerEw);
		
	}
	
	public void clearTable()
	{
		session.getCurrentSession().createSQLQuery("TRUNCATE TABLE NUMEREW RESTART IDENTITY AND COMMIT NO CHECK").executeUpdate();
	}
}
