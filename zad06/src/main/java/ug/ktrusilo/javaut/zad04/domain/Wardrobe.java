package ug.ktrusilo.javaut.zad04.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@NamedQuery(name="wardrobe.allWardrobesByProducer",query="select w from Wardrobe w JOIN w.producer p where p.name = :name"),

})
public class Wardrobe {
	private long id;
	@Column(unique=true)
	
	private String name;
	private int doors;
	private double weight;
	private Date productionDate;
	
	private Producer producer; //m:1
	private NumerEw numerEw; //1:1
	private Set<Owner> ownedBy = new HashSet<Owner>(); //m:m
	private Set<Kornik> korniks = new HashSet<Kornik>(); //1:m

	
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
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Date getProductionDate() {
		return productionDate;
	}
	public void setDate(String productiondate) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.productionDate=(df.parse(productiondate));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setDate(Date date) {
		this.productionDate=date;
	}
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
	public NumerEw getNumerEw() {
		return numerEw;
	}

	public void setNumerEw(NumerEw numerEw) {
		this.numerEw = numerEw;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	public Set<Owner> getOwnedBy() {
		return ownedBy;
	}
	public void setOwnedBy(Set<Owner> ownedBy) {
		this.ownedBy = ownedBy;
	}
	
	@OneToMany(fetch=FetchType.EAGER)
	public Set<Kornik> getKorniks() {
		return korniks;
	}

	public void setKorniks(Set<Kornik> korniks) {
		this.korniks = korniks;
	}
	
	public Wardrobe() {
		super();
	}

	
}
