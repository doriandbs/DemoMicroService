package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Livre;
import enums.CategLivre;

public class LivreDao {
	private static LivreDao instance;
	private List<Livre> livres = new ArrayList<>();
	private LivreDao() {
		livres.add(new Livre(1L,"TITRE 1 ", "Auteur 1", new Date(2005),CategLivre.DRAME));
		livres.add(new Livre(2L,"TITRE 2 ", "Auteur 2", new Date(2015),CategLivre.ROMANCE));
		livres.add(new Livre(3L,"TITRE 3 ", "Auteur 3", new Date(2025),CategLivre.SCI_FI));
	}
	
	public static LivreDao getInstance() {
		if(instance==null) {
			instance = new LivreDao();
		}
		return instance;
	}
	
	//crud
	public List<Livre> getAllLivres(){
		return livres;
	}
	
	public Livre getLivreById(Long id){
		for(Livre livre : livres) {
			if(livre.getId().equals(id)) {
				return livre;
			}
		}
		return null;
	}
	
	public void addLivre(Livre livre) {
		livres.add(livre);
	}
	
	public void updateLivre(Livre livre) {
		Livre existingLivre = getLivreById(livre.getId());
		if(existingLivre != null) {
			existingLivre.setAnneePublication(livre.getAnneePublication());
			existingLivre.setAuteur(livre.getAuteur());
			existingLivre.setTitre(livre.getTitre());
			existingLivre.setCategorie(livre.getCategorie());
		}
	}
	

	public void deleteLivre(Long id) {
		livres.removeIf(livre -> livre.getId().equals(id));
	}
}
