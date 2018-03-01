package test;

import java.util.Arrays;

class Person {
	
	public static int id = 0;
	
	Person() {
		System.out.println("create person");
	}

	public static String getName() {
		return "Person";
	}
}
//super()函数必须放在子类构造函数的第一行
class Teacher extends Person {
	public int id = 1;
	
	Teacher() {
//		super();
		System.out.println("create teacher");

	}

	public static String getName() {
		return "Teacher";
	}
}

public class TestInherit {
	public static void main(String[] args) {

		
		// 测试父类子类构造函数关系和重载关系
		Person person = new Person();
		Person teacher = new Teacher();
//		System.out.println(person.getName());
//		System.out.println(teacher.getName());

		// 测试数组中元素是否可以为null ,(引用类型可以为空，基本类型不可以)
		Person[] a = { person, teacher };// new Person[2];
		a[1] = null;
//		System.out.println(Arrays.toString(a));
//
//		String test = "A";
//
//		System.out.println(test.length());
//		
		System.out.println(teacher.id);

	}
}