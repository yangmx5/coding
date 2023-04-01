package test.singleton;

public class EnumSingleton {

	//枚举的单例模式
	
	public enum Singleton{
		INSTANSE;
		private String name;
		
		public String getName(){
			return name;
		}
		
		public void setName(String name){
			this.name = name;
		}	
	}
	
	public static void main(String[] args) {
		Singleton test =Singleton.INSTANSE;
		test.setName("hello");
		System.out.println(test.getName());
		
		Singleton test2 = Singleton.INSTANSE;
		System.out.println(test2.getName());
		
	}
	
}
