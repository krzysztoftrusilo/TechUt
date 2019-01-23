package ug.ktrusilo.javaut.zad04.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ug.ktrusilo.javaut.zad04.domain.Owner;
@Component
@Transactional
public class OwnerManagerHibernate implements OwnerManager {
	
	@Autowired
	SessionFactory session;
	
	@Override
	public void addOwner(Owner owner) {
		session.getCurrentSession().persist(owner);
		
	}

	@Override
	public Owner getById(long id) {
		return (Owner) session.getCurrentSession().get(Owner.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Owner> getAll() {
		return session.getCurrentSession().getNamedQuery("owner.all").list();
	}

	@Override
	public void deleteOwner(Owner owner) {
		session.getCurrentSession().delete(owner);
		
	}

	@Override
	public void updateOwner(Owner owner) {
		session.getCurrentSession().saveOrUpdate(owner);
		
	}
	
	public void clearTable()
	{
		session.getCurrentSession().createSQLQuery("TRUNCATE TABLE ENGINEER RESTART IDENTITY AND COMMIT NO CHECK").executeUpdate();
	}
}
