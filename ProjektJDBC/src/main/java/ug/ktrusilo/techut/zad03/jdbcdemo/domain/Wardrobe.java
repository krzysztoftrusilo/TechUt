package ug.ktrusilo.techut.zad03.jdbcdemo.domain;

import java.sql.Date;

public class Wardrobe {
	int id;
	String name;
	int doors;
	double weight;
	Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Wardrobe(String name, int doors, double weight, Date date) {
		super();

		this.name = name;
		this.doors = doors;
		this.weight = weight;
		this.date = date;
	}
	
	public Wardrobe() {
		super();
	}
	
	@Override
	public String toString() {
		return "Wardrobe [id=" + id + ", name=" + name + ", doors=" + doors + ", weight=" + weight + ", date="
				+ date + "]\n";
	}
}
