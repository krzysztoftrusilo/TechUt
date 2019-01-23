package ug.ktrusilo.javaut.zad04.service;

import java.util.List;

import ug.ktrusilo.javaut.zad04.domain.NumerEw;

public interface NumerEwManager {
	void addNumerEw(NumerEw numerEw);
	NumerEw getById(long id);
	List<NumerEw> getAll();
	void deleteNumerEw(NumerEw numerEw);
	void updateNumerEw(NumerEw numerEw);
	void clearTable();
}
