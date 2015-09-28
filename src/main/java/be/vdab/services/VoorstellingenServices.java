package be.vdab.services;

import be.vdab.dao.VoorstellingenDAO;
import be.vdab.entities.Voorstellingen;

public class VoorstellingenServices {
	private final VoorstellingenDAO voorstellingenDAO = new VoorstellingenDAO();   
	
	public Voorstellingen read(long id) {
		return voorstellingenDAO.read(id);     	
    }
	
	public Iterable<Voorstellingen> findAllVoorstellingen() {
		return voorstellingenDAO.findAllVoorstellingen();
	} 

} 