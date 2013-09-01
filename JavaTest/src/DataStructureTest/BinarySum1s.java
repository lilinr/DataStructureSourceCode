package DataStructureTest;

/**
 * 统计整数二进制表示中 1的个数
 * 
 * @author raolilin-2013.5.11
 * 
 */
public class BinarySum1s {
	/**
	 * 1-返回n对应的二进制数的1的个数
	 * 
	 * @param n
	 * @return
	 */
	public static int getSum1s(int n) {
		if (n > 0) {
			int count = 0;
			int quotient = n;// 商
			int remainder = 0;// 余数
			while (quotient != 0) {
				remainder = quotient % 2;
				if (remainder == 1) {
					count++;
				}
				quotient = quotient / 2;
			}
			return count;
		} else {
			System.out.println("n应该大于0");
			return 0;
		}
	}

	/**
	 * 2-改进版
	 * @param n
	 * @return
	 */
	public static int getSum1s2(int n) {
		if (n > 0) {
			int count = 0;
			while (n != 0) {
				count++;
				n = n & (n - 1);
			}
			return count;
		} else {
			System.out.println("n应该大于0");
			return 0;
		}
	}

	/**
	 * 3-改进版2，分治思想
	 * @param n
	 * @return
	 */
	public static int getSum1s3(int n) {
		if (n > 0) {
			n = (n & 0x55555555) + ((n >> 1) & 0x55555555);
			n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
			n = (n & 0x0f0f0f0f) + ((n >> 4) & 0x0f0f0f0f);
			n = (n & 0x00ff00ff) + ((n >> 8) & 0x00ff00ff);
			n = (n & 0x0000ffff) + ((n >> 16) & 0x0000ffff);
			return n;
		} else {
			System.out.println("n应该大于0");
			return 0;
		}
	}

	public static void main(String[] args) {
		int n = 1234;
		System.out.println(n + "的二进制" + Integer.toBinaryString(n) + "有"
				+ getSum1s(n) + "个1");
		System.out.println(n + "的二进制" + Integer.toBinaryString(n) + "有"
				+ getSum1s2(n) + "个1");
		System.out.println(n + "的二进制" + Integer.toBinaryString(n) + "有"
				+ getSum1s3(n) + "个1");
	}

}
