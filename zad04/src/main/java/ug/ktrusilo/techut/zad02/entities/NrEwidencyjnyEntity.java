package ug.ktrusilo.techut.zad02.entities;

//1:1 z szafą.

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="nrEwidencyjny")
public class NrEwidencyjnyEntity {
	@Id
	@GeneratedValue( strategy= GenerationType.AUTO ) 		
	@Column(name="id")
	private int id;
	@Column(name="number")
	private long number;

	@OneToOne
    private WardrobeEntity wardrobe;
		
	public NrEwidencyjnyEntity(int id, long number) {
		super();
		this.id = id;
		this.number = number;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}

	public WardrobeEntity getWardrobe() {
		return wardrobe;
	}

	public void setWardrobe(WardrobeEntity wardrobe) {
		this.wardrobe = wardrobe;
	}

	
}
