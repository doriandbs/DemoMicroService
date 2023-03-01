package entities;

import java.util.Date;

import enums.CategLivre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  
@NoArgsConstructor 
@AllArgsConstructor
public class Livre {
	private Long id;
	private String titre;
	private String auteur;
	private Date anneePublication;
	private CategLivre categorie;
}
