package ug.ktrusilo.techut.zad02.service;

import java.util.List;
import ug.ktrusilo.techut.zad02.domain.Wardrobe;

public interface WardrobeInterface {
	public void addWardrobe(Wardrobe wardrobe);
	public List<Wardrobe> getallWardrobes();
	public Wardrobe getWardrobeById(int id);
	public void deleteAllWardrobes();
	public void deleteWardrobeById(int id);
	public boolean addWardrobes(List<Wardrobe> wardrobes);
	public List<Wardrobe> getWardrobesHeavierThan(double weight);
}
