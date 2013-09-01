package DataStructureTest;

/**
 * 把 n 个骰子扔在地上，所有骰子朝上一面的点数之和为 S。输入 n，打印出S 的所有可能的值出现的概率。
 * 
 * @author raolilin-2013.5.14
 * 
 */
public class Dice {
	private static final int MAX = 6;

	/**
	 * 1-1-递归计算
	 * 
	 * @param start
	 * @param current
	 * @param value
	 * @param tempSum
	 * @param result
	 */
	public static void countResult(int start, int current, int value,
			int tempSum, int[] result) {
		int sum = tempSum + value;
		if (current == 1) {
			result[sum - start]++;
		} else {
			for (int i = 1; i <= MAX; i++) {
				countResult(start, current - 1, i, sum, result);
			}
		}
	}

	/**
	 * 1-2 printResult
	 * 
	 * @param n
	 */
	public static void printResult(int n) {
		int[] result = new int[5 * n + 1];

		int total = 1;
		int temp = n;
		while (temp > 0) {
			total *= MAX;
			temp--;
		}

		for (int i = 1; i <= MAX; i++) {
			countResult(n, n, i, 0, result);
		}
		int countPrint = 0;
		for (int i = 0; i <= 5 * n; i++) {
			if (result[i] != 0) {
				countPrint++;
				System.out.print((i + n) + ":" + result[i] + ":"
						+ (result[i] * 1.0 / total) + "\t");
				if (countPrint % 5 == 0) {
					System.out.print("\n");
				}
			}
		}
	}

	public static int pow(int n, int e) {
		int total = 1;
		int temp = n;
		while (temp > 0) {
			total *= MAX;
			temp--;
		}
		return total;
	}

	public static void printResult2(int number) {
		int[][] pProbabilities = new int[2][MAX * number + 1];
		for (int i = 0; i < MAX * number + 1; ++i) {
			pProbabilities[0][i] = 0;
			pProbabilities[1][i] = 0;
		}

		int flag = 0;
		for (int i = 1; i <= MAX; ++i) {
			pProbabilities[flag][i] = 1;
		}

		for (int k = 2; k <= number; ++k) {
			for (int i = k; i <= MAX * k; ++i) {
				pProbabilities[1 - flag][i] = 0;
				for (int j = 1; j <= i && j <= MAX; ++j) {
					pProbabilities[1 - flag][i] += pProbabilities[flag][i - j];
				}
			}
			flag = 1 - flag;
		}
		
		double total = pow(number, MAX);
		for (int i = number; i <= MAX * number; ++i) {
			double ratio = pProbabilities[flag][i] / total;
			System.out.println(i + ":" + ratio);
		}

	}

	public static void main(String[] args) {
		printResult2(2);
	}

}
