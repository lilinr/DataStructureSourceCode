package DataStructureTest;

import java.util.*;

public class Comp {
	static void getAllComp(int n, int m) {
		String pre = m + "=";
		int theMax = (1 + n) * n / 2;
		if (theMax < m) {
			System.out.println("�����ڸ�����");
		} else {
			for (int i = 1; i <= m / 2; i++) {
				// �� 1��ʼ��������ӡ������������ϣ��������������
				if (i != m - i && n >= m - i) {
					System.out.println(pre + i + "+" + (m - i));
				}
				// ���õݹ飬������ô��� 2���������
				getTheResult(m - i, pre + i, i, n);

			}
			// getTheResult(m, pre, 0, n);
		}
	}

	// ���õݹ飬������ô��� 2 ���������,jΪ��������ù�����������ȡ���ڸ����ġ�
	static void getTheResult(int m, String pre, int j, int n) {
		for (int i = j + 1; i <= m / 2; i++) {
			if (i != m - i && n >= m - i) {
				System.out.println(pre + "+" + i + "+" + (m - i));
			}
			getTheResult(m - i, pre + "+" + i, i, n);
		}
	}

	public static void main(String[] args) {
		// getAllComp(6, 10);
		// printResult(4,new int[]{1, 1, 1, 2, 2, 3, 4});
		int m = 223;
		System.out.println(m + ":(1)");
		printResult(m);
		System.out.println(m + ":(2)");
		printResult2(m);
	}

	// ����һ����t���Լ�n������������n�������ҵ��Ӻ�Ϊt��������ϣ�
	// ����t = 4, n = 6, ��6����Ϊ[4, 3, 2, 2, 1, 1],
	// �����������4����ͬ��������ǵļӺ�Ϊ4: 4, 3+1, 2+2, and 2+1+1.
	// �����һ����Ч�㷨ʵ���������
	// ����array �����ź����
	public static void getTheResult(int t, int[] array, int used, String print) {
		if (t > 0) {
			for (int i = used + 1; i < array.length; i++) {

				for (int j = i + 1; j < array.length; j++) {
					if (array[i] + array[j] == t) {
						System.out.println(print + "+" + array[i] + "+"
								+ array[j]);
						break;
					}
				}
				getTheResult(t - array[i], array, i, print + "+" + array[i]);
			}
		}
	}

	public static void printResult(int t, int[] array) {
		if (array != null && array.length != 0) {
			String print = t + "=";
			for (int i = 0; i < array.length; i++) {
				if (i > 0 && array[i] == array[i - 1]) {
					continue;
				}

				// �ҵ�һ���������
				if (array[i] == t) {
					System.out.println(print + array[i]);
				}
				// �ҵ������������
				for (int j = i + 1; j < array.length; j++) {
					if (array[i] + array[j] == t) {
						System.out.println(print + array[i] + "+" + array[j]);
						break;
					}
				}
				getTheResult(t - array[i], array, i, print + array[i]);
			}
		} else {
			System.out.println("array is null!");
		}
	}

	// ����һ������ n��������к�Ϊ n������������
	// �������� 15������ 1+2+3+4+5=4+5+6=7+8=15���������3 ���������� 1-5��4-6�� 7-8��
	public static void printResult(int m) {
		if (m > 0) {
			int i = 1;
			while (i <= m / 2) {
				int temp = i;
				for (int j = i + 1; j < m; j++) {
					temp = temp + j;
					if (temp >= m) {
						if (temp == m) {
							System.out.println(i + "-" + j);
						}
						break;
					}
				}
				i++;
			}
		} else {
			System.out.println("mӦ�ô���0");
		}
	}

	// �ο�����
	public static void printResult2(int m) {
		if (m > 0) {
			int start = 1, end = 2, mid = m / 2;
			int sum = (start + end);
			while (start <= mid) {
				// ���������� sum���ˣ��� start ���ƣ�����С���� end ����
				if (sum < m) {
					sum += ++end;//end++;sum=sum+end;
				}
				else if (sum > m) {
					sum -= start++;//sum=sum-start;start++;
				}
				else {
					System.out.println(start + "-" + end);
					sum -= start++;//sum=sum-start;start++;
				}
			}
		} else {
			System.out.println("mӦ�ô���0");
		}
	}

}