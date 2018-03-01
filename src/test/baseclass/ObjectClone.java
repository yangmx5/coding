package test.baseclass;

import java.util.Map;

public class ObjectClone implements Cloneable{

	private int i;
	
	
	
	public int getI() {
		return i;
	}


	public void setI(int i) {
		this.i = i;
	}

	
	

	@Override
	public String toString() {
		return "ObjectClone [i=" + i + "]";
	}


	@Override
	public Object clone(){
		// TODO Auto-generated method stub
		try{
		return super.clone();
		}catch(CloneNotSupportedException err){
			System.out.println("err");
			return null;
		}
		
	}
	
	
	public static void main(String[] args) {
		
		ObjectClone o1 =new ObjectClone();
		o1.i = 1;
		ObjectClone o2 = (ObjectClone) o1.clone();
		o2.i = 2;
		ObjectClone o3 = o1;
		o3.i = 3;
		
		String s = "123";
		
		
		System.out.println(s.hashCode());
		System.out.println("123".hashCode());
		
		
		System.out.println(o2.hashCode());
		System.out.println(o1.hashCode());
		
	}
	
}
