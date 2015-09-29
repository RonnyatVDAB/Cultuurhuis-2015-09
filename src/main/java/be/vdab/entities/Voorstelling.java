package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="voorstellingen")
public class Voorstelling implements Serializable {
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String titel;
	private String uitvoerder;
	@ManyToOne(optional=false)
	@JoinColumn(name="genreid")
	private Genre genre;
	
	public String getVoorstelling(){
		return titel + " " + uitvoerder;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getUitvoerder() {
		return uitvoerder;
	}

	public void setUitvoerder(String uitvoerder) {
		this.uitvoerder = uitvoerder;
	}
}
