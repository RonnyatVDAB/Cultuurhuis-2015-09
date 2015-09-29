package be.vdab.entities;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author guillaume.vandecasteele on 28/09/2015 at 15:05.
 */
@Entity
@Table(name = "opvoeringen")
public class Opvoering {
	private static final long serialVersionUID = 1L;

	public Opvoering() {}

	public Opvoering(Date datum, long vrijeplaatsen, BigDecimal prijs, Voorstelling voorstelling) {
		setDatum(datum);
		setVrijeplaatsen(vrijeplaatsen);
		setPrijs(prijs);
		setVoorstelling(voorstelling);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date datum;
	private long vrijeplaatsen;
	private BigDecimal prijs;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "voorstellingsid")
	private Voorstelling voorstelling;

	public long getId() {
		return id;
	}

	public Date getDatum() {
		return datum;
	}

	public long getVrijeplaatsen() {
		return vrijeplaatsen;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	public Voorstelling getVoorstelling() {
		return voorstelling;
	}

	private void setDatum(Date datum) {
		this.datum = datum;
	}

	private void setVrijeplaatsen(long vrijeplaatsen) {
		this.vrijeplaatsen = vrijeplaatsen;
	}

	private void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}

	private void setVoorstelling(Voorstelling voorstelling) {
		this.voorstelling = voorstelling;
	}
}
