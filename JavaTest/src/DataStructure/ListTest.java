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
		// sValue = sValue - 2;//�������intתshort
		// sValue2 -= 2;

		// int a = 5;
		// int b = 4;
		// int c = a++ - --b * ++a / b-- >> 2 % a--;
		// System.out.println(a);
		// System.out.println(b);
		// System.out.println(c);
		// System.out.println("�й�abc".charAt(1 ));
		// char a = '��';
		// System.out.println(a);

//		String s = "a��b����c�����a��1��b����2����ôc��3";
//		try {
//			System.out.println(bSubstring(s, 9));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String a = "aaa";
//		String b = "bbb";
//		System.out.println("main������:a=" + a + ",b=" + b);
//		swap(a, b);
//		System.out.println("main����ִ��swap֮��:a=" + a + ",b=" + b);
//		System.out.println("����aaa".length());
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
	
	//����ֵ
	public static void swap(String a, String b) {
		String temp = a;
		a = b;
		b = temp;
		System.out.println("Swap������:a=" + a + ",b=" + b);
		a = "aaa2222";
	}
	
	//�����������ɵ��ֽ�������ǰ�����ֽ��Ǳ�־λ��
	//bytes[0] = -2��bytes[1] = -1��
	//��ˣ�Ҫ�ӵ������ֽڿ�ʼɨ�裬
	//����һ��Ӣ�Ļ������ַ���UCS2����ĵڶ����ֽ�����Ӧ��ASCII��
	//��һ���ֽ���0����a��UCS2������0  97�������������ֽڶ���Ϊ0��
	//��ˣ���������UCS2������������������ʵ�ʵ��ֽ������÷�����ʵ�ִ������£�
	public static String bSubstring(String s, int length) throws Exception {
		

		byte[] bytes = s.getBytes("UTF-8");
		int n = 0; // ��ʾ��ǰ���ֽ���
		int i = 2; // Ҫ��ȡ���ֽ������ӵ�3���ֽڿ�ʼ
		for (; i < bytes.length && n < length; i++) {
			// ����λ�ã���3��5��7�ȣ�ΪUCS2�����������ֽڵĵڶ����ֽ�
			if (i % 2 == 1) {
				n++; // ��UCS2�ڶ����ֽ�ʱn��1
			} else {
				// ��UCS2����ĵ�һ���ֽڲ�����0ʱ����UCS2�ַ�Ϊ���֣�һ�������������ֽ�
				if (bytes[i] != 0) {
					n++;
				}
			}
		}
//		i = length + 2;
		// ���iΪ����ʱ�������ż��
		if (i % 2 == 1)

		{
			// ��UCS2�ַ��Ǻ���ʱ��ȥ�������һ��ĺ���
			if (bytes[i - 1] != 0)
				i = i - 1;
			// ��UCS2�ַ�����ĸ�����֣��������ַ�
			else
				i = i + 1;
		}

		return new String(bytes, 0, i, "UTF-8");
	}
}
