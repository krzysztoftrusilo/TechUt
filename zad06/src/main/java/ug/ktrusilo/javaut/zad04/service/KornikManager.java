package ug.ktrusilo.javaut.zad04.service;

import java.util.List;

import ug.ktrusilo.javaut.zad04.domain.Kornik;

public interface KornikManager {
	void addKornik(Kornik kornik);
	Kornik getById(long id);
	List<Kornik> getAll();
	void deleteKornik(Kornik kornik);
	void updateKornik(Kornik kornik);
	void clearTable();
}
