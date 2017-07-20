package trafficExample;

public class LightTrafficAlgorithm implements TrafficAlgorithm {
	final String algoName = "Light Traffic Algorithm";
	final int timing = 900;
	@Override
	public int returnTraffic() {
		return this.timing;
	}

	@Override
	public String getAlgoName() {
		return this.algoName;
	}

	@Override
	public int getReduction() {
		// TODO Auto-generated method stub
		return 1;
	}


}
