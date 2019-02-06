package ug.ktrusilo.javaut.zad04.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ug.ktrusilo.javaut.zad04.domain.Evidence;
@Component
@Transactional
public class EvidenceManagerHibernate implements EvidenceManager {
	
	@Autowired
	SessionFactory session;
	
	@Override
	public void addEvidence(Evidence evidence) {
		session.getCurrentSession().persist(evidence);
		
	}

	@Override
	public Evidence getById(long id) {
		return (Evidence) session.getCurrentSession().get(Evidence.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evidence> getAll() {
		return session.getCurrentSession().getNamedQuery("evidence.all").list();
	}

	@Override
	public void deleteEvidence(Evidence evidence) {
		session.getCurrentSession().delete(evidence);
		
	}

	@Override
	public void updateEvidence(Evidence evidence) {
		session.getCurrentSession().saveOrUpdate(evidence);
		
	}
	
	public void clearTable()
	{
		session.getCurrentSession().createSQLQuery("TRUNCATE TABLE EVIDENCE RESTART IDENTITY AND COMMIT NO CHECK").executeUpdate();
	}
}
