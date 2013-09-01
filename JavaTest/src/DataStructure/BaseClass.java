package DataStructure;

public class BaseClass {
	
	public int book = 6;
	{
		System.out.println(book+ "bbb");
	}
	
	public BaseClass() {
		System.out.println("BaseClass");
	}
	public BaseClass(int book) {
		this.book = book;
		System.out.println("BaseClass(int book)");
	}
	
	public void base() {
		System.out.println("BaseClass.base()");
	}
	
	public void test() {
		System.out.println("BaseClass.test()");
	}
}
