package trafficExample;

public class TrafficDriver {
	public static void main(String[] args){
		Intersection myIntersection = new Intersection();
		myIntersection.printHeader();
		myIntersection.print();
		myIntersection.GenerateTraffic(true);
		myIntersection.runAlgorithm(true);
		while(true){
			myIntersection.print();
		}
		
		
	}
}
