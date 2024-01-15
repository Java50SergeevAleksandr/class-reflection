package telran.reflect;

import java.lang.reflect.Method;

public class TestAppl {

	public static void main(String[] args) throws Exception {
		if (args.length < 2) {
			System.out.println("Usage: <first argument: test method name, second argument: integer value");
		} else {
			int value = Integer.parseInt(args[1]);
			Method method = Test.class.getDeclaredMethod(args[0], int.class);
			Test test = new Test();
			method.setAccessible(true);
			method.invoke(test, value);
		}

	}

}
