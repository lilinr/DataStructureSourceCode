package DataStructureTest;

import java.util.Arrays;

/**
 * 通过交换 a,b中的元素，使[序列 a元素的和]与[序列 b元素的和]之间的差最小
 * 
 * @author raolilin-2013.5.10
 * 
 */
public class ExchangeAB {
	/**
	 * 1-sum of array
	 * 
	 * @param array
	 * @return
	 */
	public static int getSum(int[] array) {
		if (array != null) {
			int sum = 0;
			for (int i = 0; i < array.length; i++) {
				sum = sum + array[i];
			}
			return sum;
		} else {
			System.out.println("array is null!");
			return -1;
		}
	}

	public static void exchangeAB(int[] a, int[] b) {
		if (a != null && b != null && a.length != 0 && a.length == b.length) {
			int sumA = getSum(a);
			int sumB = getSum(b);
			if (sumA == sumB) {
				return;
			} else if (sumA < sumB) {
				int[] temp = a;
				a = b;
				b = temp;
			}
			int oldDiff = getSum(a) - getSum(b);
			boolean needExchange = true;
			int pA = -1;
			int pB = -1;
			while (needExchange && oldDiff > 0) {
				needExchange = false;
				int newDiff = oldDiff;
				for (int i = 0; i < a.length; i++) {
					for (int j = 0; j < b.length; j++) {
						int delta = a[i] - b[j];
						int currentDiff = Math.abs(oldDiff - 2 * delta);
						if (currentDiff < newDiff) {
							newDiff = currentDiff;
							pA = i;
							pB = j;
							needExchange = true;
						}
					}
				}
				if (needExchange) {
					int temp = a[pA];
					a[pA] = b[pB];
					b[pB] = temp;
					oldDiff = newDiff;
				}
			}
			System.out.println("min diff is " + oldDiff);
		} else {
			System.out.println("a and b is not correct!");
		}
	}

	public static void main(String[] args) {
//		 int[] a = {100,99,98,1,2,3};
//		 int[] b = {1, 2, 3, 4,5,40};
		 int[] a={3,5,10};
		 int[] b={20,25,50};
//		int[] a = { 3, 5, -10 };
//		int[] b = { 20, 25, 50 };
		exchangeAB(a, b);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
//		 int[] c = {100,99,98,1,2,3};
//		 int[] d = {1, 2, 3, 4,5,40};
		 int[] c={3,5,10};
		 int[] d={20,25,50};
//		int[] c = { 3, 5, -10 };
//		int[] d = { 20, 25, 50 };
		swapToMinusDiff(c, d);
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(d));
	}

	/**
	 * 参考答案
	 */
	public static void swapToMinusDiff(int[] a, int[] b) {
		int sumA = getSum(a);
		int sumB = getSum(b);
		if (sumA == sumB)
			return;
		if (sumA < sumB) {
			int[] temp = a;
			a = b;
			b = temp;
		}
		int curDiff = 1;
		int oldDiff = Integer.MAX_VALUE;
		int pA = -1;
		int pB = -1;
		boolean shift = true;
		int len = a.length;// the length of a and b should be the same
		while (shift && curDiff > 0) {
			shift = false;
			curDiff = getSum(a) - getSum(b);
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					int temp = a[i] - b[j];
					int newDiff = Math.abs(curDiff - 2 * temp);
					if (newDiff < curDiff && newDiff < oldDiff) {
						shift = true;
						oldDiff = newDiff;
						pA = i;
						pB = j;
					}
				}
			}
			if (shift) {
				int temp = a[pA];
				a[pA] = b[pB];
				b[pB] = temp;
			}
		}
		System.out.println("the min diff is " + oldDiff);
	}


}
