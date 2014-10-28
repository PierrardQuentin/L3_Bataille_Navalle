import java.util.ArrayList;


public class Historique {

	private ArrayList<Position> tabBoat;
	private ArrayList<Position> tabBoatTouch;
	private ArrayList<Position> tabTir;
	
	public Historique(){
		tabBoat =  new ArrayList<Position>();
		tabBoatTouch =  new ArrayList<Position>();
		tabTir =  new ArrayList<Position>();
	}
	
	///// GET //////
	public ArrayList<Position> getTabBoat(){
		return(this.tabBoat);
	}
	
	public ArrayList<Position> getTabBoatTouch(){
		return(this.tabBoatTouch);
	}
	
	public void addPositionTir(Position p){
		tabTir.add(p);
	}
	
	public void addPositionBoatTouch(Position p){
		tabBoatTouch.add(p);
	}
	
	public ArrayList<Position> getTabTir(){
		return(this.tabTir);
	}
	
	
}
