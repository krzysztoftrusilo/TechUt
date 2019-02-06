package ug.ktrusilo.javaut.zad04.service;

import java.util.List;

import ug.ktrusilo.javaut.zad04.domain.Evidence;

public interface EvidenceManager {
	void addEvidence(Evidence evidence);
	Evidence getById(long id);
	List<Evidence> getAll();
	void deleteEvidence(Evidence evidence);
	void updateEvidence(Evidence evidence);
	void clearTable();
}
