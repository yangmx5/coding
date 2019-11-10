package test.singleton;


//volatile 和 synchronized 双重锁校验
public class DoubleCheckSingleton {

	private volatile static DoubleCheckSingleton singleton;

	private DoubleCheckSingleton() {
	}

	public static DoubleCheckSingleton getSingleton() {

		if (singleton == null) {
			synchronized (DoubleCheckSingleton.class) {
				if (singleton == null) {
					singleton = new DoubleCheckSingleton();
				}
			}
		}
		return singleton;
	}

}
