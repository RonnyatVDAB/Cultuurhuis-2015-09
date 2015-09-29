package be.vdab.services;

import be.vdab.dao.GenreDAO;
import be.vdab.entities.Genre;


public class GenreService {
	private final GenreDAO genreDAO = new GenreDAO();   
	
	public Genre read(long id) {
		return genreDAO.read(id);     	
    }
	
	public Iterable<Genre> findAllGenres() {
		return genreDAO.findAllGenres();
	} 

} 