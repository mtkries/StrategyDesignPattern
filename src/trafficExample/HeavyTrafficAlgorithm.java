package trafficExample;

public class HeavyTrafficAlgorithm implements TrafficAlgorithm {
	final String algoName = "Heavy Traffic Algorithm";
	final int timing = 900;
	@Override
	public int returnTraffic() {
		return this.timing;
	}

	@Override
	public String getAlgoName() {
		// TODO Auto-generated method stub
		return this.algoName;
	}

}
