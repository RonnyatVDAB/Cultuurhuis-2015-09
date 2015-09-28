package be.vdab.dao;

import be.vdab.entities.Voorstellingen;

public class VoorstellingenDAO  extends AbstractDAO {
	
	public Voorstellingen read(long id) {
		return getEntityManager().find(Voorstellingen.class, id);
	}
	
	public Iterable<Voorstellingen> findAllVoorstellingen() {
		return getEntityManager().createQuery("select v from voorstellingen v", Voorstellingen.class).getResultList();
	} 
} 