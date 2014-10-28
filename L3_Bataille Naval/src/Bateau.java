
public abstract class Bateau {

	private String Nom;
	private int Taille;
	
	public Bateau(String nom, int taille){
		this.Nom = nom;
		this.Taille = taille;
	}
	
	public String getNom(){
		return(this.Nom);
	}
	
	public int getTaille(){
		return(this.Taille);
	}
}
