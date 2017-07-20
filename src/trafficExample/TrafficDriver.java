package trafficExample;

public class TrafficDriver {
	public static void main(String[] args){
		Intersection myIntersection = new Intersection();
		myIntersection.printHeader();
		myIntersection.print();
		myIntersection.GenerateTraffic(true);
		myIntersection.runAlgorithm(true);
		while(true){
			//myIntersection.print();
			if(myIntersection.totalNumberOfCars() > 15 && lightTrafficAlgorithmEnabled(myIntersection)){
				myIntersection.setAlgorithm(new HeavyTrafficAlgorithm());
			}
			if(myIntersection.totalNumberOfCars() <5 && !lightTrafficAlgorithmEnabled(myIntersection) ){
				myIntersection.setAlgorithm(new LightTrafficAlgorithm());
			}
		}
		
		
	}
	public static boolean lightTrafficAlgorithmEnabled(Intersection myIntersection){
		return myIntersection.getAlgo().getAlgoName().equals("Light Traffic Algorithm");
}
}
