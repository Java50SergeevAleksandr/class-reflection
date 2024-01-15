package telran.reflect;

import java.lang.reflect.Constructor;

public class SportsmanAppl {

	private static final String BASE_PACKAGE = "telran.reflect.";

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			System.out.println("Usage <name of class as an argument>");
		} else {
			Class<Sportsman> clazz = (Class<Sportsman>) Class.forName(BASE_PACKAGE + args[0]);
			Constructor<Sportsman> constructor = args.length > 1 ? clazz.getConstructor(String.class)
					: clazz.getConstructor();
			Sportsman sportsman = args.length > 1 ? constructor.newInstance(args[1]) : constructor.newInstance();
			sportsman.action();
		}

	}

}
