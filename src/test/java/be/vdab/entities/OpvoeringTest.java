package be.vdab.entities;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author guillaume.vandecasteele on 29/09/2015 at 12:11.
 */
public class OpvoeringTest {
	private Voorstelling correcteVoorstelling;
	private Date dateNow;
	private long correctVrijPlaatsen;
	private BigDecimal correctePrijs;
	@Before
	public void before() {
		correcteVoorstelling = new Voorstelling();
		dateNow = Calendar.getInstance().getTime();
		correctVrijPlaatsen = 200L;
		correctePrijs = BigDecimal.TEN;
	}

	@Test(expected = NullPointerException.class)
	public void eenOpvoeringAanmakenMetPrijsGelijkAanNullMagNiet() {
		Opvoering opvoering = new Opvoering(dateNow, correctVrijPlaatsen, null, correcteVoorstelling);
	}

	@Test(expected = IllegalArgumentException.class)
	public void eenOpvoeringAanmakenMetEenNegatievePrijsMagNiet() {
		Opvoering opvoering = new Opvoering(dateNow, correctVrijPlaatsen, new BigDecimal(-1), correcteVoorstelling);
	}

	@Test(expected = IllegalArgumentException.class)
	public void eenOpvoeringAanmakenMetVerledenDatumMagNiet() {
		try {
			Date verkeerdeDatum = new SimpleDateFormat("dd/MM/yyyy").parse("28/09/2015");
			Opvoering opvoering = new Opvoering(verkeerdeDatum, correctVrijPlaatsen, correctePrijs, correcteVoorstelling);
		}
		catch (ParseException ex) {
			System.err.println("Dateparsing went kablooey");
		}
	}

	@Test(expected = NullPointerException.class)
	public void eenOpvoeringAanmakenMetEenDatumGelijkAanNullMagNiet() {
		Opvoering opvoering = new Opvoering(null, correctVrijPlaatsen, correctePrijs, correcteVoorstelling);
	}

	@Test(expected = IllegalArgumentException.class)
	public void eenOpvoeringAanmakenMet0VrijePlaatsenMagNiet() {
		Opvoering opvoering = new Opvoering(dateNow, 0L, correctePrijs, correcteVoorstelling);
	}

	@Test(expected = IllegalArgumentException.class)
	public void eenOpvoeringAanmakenMetNegatieveVrijePlaatsenMagNiet() {
		Opvoering opvoering = new Opvoering(dateNow, -1L, correctePrijs, correcteVoorstelling);
	}

	@Test(expected = NullPointerException.class)
	public void eenOpvoeringAanmakenMetEenVoorstellingGelijkAanNullMagNiet() {
		Opvoering opvoering = new Opvoering(dateNow, correctVrijPlaatsen, correctePrijs, null);
	}

	@Test
	public void eenOpvoeringMetCorrecteWaardenAanmakenLuktWel() {

	}
}