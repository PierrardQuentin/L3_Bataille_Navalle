public class Humain extends Joueur{

	public Humain(String nom){
		super(nom);
	}

	public void typeBoat(int pa, int smn, int cf, int z){
		while((pa+smn+cf+z) != 0){
			if(pa != 0){
				Porte_Avion porte = new Porte_Avion();
				Positionnement pos = new Positionnement(porte);
				super.setPositionnement(pos);
				pa--;
			}else if(smn != 0){
				Sous_Marin marin = new Sous_Marin();
				Positionnement pos = new Positionnement(marin);
				super.setPositionnement(pos);
				smn--;
			}else if(cf != 0){
				Cuirasse furtif = new Cuirasse();
				Positionnement pos = new Positionnement(furtif);
				super.setPositionnement(pos);
				cf--;
			}else if(z != 0){
				Zodiac caidoz = new Zodiac();
				Positionnement pos = new Positionnement(caidoz);
				super.setPositionnement(pos);
				z--;
			}
		}
	}
	
	
}
