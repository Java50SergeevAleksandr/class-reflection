package telran.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import telran.performance.JoinStringPerformanceTest;
import telran.text.JoinStrings;
import telran.text.JoinStringsOnBuilder;
import telran.text.JoinStringsOnStandard;
import telran.text.JoinStringsOnString;

public class JoinStringsPerformanceAppl {
	private static final int N_STRINGS = 1000;
	private static final int N_RUNS = 1000;
	private static final String[] bigArray;
	private static final String BASE_PACKAGE = "telran.test.";

	static {
		bigArray = new String[N_STRINGS];
		Arrays.fill(bigArray, "Hello");
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			System.out.println("Usage <name of class as an argument>");
		} else {
			Class<JoinStrings> classJS = (Class<JoinStrings>) Class.forName(BASE_PACKAGE + args[0]);
			Constructor<JoinStrings> constructor = classJS.getConstructor();
			JoinStrings instance = constructor.newInstance();
			JoinStringPerformanceTest test = new JoinStringPerformanceTest(getTestName(args[0]), N_RUNS, bigArray,
					instance);
			test.run();
		}
	}

	private static String getTestName(String className) {
		return String.format("%s; Number of the strings is %d", className, N_STRINGS);
	}
}
