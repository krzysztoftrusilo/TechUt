package ug.ktrusilo.javaut.zad05.domain;

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
import javax.persistence.OneToOne;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQueries({
	@NamedQuery(name="processor.all",query="select p from Processor p")
})
public class Wardrobe {
	private long id;
	private String name;
	private int doors;
	private double weight;
	private Date productionDate;
	private Producer producer;
	private NumerEw numerEw;
	private Set<Owner> owners = new HashSet<Owner>();
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
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Date getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(String productionDate) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.productionDate=(df.parse(productionDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setProductionDate(Date productionDate) {
		this.productionDate=productionDate;
	}
	@ManyToOne(cascade = CascadeType.PERSIST, fetch=FetchType.EAGER)
	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	@OneToOne(cascade = CascadeType.PERSIST, fetch=FetchType.EAGER)
	public NumerEw getNumerEw() {
		return numerEw;
	}

	public void setNumerEw(NumerEw numerEw) {
		this.numerEw = numerEw;
	}
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch=FetchType.EAGER)
	public Set<Owner> getOwners() {
		return owners;
	}

	public void setOwners(Set<Owner> owners) {
		this.owners = owners;
	}
}
