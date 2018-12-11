package ug.ktrusilo.techut.zad02.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="wardrobe")
public class WardrobeEntity {
	@Id
	@GeneratedValue( strategy= GenerationType.AUTO ) 		
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="productionDate")
	private Date productionDate;
	@Column(name="weight")
	private double weight;
	@Column(name="isWood")
	private boolean isWood;
	
public WardrobeEntity(int id, String name, Date productionDate, double weight, boolean isWood) {
		super();
		this.id = id;
		this.name = name;
		this.productionDate = productionDate;
		this.weight = weight;
		this.isWood = isWood;
	}

	@ManyToMany(targetEntity = OwnerEntity.class)
	private Set ownerSet;

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
public Set getOwnerSet() {
	return ownerSet;
}
public void setOwnerSet(Set ownerSet) {
	this.ownerSet = ownerSet;
}

}