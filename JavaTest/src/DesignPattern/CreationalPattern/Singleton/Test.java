package DesignPattern.CreationalPattern.Singleton;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoodSingleton instance1 = GoodSingleton.getInstance();
//		GoodSingleton instance2 = GoodSingleton.getInstance();
//		System.out.println(instance1 == instance2);
		System.out.println(GoodSingleton.data);
	}
	
	private void test() {
		
	}
	
	public void test1() {
		test();
	}
}

interface In1 {
	void f1();
}

interface In2 {
	void f2();
}

interface In3 extends In1, In2 {
	void f3();
}