package be.vdab.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="voorstellingen")
public class Voorstelling implements Serializable {
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String titel;
	private String uitvoerder;
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name="genreid")
	private Genre genre;
	@OneToMany(mappedBy = "voorstelling")
	@OrderBy("datum")
	private Set<Opvoering> opvoeringen;
	
	public Voorstelling() {
	}
	public Voorstelling(String titel, String uitvoerder, Genre genre){
		titelCtl(titel);
		this.titel=titel;
		uitvoerderCtl(uitvoerder);
		this.uitvoerder=uitvoerder;
		genreCtl(genre);
		this.genre=genre;
	}
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
		titelCtl(titel);
		this.titel = titel;
	}

	public String getUitvoerder() {
		return uitvoerder;
	}

	public void setUitvoerder(String uitvoerder) {
		uitvoerderCtl(uitvoerder);
		this.uitvoerder = uitvoerder;
	}
	public void titelCtl(String titel){
		if ((titel==null) || (titel.isEmpty())) {
			throw new IllegalArgumentException();
		}
	}
	public void uitvoerderCtl(String uitvoerder){
		if ((uitvoerder==null) || (uitvoerder.isEmpty())) {
			throw new IllegalArgumentException();
		}	
	}
	public void genreCtl(Genre genre){
		if (genre==null) {
			throw new IllegalArgumentException();
		}
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Set<Opvoering> getOpvoeringen() {
		return opvoeringen;
	}
	public void setOpvoeringen(Set<Opvoering> opvoeringen) {
		this.opvoeringen = opvoeringen;
	}
	
	
}
