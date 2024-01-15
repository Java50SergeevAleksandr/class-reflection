package telran.reflect;

public class Runner implements Sportsman {
	private static final String DEFAULT_DISTANCE = "1200m";
	String distance;

	Runner(String distance) {
		this.distance = distance;
	}

	Runner() {
		this(DEFAULT_DISTANCE);
	}

	@Override
	public void action() {
		System.out.println("I'm runner");

	}

}
