package ug.ktrusilo.javaut.zad04.domain;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQueries({
	@NamedQuery(name="wardrobe.all",query="select w from Wardrobe w"),
	@NamedQuery(name="wardrobe.getAllOwners",query="select w.owners from Wardrobe w where w.id = :id"),
	@NamedQuery(name="wardrobe.allWardrobesByProducer",query="select w from Wardrobe w JOIN w.producer mm where mm.name = :name"),
	@NamedQuery(name="wardrobe.allWardrobesByDateBetween",query="select w from Wardrobe w where w.date between :date1  and :date2"),
	@NamedQuery(name="wardrobe.allWardrobesOwnersMoreEqualThan",query="select w from Wardrobe w JOIN w.owners e group by w.id having count(e.id) >= :number"),
	@NamedQuery(name="wardrobe.allWardrobesNameMatchString",query="select w from Wardrobe w where w.name LIKE :search")
})
public class Wardrobe {
	private long id;
	private String name;
	private int doors;
	private double weight;
	private Date date;
	private Producer producer;
	private Evidence evidence;
	private Set<Owner> owners = new HashSet<Owner>();
	private Set<Borer> borers = new HashSet<Borer>();
	
	public Wardrobe() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public Date getDate() {
		return date;
	}
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setDate(String date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.date=(df.parse(date));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setDate(Date date) {
		this.date=date;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
	public Evidence getEvidence() {
		return evidence;
	}
	public void setEvidence(Evidence evidence) {
		this.evidence = evidence;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	public Set<Owner> getOwners() {
		return owners;
	}
	public void setOwners(Set<Owner> owners) {
		this.owners = owners;
	}
	
	@OneToMany(fetch=FetchType.EAGER)
	public Set<Borer> getBorers() {
		return borers;
	}

	public void setBorers(Set<Borer> borers) {
		this.borers = borers;
	}

}
