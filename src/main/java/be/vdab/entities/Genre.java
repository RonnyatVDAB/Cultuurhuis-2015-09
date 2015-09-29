package be.vdab.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class Genre implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	private String naam;
	@OneToMany(mappedBy = "voorstellingen")
	private Set<Voorstelling> voorstellingen;
	
    public Genre() {}
	
	public Genre(String naam) {
		setNaam(naam);
	}

	public static long getSerialversionuid() {
	return serialVersionUID;
	}
	
    public long getId() {
		return id;
	}
	
	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		if (!isNaamValid(naam)) {
			throw new IllegalArgumentException();
		}
    	this.naam = naam;
	}
	
	private static boolean isNaamValid(String naam) { 
		return naam != null && ! naam.isEmpty();
	}
	
}