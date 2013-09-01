package sort;

import java.util.Random;

public class SortTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] array1 = randomArray(10);
//		printArray(array1);
//		insertSort(array1);
//		printArray(array1);
//		int[] array2 = randomArray(10);
//		printArray(array2);
//		shellSort(array2);
//		printArray(array2);
//		int[] array3 = randomArray(10);
//		printArray(array3);
//		bubbleSort(array3);
//		printArray(array3);
//		int[] array = randomArray(10);
//		printArray(array);
//		selectSort(array);
//		printArray(array);

		int[] array = randomArray(10);
		printArray(array);
		quickSort2(array, 0, array.length-1);
		printArray(array);
		
		
//		int[] array = randomArray(10);
//		int[] temp = new int[10];
//		printArray(array);
//		heapSort(array);
//		printArray(array);
	}
	/**
	 * 产生一个随机数组
	 * @param n
	 * @return
	 */
	public static int[] randomArray(int n) {
		if(n > 0) {
			Random rnd = new Random();
			int[] array = new int[n];
			for(int i=0; i<n; i++) {
				array[i] = rnd.nextInt(100);
			}
			return array;
		} else {
			return null;
		}
	}
	/**
	 * 打印数组
	 * @param array
	 */
	public static void printArray(int[] array) {
		System.out.print("数组为：");
		if(array != null && array.length != 0) {
			for(int i=0; i<array.length; i++) {
				System.out.print(array[i] + " ");
			}
		}
		System.out.println();
	}
	
	/**
	 * 1-直接插入排序
	 * @param array
	 */
	public static void insertSort(int[] array) {
		if(array != null && array.length != 0) {
			int i;
			int j;
			int temp;
			for(i=1; i<array.length; i++) {
				temp = array[i];
				j = i;
				while(j>0 && array[j-1] > temp) {
					array[j] = array[j-1];
					j = j - 1;
				}
				array[j] = temp;
			}
		} else {
			System.out.println("数组为空！");
		}
	}
	/**
	 * 2-希尔排序
	 * @param array
	 */
	public static void shellSort(int[] array) {
		if(array != null && array.length != 0) {
			int i;
			int j;
			int temp;
			int d = array.length / 2;
			while(d >= 1) {
				for(i=d; i<array.length; i++) {
					temp = array[i];
					j = i;
					while(j>d-1 && array[j-d] > temp) {
						array[j] = array[j-d];
						j = j - d;
					}
					array[j] = temp;
				}
				d = d / 2;
			}
		} else {
			System.out.println("数组为空！");
		}
	}
	/**
	 * 3-冒泡排序
	 * @param array
	 */
	public static void bubbleSort(int[] array) {
		if(array != null && array.length != 0) {
			boolean changed = false;
			for(int i=0; i<array.length-1; i++) {
				for(int j=i+1; j<array.length; j++) {
					if(array[i] > array[j]) {
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
						changed = true;
					}
				}
				if(!changed) {
					break;
				}
			}
		} else {
			System.out.println("数组为空！");
		}
	}
	/**
	 * 4-选择排序
	 * @param array
	 */
	public static void selectSort(int[] array) {
		if(array != null && array.length != 0) {
			int k;
			int temp;
			for(int i=0; i<array.length-1; i++) {
				k = i;
				for(int j=i+1; j<array.length; j++) {
					if(array[j] < array[k]) {
						k = j;
					}
				}
				if(k != i) {
					temp = array[i];
					array[i] = array[k];
					array[k] = temp;
				}
			}
		} else {
			System.out.println("数组为空！");
		}
	}
	/**
	 * 5-快速排序
	 * @param array
	 * @param low
	 * @param high
	 */
	public static void quickSort(int[] array, int low, int high) {
		if(array != null && array.length != 0) {
			if(low < high) {
				int lowIndex = low;
				int highIndex = high;
				int temp = array[lowIndex];
				while(lowIndex < highIndex) {
					while((lowIndex < highIndex) && (array[highIndex] > temp)) {
						highIndex --;
					}
					if(lowIndex < highIndex) {
						array[lowIndex] = array[highIndex];
						lowIndex++;
					}
					while((lowIndex < highIndex) && (array[lowIndex] < temp)) {
						lowIndex ++;
					}
					if(lowIndex < highIndex) {
						array[highIndex] = array[lowIndex];
						highIndex--;
					}
				}
				array[lowIndex] = temp;
				quickSort(array, low, lowIndex-1);
				quickSort(array, lowIndex+1, high);
			}
		} else {
			System.out.println("数组为空！");
		}
	}
	public static void quickSort2(int[] array, int low, int high) {
		if(array != null && array.length != 0) {
			if(low < high) {
				int i = low - 1;
				int j = low;
				int temp;
				while(j <= high) {
					if(array[j] < array[high]) {
						i++;
						temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
					j++;
				}
				temp = array[i+1];
				array[i+1] = array[high];
				array[high] = temp;
				quickSort2(array, low, i);
				quickSort2(array, i+2, high);
			}
		} else {
			System.out.println("数组为空！");
		}
	}
	/**
	 * 6-归并排序
	 * @param array
	 * @param tempArr
	 * @param start
	 * @param end
	 */
	public static void mergeSort(int[] array, int[] tempArr, int start, int end) {
		if(array != null && array.length != 0) {
			if(start < end) {
				int middle = (end - start) / 2 + start;
				mergeSort(array, tempArr, start, middle);
				mergeSort(array, tempArr, middle+1, end);
				if(array[middle] < array[middle+1]) {
					return;//已排好序
				} else {
					int iA = start;
					int iB = middle + 1;
					int iTemp = start;
					while(iA <= middle && iB <= end) {
						if(array[iA] < array[iB]) {
							tempArr[iTemp] = array[iA];
							iA++;
						} else {
							tempArr[iTemp] = array[iB];
							iB++;
						}
						iTemp++;
					}
					while(iA <= middle) {
						tempArr[iTemp] = array[iA];
						iA++;
						iTemp++;
					}
					while(iB <= end) {
						tempArr[iTemp] = array[iB];
						iB++;
						iTemp++;
					}
					for(int i=start; i<=end; i++) {
						array[i] = tempArr[i];
					}
				}
			}
		} else {
			System.out.println("数组为空！");
		}
	}
	/**
	 * 7-堆排序
	 * @param array
	 */
	public static void heapSort(int[] array) {
		if(array != null && array.length != 0) {
			int temp;
			for(int i=(array.length-1)/2; i>=0; i--) {
				heapAdjust(array, i, array.length);
			}
			for(int i = array.length-1; i>=0; i--) {
				temp = array[0];
				array[0] = array[i];
				array[i] = temp;
				heapAdjust(array, 0 , i);
			}
		} else {
			System.out.println("数组为空！");
		}
	}
	/**
	 * 7-0-建立初始堆
	 * start-end之间，只有start为满足堆的特性，调整start
	 * @param array
	 * @param start
	 * @param end
	 */
	private static void heapAdjust(int[] array, int start, int end) {
		int i = start;
		int j = 2*i + 1;
		int temp = array[i];
		boolean isHeaped = false;
		while(j < end && !isHeaped) {
			//有右子树，且右子树>左子树
			if((j < end - 1) && array[j] < array[j+1]) {
				j++;
			}
			if(temp <= array[j]) {
				array[i] = array[j];
				i = j;
				j = 2*i + 1;
			} else {
				isHeaped = true;
			}
		} 
		array[i] = temp;
	}
	
	
};