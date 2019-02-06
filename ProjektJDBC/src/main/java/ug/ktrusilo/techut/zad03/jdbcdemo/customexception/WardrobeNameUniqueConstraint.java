package ug.ktrusilo.techut.zad03.jdbcdemo.customexception;

public class WardrobeNameUniqueConstraint extends Exception {
	private static final long serialVersionUID = -6761951757383457070L;

	public WardrobeNameUniqueConstraint(String s){
		super(s);
	}
}
