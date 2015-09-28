package be.vdab.dao;

import be.vdab.entities.Voorstelling;

public class VoorstellingDAO  extends AbstractDAO {
	
	public Voorstelling read(long id) {
		return getEntityManager().find(Voorstelling.class, id);
	}
	
	public Iterable<Voorstelling> findAllVoorstellingen() {
		return getEntityManager().createQuery("select v from voorstellingen v", Voorstelling.class).getResultList();
	} 
} 