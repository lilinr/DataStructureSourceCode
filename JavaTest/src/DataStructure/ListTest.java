package DataStructure;

import java.util.LinkedList;

public class ListTest {
	public static void main(String[] args) {
		// LinkedList linkedList = new LinkedList();
		// String t = null;
		// int tLength = t.length();

		// char[] charList = new char[0];
		// System.out.println(charList.length);

		// char a = 'a';
		// String ab = a + "b";
		// System.out.println(ab);

		// short sValue = 5;
		// short sValue2 = 5;
		// sValue = sValue - 2;//编译错误，int转short
		// sValue2 -= 2;

		// int a = 5;
		// int b = 4;
		// int c = a++ - --b * ++a / b-- >> 2 % a--;
		// System.out.println(a);
		// System.out.println(b);
		// System.out.println(c);
		// System.out.println("中国abc".charAt(1 ));
		// char a = '过';
		// System.out.println(a);

//		String s = "a加b等于c，如果a等1、b等于2，那么c等3";
//		try {
//			System.out.println(bSubstring(s, 9));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String a = "aaa";
//		String b = "bbb";
//		System.out.println("main方法里:a=" + a + ",b=" + b);
//		swap(a, b);
//		System.out.println("main方法执行swap之后:a=" + a + ",b=" + b);
//		System.out.println("方法aaa".length());
		int x = 10;
//		int y = 10;
//		int z;
//		z = x++;
//		x = x++;
//		y = ++y;
		System.out.println("++x=" + ++x + ",x=" + x);
//		System.out.println("y=" + y);
//		System.out.println("z=" + z);

	}
	
	//交换值
	public static void swap(String a, String b) {
		String temp = a;
		a = b;
		b = temp;
		System.out.println("Swap方法里:a=" + a + ",b=" + b);
		a = "aaa2222";
	}
	
	//由于上面生成的字节数组中前两个字节是标志位，
	//bytes[0] = -2，bytes[1] = -1，
	//因此，要从第三个字节开始扫描，
	//对于一个英文或数字字符，UCS2编码的第二个字节是相应的ASCII，
	//第一个字节是0，如a的UCS2编码是0  97，而汉字两个字节都不为0，
	//因此，可以利于UCS2编码的这个规则来计算实际的字节数，该方法的实现代码如下：
	public static String bSubstring(String s, int length) throws Exception {
		

		byte[] bytes = s.getBytes("UTF-8");
		int n = 0; // 表示当前的字节数
		int i = 2; // 要截取的字节数，从第3个字节开始
		for (; i < bytes.length && n < length; i++) {
			// 奇数位置，如3、5、7等，为UCS2编码中两个字节的第二个字节
			if (i % 2 == 1) {
				n++; // 在UCS2第二个字节时n加1
			} else {
				// 当UCS2编码的第一个字节不等于0时，该UCS2字符为汉字，一个汉字算两个字节
				if (bytes[i] != 0) {
					n++;
				}
			}
		}
//		i = length + 2;
		// 如果i为奇数时，处理成偶数
		if (i % 2 == 1)

		{
			// 该UCS2字符是汉字时，去掉这个截一半的汉字
			if (bytes[i - 1] != 0)
				i = i - 1;
			// 该UCS2字符是字母或数字，则保留该字符
			else
				i = i + 1;
		}

		return new String(bytes, 0, i, "UTF-8");
	}
}
