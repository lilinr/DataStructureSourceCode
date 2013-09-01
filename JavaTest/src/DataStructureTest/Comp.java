package DataStructureTest;

import java.util.*;

public class Comp {
	static void getAllComp(int n, int m) {
		String pre = m + "=";
		int theMax = (1 + n) * n / 2;
		if (theMax < m) {
			System.out.println("不存在该数！");
		} else {
			for (int i = 1; i <= m / 2; i++) {
				// 从 1开始计数，打印出两个数的组合，并且两数不相等
				if (i != m - i && n >= m - i) {
					System.out.println(pre + i + "+" + (m - i));
				}
				// 调用递归，继续求得大于 2个数的组合
				getTheResult(m - i, pre + i, i, n);

			}
			// getTheResult(m, pre, 0, n);
		}
	}

	// 调用递归，继续求得大于 2 个数的组合,j为组合中已用过的数，所以取大于该数的。
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

	// 给定一个数t，以及n个整数，在这n个数中找到加和为t的所有组合，
	// 例如t = 4, n = 6, 这6个数为[4, 3, 2, 2, 1, 1],
	// 这样输出就有4个不同的组合它们的加和为4: 4, 3+1, 2+2, and 2+1+1.
	// 请设计一个高效算法实现这个需求。
	// 其中array 是已排好序的
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

				// 找到一个数的组合
				if (array[i] == t) {
					System.out.println(print + array[i]);
				}
				// 找到两个数的组合
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

	// 输入一个正数 n，输出所有和为 n连续正数序列
	// 例如输入 15，由于 1+2+3+4+5=4+5+6=7+8=15，所以输出3 个连续序列 1-5、4-6和 7-8。
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
			System.out.println("m应该大于0");
		}
	}

	// 参考方法
	public static void printResult2(int m) {
		if (m > 0) {
			int start = 1, end = 2, mid = m / 2;
			int sum = (start + end);
			while (start <= mid) {
				// 检索，若是 sum大了，则 start 右移，若是小了则 end 右移
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
			System.out.println("m应该大于0");
		}
	}

}