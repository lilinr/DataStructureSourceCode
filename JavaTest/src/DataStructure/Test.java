package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {
	final int age;
	{
		age = 6;
		System.out.println(age);
		// age = 7;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// for (SeasonEnum s : SeasonEnum.values()) {
		// // System.out.println(s.name());
		// // System.out.println(s.ordinal());
		// System.out.println(Enum.valueOf(SeasonEnum.class, "AUTUMN"));
		// }

		// LinkedList books = new LinkedList();
		// books.offer("Struts");
		// books.push("轻量级");
		// books.offerFirst("ROR");
		// for(int i=0; i<books.size(); i++) {
		// System.out.println(books.get(i));
		// }
		// System.out.println("*******");
		// System.out.println(books.peekFirst());
		// System.out.println("*******");
		// System.out.println(books.peekLast());
		// System.out.println("*******");
		// System.out.println(books.pop());
		// System.out.println("*******");
		// System.out.println(books);
		// System.out.println("*******");
		// System.out.println(books.pollLast());
		// System.out.println("*******");
		// System.out.println(books);

		// String test1 = "java";
		// String test2 = "java";
		// String test3 = new String("java");
		// String test4 = new String("java");
		// System.out.println(test1 == test2);
		// System.out.println(test3 == test4);

		//		
		// int i = 0;
		// // i = ++i;
		// i = i++;
		// int j = i+1;
		// System.out.println(i);
		// System.out.println(j);

		// System.out.println("(7/4)=" + (7/4));
		// System.out.println("(7/(-4))=" + (7/(-4)));
		// System.out.println("(7%4)=" + (7%4));
		// System.out.println("(7%(-4))=" + (7%(-4)));
		// System.out.println("((-7)/4)=" + ((-7)/4));
		// System.out.println("((-7)%4)=" + ((-7)%4));
		// System.out.println("((-7)/(unsigned)4)=" + ((-7)/(unsigned)4));

//		System.out.println("(3)>>1=" + ((3) >> 1));
//		System.out.println("(3)>>>1=" + ((3) >>> 1));
//		System.out.println("(3)>>0=" + ((3) >> 0));
//		System.out.println("(3)>>>0=" + ((3) >>> 0));
//		System.out.println("(3)>>32=" + ((3) >> 32));
//		System.out.println("(3)>>>32=" + ((3) >>> 32));
//
//		System.out.println("(-3)>>1=" + ((-3) >> 1));
//		System.out.println("(-3)>>>1=" + ((-3) >>> 1));
//		System.out.println("(-3)>>0=" + ((-3) >> 0));
//		System.out.println("(-3)>>>0=" + ((-3) >>> 0));
//		System.out.println("(-3)>>32=" + ((-3) >> 32));
//		System.out.println("(-3)>>>32=" + ((-3) >>> 32));
//
//		System.out.println("(-3)>>31=" + ((-3) >> 31));
//		int i = -3;
//		System.out.println("(i)>>31=" + ((i) >> 31));
//		System.out.println("i=" + i);
		
//		Vector v = new Vector();
//		v.add(null);
//		ArrayList arrayList = new ArrayList();
//		arrayList.add(null);
		
//		System.out.println("(5.0==5)=" + (5.0==5));
//		System.out.println("(new Integer(2)==new Integer(2))=" + (new Integer(2)==new Integer(2)));
//		Integer ina = 2;
//		Integer inb = 2;
//		Integer ina2 = 128;
//		Integer inb2 = 128;
//		System.out.println("(ina==inb)=" + (ina==inb));
//		System.out.println("(ina2==inb2)=" + (ina2==inb2));
//		String test = inb2 + "";
//		System.out.println(test);
		
//		Scanner sc = new Scanner(System.in);
////		sc.useDelimiter("\n");
//		while(sc.hasNext()) {
//			String input = sc.next();
//			if(input.equals("end")) {
//				break;
//			} else {
//				System.out.println("键盘输入的内容是：" + input);
//			}
//		}
//		System.out.println("结束");
		
//		Scanner sc = new Scanner(System.in);
////		sc.useDelimiter("\n");
//		while(sc.hasNext()) {
//			System.out.println("键盘输入的内容是：" + sc.next());
//		}
//		System.out.println("结束");
		
//		Scanner sc = new Scanner(System.in);
//		while(sc.hasNextLong()) {
//			System.out.println("键盘输入的Long内容是：" + sc.nextLong());
//		}
//		System.out.println("不是Long");
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String buffer = null;
//		try {
//			while((buffer = br.readLine()) != null && !buffer.equals("end")) {
//				System.out.println("键盘输入的" + buffer);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		
//		System.out.println("结束");
		
//		System.out.println("abababa".replace('a', 'e'));
		
//		System.out.println("Math.round(-2.4)=" + Math.round(-2.4));
//		System.out.println("Math.round(2.4)=" + Math.round(2.4));
//		System.out.println("Math.round(-2.8)=" + Math.round(-2.8));
//		System.out.println("Math.round(2.8)=" + Math.round(2.8));
		
//		System.out.println(Math.nextAfter(1.2, 2.3));
		
//		Random rand = new Random();
//		byte[] buffer = new byte[16];
//		rand.nextBytes(buffer);
//		System.out.println(Arrays.toString(buffer));
		
//		Calendar cal = Calendar.getInstance();
//		cal.set(2012, 1, 31);
//		cal.set(Calendar.MONTH, 8);
//		System.out.println(cal.getTime());
		
//		System.out.println("test=" + new Test().test().age);
//		main(args);
		
		
		SubClass[] subArray = new SubClass[5];
//		subArray[1].book = "e";
	}

	public void exceptionTest() throws Exception {
		throw new Exception("exceptionTest");
	}
	
	@SuppressWarnings("finally")
	public TestBean test() {
//		int test = 0;
		TestBean tb = new TestBean();
		try {
			exceptionTest();
//			test = 1;
			tb.age = 1;
//			return test;
			return tb;
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
//			return test;
			return tb;
		} finally {
//			test = 2;
//			System.out.println("finally.test=" + test);
//			return test;
			tb.age = 2;
			System.out.println("finally.test=" + tb.age);
//			return tb;
		}
	}
	
	class TestBean {
		public int age = 0;
	}
}
