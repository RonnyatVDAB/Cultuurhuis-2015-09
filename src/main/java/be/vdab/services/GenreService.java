package be.vdab.services;

import javax.persistence.EntityManager;

public class GenreService {
	private final GenreDAO genreDAO = new GenreDAO();   
	
	public Genre read(long id) {
		EntityManager entityManager = JPAFilter.getEntityManager();     
		try {
			return genreDAO.read(id, entityManager);     
		} 
		finally {
			entityManager.close();     
		}
  }
} 