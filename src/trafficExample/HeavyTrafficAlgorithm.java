package trafficExample;

public class HeavyTrafficAlgorithm implements TrafficAlgorithm {
	final String algoName = "Heavy Traffic Algorithm";
	final int timing = 1400;
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
		return 5;
	}

}
