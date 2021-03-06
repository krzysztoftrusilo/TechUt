package ug.ktrusilo.javaut.zad04.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="producer.all",query="Select w from Producer w"),
	@NamedQuery(name="producer.name",query="Select w from Producer w where w.name = :name")
})
public class Producer {
	private long id;
	private String name;
	
	public Producer() {
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
	public Producer(String name) {
		super();
		this.name = name;
	}
	
}
