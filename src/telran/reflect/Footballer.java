package telran.reflect;

public class Footballer implements Sportsman {
	private static final String DEFAULT_TEAM = "Real Madrid";
	String team;

	Footballer(String team) {
		this.team = team;
	}

	Footballer() {
		this(DEFAULT_TEAM);
	}

	@Override
	public void action() {
		System.out.println("I'm playing football");

	}

}
