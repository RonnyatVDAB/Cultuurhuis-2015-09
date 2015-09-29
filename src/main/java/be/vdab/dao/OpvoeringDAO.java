package be.vdab.dao;

import be.vdab.entities.Opvoering;

import java.util.List;

/**
 * @author guillaume.vandecasteele on 28/09/2015 at 15:04.
 */
public class OpvoeringDAO extends AbstractDAO {

	/**
	 * @param id long
	 * @return an Opvoering object with a matching id
	 */
	public Opvoering read(long id) {
		return getEntityManager().find(Opvoering.class, id);
	}

	/**
	 * @return a list of all Opvoering objects in the database
	 */
	public List<Opvoering> findAll() {
		return getEntityManager().createNamedQuery("Opvoering.findAll", Opvoering.class).getResultList();
	}

	/**
	 * @return a List of the 10 Opvoering objects, ordered by date and grouped by Voorstelling
	 */
	public List<Opvoering> findEersteTienOpvoeringen() {
		return getEntityManager().createNamedQuery("Opvoering.findEersteTienOpvoeringen", Opvoering.class)
				.setMaxResults(10)
				.getResultList();
	}
 }
