package trafficExample;

public class Intersection {

	
	boolean northLight;
	boolean southLight;
	boolean eastLight;
	boolean westLight;
	int numCarsNorth;
	int numCarsSouth;
	int numCarsEast;
	int numCarsWest;
	public Intersection(){
		westLight = false;;
		eastLight= false;
		northLight = false;
		southLight = false;
		numCarsNorth =0;
		numCarsSouth =0;
		numCarsEast=0;
		numCarsWest=0;
	}
	public void increaseNorth(int n){
		this.numCarsNorth = numCarsNorth + n;
	}
	public void increaseSouth(int n){
		this.numCarsSouth = numCarsSouth + n;
	}
	public void increaseEast(int n){
		this.numCarsEast = numCarsEast + n;
	}
	public void increaseWest(int n){
		this.numCarsWest = numCarsWest + n;
	}
	
	
	
}
