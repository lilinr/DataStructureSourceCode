package DataStructureTest;
/**
 * 查找最小的K的元素--使用最大堆
 * @author raolilin-2013.5.1
 *
 */
public class MinK {
	/**
	 * 1-堆调整
	 * array[start,……,end]，其中array[start]可能不满足大顶堆，其余的都满足
	 * @param array
	 * @param start
	 * @param end
	 */
	public static void heapAdjust(int[] array, int start, int end) {
		if(start < end) {
			int temp = array[start];
			int i = start;
			int j;
			for(j=2*i+1; j<=end; j=2*j+1) {
				if(j < end - 1 && array[j+1] > array[j]) {
					j = j + 1;
				}
				if(temp > array[j]) {
					break;
				} else {
					array[i] = array[j];
					i = j;
				}
			}
			array[i] = temp;
		}
	}
	/**
	 * 2-初始化K-大顶堆
	 * @param array
	 * @param k
	 */
	public static void heapInit(int[] array, int k) {
		if(null == array || array.length < k) {
			System.out.println("数组为空或者数组个数小于指定值k");
		} else {
			for(int i=k/2; i>=0; i--) {
				heapAdjust(array, i, k-1);
			}
		}
	}
	
	/**
	 * 3-找到最小的K个数并打印出来
	 * @param array
	 * @param k
	 */
	public static void printMinK(int[] array, int k) {
		if(null == array || array.length < k) {
			System.out.println("数组为空或者数组个数小于指定值k");
		} else {
			heapInit(array, k);
			for(int i=k; i<array.length; i++) {
				if(array[i] < array[0]) {
					int temp = array[0];
					array[0] = array[i];
					array[i] = temp;
					heapAdjust(array, 0, k-1);
				}
			}
			System.out.print("\n最小" + k + "个元素");
			for(int i=0; i<k; i++) {
				System.out.print("-->" + array[i]);
			}
		}
	}
		
	public static void main(String[] args) {
		int[] array = {88, 33, 4, 1, 3, 5, 2, 21, 34, 47, 21};
		printMinK(array, 5);
	}

}
