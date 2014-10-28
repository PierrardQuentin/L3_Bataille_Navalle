import java.util.ArrayList;


public abstract class Joueur {

	private String Name;
	private ArrayList<Positionnement> positionnement;
	private Historique historique;

	public Joueur(){

	}

	public Joueur(String nom){
		this.Name = nom;
		positionnement = new ArrayList<Positionnement>();
		historique = new Historique();
	}
	
	
	//////// GET ///////
	public String getName(){
		return(this.Name);
	}

	public ArrayList<Positionnement> getPositionnement(){
		return(this.positionnement);
	}

	public Historique getHistorique(){
		return(this.historique);
	}

	//////// SET ///////
	public void setPositionnement(Positionnement pos){
		this.positionnement.add(pos);
	}
	
	public void setBateau(Bateau bateau, int i){
		this.positionnement.get(i).setBateau(bateau);
	}

	//////////////////////////////////
	////Methode d'initialisation /////
	//////////////////////////////////
	protected boolean definePosition(int x, int y, Bateau b, int Max, String sens){
		boolean bool = false;
		if(this.dansTable(x, y, b.getTaille(), Max, sens)){
			bool = this.superposer(x, y, b.getTaille(), sens);
		}
		return bool;
	}
	
	// Check si le bateau tient dans la grille
	protected boolean dansTable(int choixX, int choixY, int taille, int Max, String sens){
		if(sens == "N" && choixY-taille<0 || sens == "W" && choixX-taille<0 || sens == "S" && choixY+taille>Max || sens == "E" && choixX+taille>Max){
			return false;
		}
		return true;
	}

	// check si le bateau n'en ecrase pas un autre et l'enregistre si non
	protected boolean superposer(int choixX, int choixY, int taille, String sens){
		ArrayList<Position> temp = new ArrayList<Position>();

		for(int i=0;i<taille;i++){
			Position position =  new Position();
			if(sens == "N"){
				position = new Position(choixX,choixY-i);
				temp.add(position);
			}
			else if(sens == "W"){
				position = new Position(choixX-i,choixY);
				temp.add(position);
			}
			else if(sens == "S"){
				position = new Position(choixX,choixY+i);
				temp.add(position);
			}
			else if(sens == "E"){
				position = new Position(choixX+i,choixY);
				temp.add(position);
			}

			if(this.getHistorique().getTabBoat().contains(position))
				return false;
		}

		this.getHistorique().getTabBoat().addAll(temp);
		
		return true;
	}
	
	//////////////////////////////////
	//// Methode en cours jeu ////////
	//////////////////////////////////
	//Methode de tir
	public int tir(int x, int y){
		Position p=new Position(x,y);
		if(CheckHistorique(p)){
			return 0; // position deja touchee
		}else if(CheckBateaux(p)){
			historique.addPositionTir(p);
			historique.addPositionBoatTouch(p);
			return 1; // bateau touche
		}else{
			historique.addPositionTir(p);
			return 2; // plouf
		}
	}

	//Position deja touchee ou pas ?
	public boolean CheckHistorique(Position p){
		return historique.getTabTir().contains(p);
	}

	//Bateau touche ou pas ?
	public boolean CheckBateaux(Position p){
		return historique.getTabBoat().contains(p);
	}
	
	
}