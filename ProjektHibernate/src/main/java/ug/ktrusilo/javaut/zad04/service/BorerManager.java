package ug.ktrusilo.javaut.zad04.service;

import java.util.List;

import ug.ktrusilo.javaut.zad04.domain.Borer;

public interface BorerManager {
	void addBorer(Borer borer);
	Borer getById(long id);
	List<Borer> getAll();
	void deleteBorer(Borer borer);
	void updateBorer(Borer borer);
	void clearTable();
}
