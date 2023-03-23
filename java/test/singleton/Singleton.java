package test.singleton;

//懒汉线程不安全
public class Singleton {

	private static Singleton instance;

	private Singleton() {

	}

	public static Singleton getInstance() {
		if (instance == null)
			instance = new Singleton();
		return instance;
	}

}

// 懒汉线程安全
class Singleton_2 {

	private static Singleton_2 instance;

	private Singleton_2() {

	}

	public static synchronized Singleton_2 getInstance() {
		if (instance == null)
			instance = new Singleton_2();
		return instance;
	}

}

// 饿汉
class Singleton_3 {

	private static Singleton_3 instance = new Singleton_3();

	private Singleton_3() {
	}

	public static Singleton_3 getInstance() {
		return instance;
	}
}

// 饿汉变种
class Singleton_4 {

	private static Singleton_4 instance = null;
	static {
		instance = new Singleton_4();
	}

	private Singleton_4() {
	}

	public Singleton_4 getInstance() {
		return instance;
	}
}

// 静态内部类
class Singleton_5 {
	private static class Instance {
		private static final Singleton_5 INSTANCE = new Singleton_5();
	}

	private Singleton_5() {
	}

	public static Singleton_5 getInstance() {
		return Instance.INSTANCE;
	}
}

// 枚举
enum Singleton_6 {
	INSTANSE;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

// 双重校验锁
class Singleton_7 {
	private volatile static Singleton_7 instance;

	private Singleton_7() {
	}

	public Singleton_7 getInstance() {
		if (instance == null) {
			synchronized (Singleton_7.class) {
				if (instance == null) {
					instance = new Singleton_7();
				}
			}
		}
		return instance;
	}
}
