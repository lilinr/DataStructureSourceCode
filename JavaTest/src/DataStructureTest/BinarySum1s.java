package DataStructureTest;

/**
 * ͳ�����������Ʊ�ʾ�� 1�ĸ���
 * 
 * @author raolilin-2013.5.11
 * 
 */
public class BinarySum1s {
	/**
	 * 1-����n��Ӧ�Ķ���������1�ĸ���
	 * 
	 * @param n
	 * @return
	 */
	public static int getSum1s(int n) {
		if (n > 0) {
			int count = 0;
			int quotient = n;// ��
			int remainder = 0;// ����
			while (quotient != 0) {
				remainder = quotient % 2;
				if (remainder == 1) {
					count++;
				}
				quotient = quotient / 2;
			}
			return count;
		} else {
			System.out.println("nӦ�ô���0");
			return 0;
		}
	}

	/**
	 * 2-�Ľ���
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
			System.out.println("nӦ�ô���0");
			return 0;
		}
	}

	/**
	 * 3-�Ľ���2������˼��
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
			System.out.println("nӦ�ô���0");
			return 0;
		}
	}

	public static void main(String[] args) {
		int n = 1234;
		System.out.println(n + "�Ķ�����" + Integer.toBinaryString(n) + "��"
				+ getSum1s(n) + "��1");
		System.out.println(n + "�Ķ�����" + Integer.toBinaryString(n) + "��"
				+ getSum1s2(n) + "��1");
		System.out.println(n + "�Ķ�����" + Integer.toBinaryString(n) + "��"
				+ getSum1s3(n) + "��1");
	}

}
