package be.vdab.entities;

import static org.junit.Assert.*;
import org.junit.Test;

public class GenreTest {
	
	@Test
	public void geldigeGenre() { //mag geen exception geven
		new Genre("Horror");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void legeNaamIsFout() { 
		new Genre(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naamMetNulTekensIsFout() { 
		new Genre("");
	}
	
}