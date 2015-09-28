package be.vdab.services;

import javax.persistence.EntityManager;

import be.vdab.dao.GenreDAO;
import be.vdab.entities.Genre;
import be.vdab.filters.JPAFilter;

public class GenreService {
	private final GenreDAO genreDAO = new GenreDAO();   
	
	public Genre read(long id) {
		return genreDAO.read(id);     	
    }
	
	public Iterable<Genre> findAllGenres() {
		return genreDAO.findAllGenres();
	} 

} 