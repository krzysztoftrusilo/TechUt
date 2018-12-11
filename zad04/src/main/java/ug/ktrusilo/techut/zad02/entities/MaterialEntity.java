package ug.ktrusilo.techut.zad02.entities;

//1:Many z szafą

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="material")
public class MaterialEntity {
	@Id
	@GeneratedValue( strategy= GenerationType.AUTO ) 		
	@Column(name="id")
	private int id;
	@Column(name="nameMaterial")
	private String nameMaterial;
	@Column(name="strenght")
	private Double strenght;
	
	public MaterialEntity(int id, String nameMaterial, Double strenght) {
		super();
		this.id = id;
		this.nameMaterial = nameMaterial;
		this.strenght = strenght;
	}
	
    @OneToMany( targetEntity=WardrobeEntity.class )
    private List wardrobelist;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameMaterial() {
		return nameMaterial;
	}
	public void setNameMaterial(String nameMaterial) {
		this.nameMaterial = nameMaterial;
	}
	public Double getStrenght() {
		return strenght;
	}
	public void setStrenght(Double strenght) {
		this.strenght = strenght;
	}
	public List getWardrobelist() {
		return wardrobelist;
	}
	public void setWardrobelist(List wardrobelist) {
		this.wardrobelist = wardrobelist;
	}
	
	
}
