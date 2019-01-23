package ug.ktrusilo.javaut.zad04.service;

import java.util.List;

import ug.ktrusilo.javaut.zad04.domain.Wardrobe;

public interface WardrobeManager {
	void addWardrobe(Wardrobe wardrobe);
	Wardrobe getById(long id);
	List<Wardrobe> getAllWardrobes();
	List<Wardrobe> getAllWardrobesByProducerName(String name);
	void deleteWardrobe(Wardrobe wardrobe);
	void deleteWardrobes(List<Wardrobe> wardrobes);
	void updateWardrobe(Wardrobe wardrobe);
	void clearTable();
	List<Wardrobe> getallWardrobesNameMatchString(String match);
}
