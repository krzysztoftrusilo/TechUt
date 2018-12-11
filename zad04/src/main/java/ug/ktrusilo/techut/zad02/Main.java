package ug.ktrusilo.techut.zad02;

import java.sql.*;
import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;

import ug.ktrusilo.techut.zad02.domain.Wardrobe;
import ug.ktrusilo.techut.zad02.service.WardrobeService;

public class Main {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws SQLException, ParseException {

			Wardrobe w1 = new Wardrobe("Marek", Double.parseDouble("200.85"), new Date(118, 12, 30), true);
	    	Wardrobe w2 = new Wardrobe("Janina", Double.parseDouble("450.90"), new Date(115, 12, 30), false);
	    	
	        WardrobeService ws = new WardrobeService();
	
	        ws.addWardrobe(w1);
	        ws.addWardrobe(w2);
	        
	        List<Wardrobe> wardrobes = new ArrayList<Wardrobe>();
	        wardrobes.add(w1);
	        wardrobes.add(w2);
	        ws.addWardrobes(wardrobes);
	        
	        Wardrobe wardrobe = ws.getWardrobeById(2);
	}

}
