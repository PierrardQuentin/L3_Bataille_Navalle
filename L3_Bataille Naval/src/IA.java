
public class IA extends Joueur{

	public IA(){
		super();
	}
	
	//Constructeur de base copiant les bateaux du joueur -> J vs IA
	public IA(String nom, Joueur j, int Max){
		super(nom);
		copieBateau(j);
		miseEnPlaceIA(Max);
	}

	///// Methode ///////
	///// Selection du tir //////
	public int tirIA(int Max){
		int choixValide = -1;
		while(choixValide<1){
			int x = (int)( Math.random()*( Max - 0 + 1 ) ) + 0;
			int y = (int)( Math.random()*( Max - 0 + 1 ) ) + 0;
			choixValide = super.tir(x,y);
		}
		return choixValide;
	}

	
	/////////  Methode pour la creation d'une IA /////////////
	
	//creation de la lsite des bateau par copie de seul du joueur
	public void copieBateau(Joueur j){
		for(int i=0;i<j.getPositionnement().size();i++){
			super.setBateau(j.getPositionnement().get(i).getBateau(),i);
		}
	}
	
	///// Position des bateaux //////
	public void miseEnPlaceIA(int Max){
		String sens;
		int choixX, choixY;
		boolean choixValide;

		for(int i=0;i<super.getPositionnement().size();i++ ){
			choixValide =false;
			while(choixValide==false){
				choixX = (int)( Math.random()*( Max - 0 + 1 ) ) + 0;
				choixY = (int)( Math.random()*( Max - 0 + 1 ) ) + 0;
				this.getPositionnement().get(i).getOrientation().setOrientation();

				sens =this.getPositionnement().get(i).getOrientation().getOrientation();

				choixValide = super.definePosition(choixX,choixY, super.getPositionnement().get(i).getBateau(), Max, sens);
			}
		}
	}

}