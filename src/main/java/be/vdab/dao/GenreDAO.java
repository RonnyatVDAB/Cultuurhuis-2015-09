package be.vdab.dao;

import be.vdab.entities.Genre;

public class GenreDAO extends AbstractDAO {
	
	public Genre read(long id) {
		return getEntityManager().find(Genre.class, id);
	}
	
	public Iterable<Genre> findAllGenres() {
		return getEntityManager().createQuery("select g from Genre g", Genre.class).getResultList();
	} 
} 