package DataStructureTest;

import java.util.Scanner;

/**
 * 给出一个数列，找出其中最长的单调递减（或递增）子序列
 * 
 * @author raolilin-2013.5.12
 * 
 */
public class MaxSortedSubArray {
	/**
	 * 1-getMaxSubDesc
	 * 
	 * @param array
	 * @return
	 */
	public static int[] getMaxSubDesc(int[] array) {
		if (array != null && array.length != 0) {
			int start = 0;
			int end = 0;
			int i = 0;
			int j = 0;
			while (i < array.length) {
				for (j = i + 1; j < array.length; j++) {
					if (array[j] >= array[j - 1]) {
						break;
					}
				}
				if ((j - i) > (end - start)) {
					start = i;
					end = j;
				}
				i = j;
			}

			int[] result = new int[end - start];
			for (int k = start; k < end; k++) {
				result[k - start] = array[k];
			}
			return result;
		} else {
			System.out.println("array is null!");
			return null;
		}
	}

	public static void printArray(int[] array) {
		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + ">>");
			}
			System.out.println();
		}
	}

	// public static void main(String[] args) {
	// int[] array = {9,8,7,6,5,4,6,1,2,3,4,5,4,3,2,1};
	// int[] result = getMaxSubDesc(array);
	// printArray(array);
	// printArray(result);
	// }

	public static int bsearch(int[] a, int s, int m) {
		int low = 1;
		int high = s;
		int mid;
		while (low < high) {
			mid = (low + high) / 2;
			if (a[mid] == m) {
				return mid;
			}
			if (a[mid] > m) {
				low = mid + 1;
			}
			else {
				high = mid;
			}
		}
		if (a[low] <= m) {
			return low;
		}
		else {
			return low + 1;
		}
	}

	public static void print(int[] a, int[] b, int level, int start) {
		if (level == 0) {
			return;
		}
		int i = start;
		while (b[i] != level) {
			i--;
		}
		print(a, b, level - 1, i - 1);
		System.out.print(a[i] + " ");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] array = new int[n];
		int[] b = new int[n];
		int[] c = new int[n + 1];

		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
			c[i] = -1;
		}
		int s = 1;
		int k;
		c[1] = array[0];
		for (int i = 0; i < n; i++) {
			k = bsearch(c, s, array[i]);
			if (k > s) {
				s++;
			}
			c[k] = array[i];
			b[i] = k;
		}
		System.out.println("The length of longest squence is: " + s);
		System.out.print("The squence is: ");
		print(array, b, s, n - 1);
	}

}
