package be.vdab.services;

import be.vdab.dao.VoorstellingDAO;
import be.vdab.entities.Voorstelling;

public class VoorstellingService {
	private final VoorstellingDAO voorstellingenDAO = new VoorstellingDAO();   
	
	public Voorstelling read(long id) {
		return voorstellingenDAO.read(id);     	
    }
	
	public Iterable<Voorstelling> findAllVoorstellingen() {
		return voorstellingenDAO.findAllVoorstellingen();
	} 

} 