package ug.ktrusilo.techut.zad02.entities;

//Many:Many z szafą. Szafa wspoldzielona w biurze.

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="owner")
public class OwnerEntity {
	@Id
	@GeneratedValue( strategy= GenerationType.AUTO ) 		
	@Column(name="id")
	private int id;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	public OwnerEntity(int id, String firstName, String lastName, String phoneNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

    @ManyToMany(targetEntity=WardrobeEntity.class)
    private Set wardrobeSet;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Set getWardrobeSet() {
		return wardrobeSet;
	}
	public void setWardrobeSet(Set wardrobeSet) {
		this.wardrobeSet = wardrobeSet;
	}
	
}
