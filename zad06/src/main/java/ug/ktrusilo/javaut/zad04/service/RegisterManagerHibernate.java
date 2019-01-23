package ug.ktrusilo.javaut.zad04.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ug.ktrusilo.javaut.zad04.domain.Kornik;
@Component
@Transactional
public class RegisterManagerHibernate implements KornikManager {
	
	@Autowired
	SessionFactory session;
	
	@Override
	public void addKornik(Kornik kornik) {
		session.getCurrentSession().persist(kornik);
		
	}

	@Override
	public Kornik getById(long id) {
		return (Kornik) session.getCurrentSession().get(Kornik.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Kornik> getAll() {
		return session.getCurrentSession().getNamedQuery("kornik.all").list();
	}

	@Override
	public void deleteKornik(Kornik kornik) {
		session.getCurrentSession().delete(kornik);
		
	}

	@Override
	public void updateKornik(Kornik kornik) {
		session.getCurrentSession().saveOrUpdate(kornik);
		
	}
	
	public void clearTable()
	{
		session.getCurrentSession().createSQLQuery("TRUNCATE TABLE KORNIK RESTART IDENTITY AND COMMIT NO CHECK").executeUpdate();
	}
}
