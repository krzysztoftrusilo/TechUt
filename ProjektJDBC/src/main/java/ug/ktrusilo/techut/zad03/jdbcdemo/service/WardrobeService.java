package ug.ktrusilo.techut.zad03.jdbcdemo.service;

import java.util.List;

import ug.ktrusilo.techut.zad03.jdbcdemo.domain.Wardrobe;

public interface WardrobeService {
	boolean addWardrobe(Wardrobe wardrobe);
	List<Wardrobe> getAllWardrobes();
	List<Wardrobe> getAllWardrobesDoorsMoreThanOrEqual(int doors);
	Wardrobe getWardrobeById(int id);
	Wardrobe getWardrobeByName(String name);
	boolean deleteAllWardrobes();
	boolean deleteWardrobeById(int id);
	boolean addAllWardrobes(List<Wardrobe> wardrobes);
}
