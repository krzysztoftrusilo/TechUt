package ug.ktrusilo.techut.zad02.entities;

//Many:1 z szafą

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="producent")
public class ProducentEntity {
	@Id
	@GeneratedValue( strategy= GenerationType.AUTO ) 		
	@Column(name="id")
	private int id;
	@Column(name="nameProducent")
	private String nameProducent;
	@Column(name="city")
	private String city;
	@Column(name="street")
	private String street;
	@Column(name="postCode")
	private String postCode;
	@Column(name="contact")
	private String contact;
	public int getId() {
		return id;
	}
			
	public ProducentEntity(int id, String nameProducent, String city, String street, String postCode, String contact,
			WardrobeEntity wardrobe) {
		super();
		this.id = id;
		this.nameProducent = nameProducent;
		this.city = city;
		this.street = street;
		this.postCode = postCode;
		this.contact = contact;
		this.wardrobe = wardrobe;
	}

	@ManyToOne
	private WardrobeEntity wardrobe;
	
	public void setId(int id) {
		this.id = id;
	}
	public String getNameProducent() {
		return nameProducent;
	}
	public void setNameProducent(String nameProducent) {
		this.nameProducent = nameProducent;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

	public WardrobeEntity getWardrobe() {
		return wardrobe;
	}

	public void setWardrobe(WardrobeEntity wardrobe) {
		this.wardrobe = wardrobe;
	}
	
}
