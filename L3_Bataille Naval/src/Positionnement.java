
public class Positionnement {

	private Bateau bateau;
	private Position positionTete;
	private Orientation orientation;
	
	public Positionnement(){
	}
	
	public Positionnement(Bateau b){
		this.bateau = b;
		this.positionTete = new Position();
		this.orientation = new Orientation();
	}
	///// GET //////
	public Bateau getBateau(){
		return(this.bateau);
	}
	
	public Position getPositionTete(){
		return(this.positionTete);
	}
	
	public Orientation getOrientation(){
		return(this.orientation);
	}
	
	///// SET //////
	public void setBateau(Bateau bateau){
		this.bateau = bateau;
	}
	
	public void setPosition(Position pose){
		this.positionTete = pose;
	}
	
	public void setOrientation(Orientation orientation){
		this.orientation = orientation;
	}
	
}
