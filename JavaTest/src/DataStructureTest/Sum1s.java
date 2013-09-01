package DataStructureTest;

/**
 * ���� 1�� N��ʮ�������� 1�ĳ��ִ���
 * 
 * @author raolilin-2013.5.11
 * 
 */
public class Sum1s {
	/**
	 * 1-���� 1��n��ʮ�������� 1�ĳ��ִ���
	 * 
	 * @param n
	 */
	public static int getSum1s(int n) {
		if (n > 1) {
			int count = 0;
			int lower = 0;
			int current = 0;
			int higher = 0;
			int factor = 1;
			while (n / factor != 0) {
				lower = n % factor;
				current = (n / factor) % 10;
				higher = n / (factor * 10);
				switch (current) {
				case 0: {
					count = count + higher * factor;
					break;
				}
				case 1: {
					count = count + higher * factor + lower + 1;
					break;
				}
				default: {
					count = count + (higher + 1) * factor;
					break;
				}
				}
				factor = factor * 10;
			}
			return count;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		int n = 12013;
		System.out.println("1��" + n + "��1������Ϊ" + getSum1s(n));
	}

}
