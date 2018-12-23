package ug.ktrusilo.javaut.zad05.service;

import java.util.List;

import ug.ktrusilo.javaut.zad05.domain.Wardrobe;

public interface WardrobeManager {
	void addWardrobe(Wardrobe wardrobe);
	Wardrobe getById(long id);
	List<Wardrobe> getAllWardrobes();
	void deleteWardrobe(Wardrobe wardrobe);
	void updateWardrobe(Wardrobe wardrobe);
	void clearTable();
}
