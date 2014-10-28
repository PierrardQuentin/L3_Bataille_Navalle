public class Orientation {
	private String orientation;
	
	public Orientation(){}
	
	public Orientation(String orientation){
		this.orientation = orientation;
	}
	
	public String getOrientation(){
		return(orientation);
	}
	
	public void setOrientation(){
		int choix = (int)( Math.random()*( 3 - 0 + 1 ) ) + 0;
		switch(choix){
		case 0: this.orientation="N";
		break;
		case 1: this.orientation="S";
		break;
		case 2: this.orientation="E";
		break;
		case 3: this.orientation="W";
		break;
		}
	}
}