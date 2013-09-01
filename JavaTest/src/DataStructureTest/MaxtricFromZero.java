package DataStructureTest;
/**
 * 1.（不会）对于一个整数矩阵，存在一种运算，对矩阵中任意元素加一时，
 * 需要其相邻（上下左右）某一个元素也加一，
 * 现给出一正数矩阵，判断其是否能够由一个全零矩阵经过上述运算得到。
 * 2.（不会）一个整数数组，长度为n，将其分为m 份，使各份的和相等，求m的最大值。
 * @author raolilin-2013.5.8
 *
 */
public class MaxtricFromZero {
	
	
	/**
	 * 2(1)-给数组排序，选择排序
	 * @param array
	 */
	public static void sort(int[] array) {
		if(array != null && array.length != 0) {
			int k;
			for(int i=0; i<array.length-1; i++) {
				k = i;
				for(int j=i+1; i<array.length; j++) {
					if(array[i] > array[j]) {
						k = j;
					}
				}
				if(k != i) {
					int temp = array[i];
					array[i] = array[k];
					array[k] = temp;
				}
			}
		} else {
			System.out.println("array is null!");
		}
	}
	/**
	 * 2(2)-求数组之和
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getSum(int[] array, int start, int end) {
		if(array != null && array.length != 0) {
			int sum = 0;
			if(start >=0 && end < array.length) {
				for(int i=start; i<=end; i++) {
					sum = sum + array[i];
				}
			}
			return sum;
		} else {
			System.out.println("array is null!");
			return 0;
		}
	}
	
	/**
	 * 2(3)-找到m的最大值
	 * @param array
	 * @return
	 */
	public static int getMaxNum(int[] array) {
		if(array != null && array.length != 0) {
			int count = 1;
			//给数组排序
			sort(array);
			int divide = array[array.length-1];
			int start = 0;
			int end = array.length-1;
			int sum = getSum(array, start, end);
			int res = sum % divide;
			while(!(divide == 0 && res == 0)) {
				
			}
			
			
			
			return count;
		} else {
			System.out.println("array is null!");
			return 0;
		}
	}
	
	
	public static void main(String[] args) {

	}

}
