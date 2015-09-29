package be.vdab.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * @author guillaume.vandecasteele on 28/09/2015 at 15:05.
 */
@Entity
@Table(name = "opvoeringen")
public class Opvoering {
	private static final long serialVersionUID = 1L;

	protected Opvoering() {}

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
		if (isDatumValid(datum)) this.datum = datum;
	}

	private void setVrijeplaatsen(long vrijeplaatsen) {
		if (isVrijeplaatsenValid(vrijeplaatsen)) this.vrijeplaatsen = vrijeplaatsen;
	}

	private void setPrijs(BigDecimal prijs) {
		if (isPrijsValid(prijs)) this.prijs = prijs;
	}

	private void setVoorstelling(Voorstelling voorstelling) {
		if (isVoorstellingValid(voorstelling)) this.voorstelling = voorstelling;
	}

	/**
	 * Checks if Voorstelling is not null
	 * @param voorstelling Voorstelling object
	 * @return Returns true if not null
	 * @throws NullPointerException If Voorstelling equals null
	 */
	public static boolean isVoorstellingValid(Voorstelling voorstelling) {
		if (voorstelling != null) {
			return true;
		}
		else {
			throw new NullPointerException();
		}
	}

	/**
	 * Checks if prijs is a valid value
	 * @param prijs BigDecimal
	 * @return Returns true if prijs is greater than or equal to zero
	 * @throws IllegalArgumentException If prijs is less than zero
	 * @throws NullPointerException if prijs equals null
	 */
	public static boolean isPrijsValid(BigDecimal prijs) {
		if (prijs != null) {
			if (prijs.compareTo(BigDecimal.ZERO) >= 0) {
				return true;
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		else {
			throw new NullPointerException();
		}
	}

	/**
	 * Checks if the date is valid
	 * @param date Date
	 * @return Returns true if date comes after midnight of the current date and is not null
	 * @throws IllegalArgumentException If date is not current or future
	 * @throws NullPointerException If date equals null
	 */
	public static boolean isDatumValid(Date date) {
		if (date != null)  {
			if (date.after(getTodaysDate())) {
				return true;
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		else {
			throw new NullPointerException();
		}
	}

	/**
	 * Checks if vrijeplaatsen is valid
	 * @param vrijeplaatsen long
	 * @return Returns true if vrijeplaatsen is larger than 0
	 * @throws IllegalArgumentException If vrijeplaatsen <= 0
	 */
	public static boolean isVrijeplaatsenValid(long vrijeplaatsen) {
		if (vrijeplaatsen > 0) {
			return true;
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Returns a Date object of today's date
	 * @return Returns today's date at precisely midnight
	 */
	private static Date getTodaysDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
}
