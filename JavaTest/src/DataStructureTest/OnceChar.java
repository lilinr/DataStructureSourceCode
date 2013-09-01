package DataStructureTest;
/**
 * 在一个字符串中找到第一个只出现一次的字符。如输入 abaccdeff，则输出 b。
 * @author raolilin-2013.5.3
 *
 */
public class OnceChar {
	/**
	 * 1-在一个字符串中找到第一个只出现一次的字符的下标号
	 * @param str
	 * @return
	 */
	private static int getOnceCharIndex(String str) {
		if(str != null && !str.trim().equals("")) {
			char[] array = str.toCharArray();
			int i;
			int j;
			for(i=0; i<array.length; i++) {
				for(j=0; j<array.length; j++) {
					if(i != j && array[i] == array[j]) {
						break;
					}
				}
				if(j == array.length) {
					break;
				}
			}
			if(i < array.length) {
				return i;
			} else {
				return -1;
			}
		} else {
			System.out.println("字符串为空！");
			return -1;
		}
	}
	/**
	 * 2-在一个字符串中找到第一个只出现一次的字符
	 * @param str
	 * @return
	 */
	public static char getOnceChar(String str) {
		int index = getOnceCharIndex(str);
		if(index != -1) {
			return str.charAt(index);
		} else {
			System.out.println("没有满足的字符！");
			return '0';//假设字符'0'是报错
		}
	}
	/**
	 * 3-在一个字符串中找到第一个只出现一次的字符
	 * @param str
	 * @return
	 */
	public static char getOnceChar2(String str) {
		if(str != null && !str.trim().equals("")) {
			int[] count = new int[256];
			for(int i=0; i<count.length; i++) {
				count[i] = 0;
			}
			char[] array = str.toCharArray();
			for(int i=0; i<array.length; i++) {
				count[array[i]]++;
			}
			int i;
			for(i=0; i<count.length; i++) {
				if(count[i] == 1) {
					break;
				}
			}
			if(i < count.length) {
				return (char)i;
			} else {
				System.out.println("没有满足的字符！");
				return '0';//假设字符'0'是报错
			}
			
		} else {
			System.out.println("字符串为空！");
			return '0';//假设字符'0'是报错
		}
	}
	
	public static void main(String[] args) {
		String str = "abbbcccddefg";
		System.out.println(str + "的第一个只出现一次的字符为：" + getOnceChar(str));
		System.out.println(str + "的第一个只出现一次的字符为：" + getOnceChar2(str));
	}

}
