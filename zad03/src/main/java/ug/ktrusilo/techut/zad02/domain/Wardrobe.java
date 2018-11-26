package ug.ktrusilo.techut.zad02.domain;

import java.sql.Date;

public class Wardrobe {
	
	private String name;
	private double weight;
	private Date productionDate;
	private boolean isWood;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public boolean isWood() {
		return isWood;
	}

	public void setWood(boolean isWood) {
		this.isWood = isWood;
	}

	@Override
	public String toString() {
		return "Wardrobe [name=" + name + ", weight=" + weight + ", productionDate=" + productionDate
				+ ", isWood=" + isWood + "]";
	}
	
	public Wardrobe(String name, double weight, Date productionDate, boolean isWood) {
		super();
		this.name = name;
		this.weight = weight;
		this.productionDate = productionDate;
		this.isWood = isWood;
	}
	public Wardrobe() {
		super();
	}
	
}
