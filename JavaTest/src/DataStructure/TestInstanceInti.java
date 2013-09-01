package DataStructure;

public class TestInstanceInti extends BaseClass {
	
	{
		a = 6;
	}
	int a = 9;
	{
		System.out.println(a+ "aaa");
	}
	
	public TestInstanceInti() {
//		super(2);
		this.a = 19;
		System.out.println(a+ "sss");
	}
	public TestInstanceInti(int a) {
		super(a);
		this.a = a;
		System.out.println(a+ "ccc");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new TestInstanceInti().a);
	}

}
