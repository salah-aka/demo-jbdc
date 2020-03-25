package fr.diginamic.jdbc.entites;

/**Représente la classe fournisseur 
 * @author Salaheddine El Majdoub
 *
 */
public class Fournisseur {
	public int id ;
	public String nom ;
	
	
	/**constructeur
	 * @param id : identifiant fournisseur 
	 * @param nom : nom de fournisseur 
	 */
	public Fournisseur(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}


	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", nom=" + nom + "]";
	}


}
