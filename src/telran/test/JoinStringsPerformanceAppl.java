package telran.test;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.stream.IntStream;
import telran.performance.JoinStringPerformanceTest;
import telran.text.JoinStrings;

public class JoinStringsPerformanceAppl {
	private static final int N_STRINGS = 1000;
	private static final int N_RUNS = 1000;
	private static final String[] bigArray;
	private static final String BASE_PACKAGE = "telran.text.";

	static {
		bigArray = new String[N_STRINGS];
		Arrays.fill(bigArray, "Hello");
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage <name of class as an argument>");
		} else {
			IntStream.range(0, args.length).forEach(s -> {
				try {
					Class<JoinStrings> classJS = (Class<JoinStrings>) Class.forName(BASE_PACKAGE + args[s]);
					Constructor<JoinStrings> constructor = classJS.getConstructor();
					JoinStrings instance = constructor.newInstance();
					JoinStringPerformanceTest test = new JoinStringPerformanceTest(getTestName(args[s]), N_RUNS,
							bigArray, instance);
					test.run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
	}

	private static String getTestName(String className) {
		return String.format("%s; Number of the strings is %d", className, N_STRINGS);
	}
}
