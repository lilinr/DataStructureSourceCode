package DataStructure;

public class SubClass extends BaseClass {
	public String book = "book";
	public void sub() {
		System.out.println("SubClass.sub()");
	}
	public void test() {
		System.out.println("SubClass.test()");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseClass bc = new BaseClass();
//		bc.base();
//		bc.test();
//		System.out.println(bc.book);
//		SubClass sc = new SubClass();
//		sc.base();
//		sc.test();
//		sc.sub();
//		System.out.println(sc.book);
//		BaseClass bs = new SubClass();
//		bs.test();
//		System.out.println(bs.book);
//		SubClass sc2 = (SubClass) bs;
//		sc2.sub();
		SubClass sc3 = (SubClass) bc;
		sc3.sub();
	}

}

