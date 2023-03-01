package web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.LivreDao;
import entities.Livre;


@RestController
public class LivreRestController {
	private LivreDao livreDao = LivreDao.getInstance();
	
	@GetMapping("/livres")
	public List<Livre> getAllLivres(){
		return livreDao.getAllLivres();
	}
	
	@PostMapping("/livre")
	public ResponseEntity<Void> addLivre(@RequestBody Livre livre) {
		livreDao.addLivre(livre);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Livre> getLivreById(@PathVariable Long id){
		Livre livre = livreDao.getLivreById(id);
		if(livre!=null) {
			return new ResponseEntity<>(livre, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(livre,HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Livre> modifLivre(@PathVariable Long id, @RequestBody Livre livreModifie){
		Livre livre = livreDao.getLivreById(id);
		if(livre!=null) {
			livreDao.updateLivre(livreModifie);
			return new ResponseEntity<>(livre, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(livre,HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Livre> deleteLivre(@PathVariable Long id){
		Livre livre = livreDao.getLivreById(id);
		if(livre!=null) {
			livreDao.deleteLivre(id);
			return new ResponseEntity<>(livre, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(livre,HttpStatus.NOT_FOUND);
		}	
	}
}
