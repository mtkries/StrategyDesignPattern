package trafficExample;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Intersection {
	Intersection i = this;
	Timer generationTimer;
	Timer algorithmTimer;
	Thread algoThread;
	boolean northLight;
	boolean southLight;
	boolean eastLight;
	enum greenLight{North,South,East,West};
	greenLight current;
	boolean westLight;
	int[] traffic = new int[4];
	double[] lightTiming = new double[4];
	TrafficAlgorithm algorithm;
	public Intersection(){
		westLight = false;;
		eastLight= false;
		northLight = false;
		southLight = false;
		traffic[0] =0;
		traffic[1] =0;
		traffic[2] =0;
		traffic[3] =0;
		this.current = greenLight.North;
		lightTiming[0] = .5; //North
		lightTiming[1] = .5; //South
		lightTiming[2] = .5; //East
		lightTiming[3] = .5; //West
		this.algorithm = new LightTrafficAlgorithm();
	}
	public TrafficAlgorithm getAlgo(){
		return this.algorithm;
	}
	public void increaseNorth(int n){
		lightTiming[0] = traffic[0] + n;
	}
	public void increaseSouth(int n){
		traffic[1] = traffic[1] + n;
	}
	public void increaseEast(int n){
		traffic[2] = traffic[2] + n;
	}
	public void increaseWest(int n){
		traffic[3] = traffic[3] + n;
	}
	public void setLightTiming(double[] timing){
		this.lightTiming = timing;
	}
	
	public void setAlgorithm(final TrafficAlgorithm algo){
		this.algorithm = algo;
		algorithmTimer.cancel();
		algorithmTimer = null;
		runAlgorithm(true);
	}
	public int totalNumberOfCars(){
		int returnVal =0;
		for(int i=0; i < traffic.length; i++){
			returnVal+=traffic[i];
		}
			
		return returnVal;
	}
	public void printHeader(){
		
		System.out.printf("%1$-2s %2$-3s %3$-3s %4$-3s %5$-13s %6$-24s","N","|"+ "S","|"+ "E","|"+ "W","|"+ "Green Light","|"+ "Algorithm Used"+"\n");
	}
	public void print(){
		System.out.printf("%1$-2s %2$-3s %3$-3s %4$-3s %5$-13s %6$-24s",traffic[0],"|"+ traffic[1],"|"+ traffic[2],"|"+ traffic[3],"|"+ current,"|"+ this.algorithm.getAlgoName()+"\n");
	}
	public void GenerateTraffic(boolean b){
		if(b){
			generationTimer = new Timer();
			generationTimer.schedule(new IncrementTraffic(),0,500);
			//System.out.println("timer");
			this.print();
		}
		else{
			generationTimer = null;
		}
	}
	public void runAlgorithm(boolean b){
		if(b){
			algorithmTimer = new Timer();
			algorithmTimer.schedule(new MoveTraffic(),0,this.algorithm.returnTraffic());
		
		}
		else{
			algorithmTimer = null;
		}
	}
	
	public int randNum(int max, int min){
		Random rand = new Random();

		return rand.nextInt(max) + min;
	}
	class MoveTraffic extends TimerTask {
	    public void run() {
	    	switch(current){
	    	case North :
	    		if(traffic[0]-algorithm.getReduction()>0){
	    			traffic[0]-=algorithm.getReduction();
	    			i.print();
	    		}
	    		else{
	    			traffic[0]=0;
	    			i.print();
	    		}
	    		
	    		current = greenLight.South;
	    		break;
	    	case South :
	    		if(traffic[1]-algorithm.getReduction()>0){
	    			traffic[1]-=algorithm.getReduction();
	    			i.print();
	    		}
	    		else{
	    			traffic[1]=0;
	    			i.print();
	    		}
	    		
	    		current = greenLight.East;
	    		break;
	    	case East :
	    		if(traffic[2]-algorithm.getReduction()>0){
	    			traffic[2]-=algorithm.getReduction();
	    			i.print();
	    		}
	    		else{
	    			traffic[2]=0;
	    			i.print();
	    		}
	    		
	    		current = greenLight.West;
	    		break;
	    	case West :
	    		if(traffic[3]-algorithm.getReduction()>0){
	    			traffic[3]-=algorithm.getReduction();
	    			i.print();
	    		}
	    		else{
	    			traffic[3]=0;
	    			i.print();
	    		}
	    		
	    		current = greenLight.North;
	    		break;
	    	}
	    	i.print();
	    }
	}
	class IncrementTraffic extends TimerTask {
	    public void run() {
	    	//System.out.println("test");
			int randomNumber = randNum(4,0);
			traffic[randomNumber]++; 
			i.print();
			
	    }
	}
}
