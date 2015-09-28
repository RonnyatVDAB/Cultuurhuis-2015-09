package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class Genre implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	private String naam; 
	
    public static long getSerialversionuid() {
	return serialVersionUID;
	}
	
    public long getId() {
		return id;
	}
	
	public String getNaam() {
		return naam;
	}
	
}