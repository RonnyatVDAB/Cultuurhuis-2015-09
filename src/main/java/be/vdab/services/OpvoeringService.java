package be.vdab.services;

import be.vdab.dao.OpvoeringDAO;
import be.vdab.entities.Opvoering;

import java.util.List;

/**
 * @author guillaume.vandecasteele on 29/09/2015 at 12:00.
 */
public class OpvoeringService {
	private final OpvoeringDAO opvoeringDAO = new OpvoeringDAO();

	/**
	 * @param id long
	 * @return an Opvoering object that matches the id parameter
	 */
	public Opvoering read(long id) {
		return opvoeringDAO.read(id);
	}

	/**
	 * Returns a List of all Opvoering objects in the database
	 */
	public List<Opvoering> findAll() {
		return opvoeringDAO.findAll();
	}

	/**
	 * Returns a List of 10 Opvoering objects, ordered by date and grouped by Voorstelling
	 */
	public List<Opvoering> findEersteTienOpvoeringen() {
		return opvoeringDAO.findEersteTienOpvoeringen();
	}
}
