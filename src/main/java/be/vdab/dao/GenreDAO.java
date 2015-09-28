package be.vdab.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import be.vdab.entities.Genre;
import be.vdab.filters.JPAFilter;

public class GenreDAO {
	
	public Genre read(long id, EntityManager entityManager) {
		return entityManager.find(Genre.class, id);
	}
	
	public ArrayList<Genre> findAllGenres() {
		
	}
} 