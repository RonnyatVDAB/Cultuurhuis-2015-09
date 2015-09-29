package be.vdab.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class VoorstellingTest {

	@Test(expected=IllegalArgumentException.class)
	public void titelIsNull() {
		new Voorstelling(null,"Ik en jij",new Genre());
	}
	@Test(expected=IllegalArgumentException.class)
	public void titelIsLeeg() {
		new Voorstelling("","Ik en jij",new Genre());
	}
	@Test(expected=IllegalArgumentException.class)
	public void uitvoerderIsNull() {
		new Voorstelling("Hij en zij",null,new Genre());
	}
	@Test(expected=IllegalArgumentException.class)
	public void uitvoerderIsLeeg() {
		new Voorstelling("Hij en zij","",new Genre());
	}
	@Test(expected=IllegalArgumentException.class)
	public void genreIsNull() {
		new Voorstelling("Hij en zij","Ik en jij",null);
	}
}
