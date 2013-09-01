package DataStructureTest;
/**
 * 左移递减数列查找某一个数
 * @author raolilin-2013.5.6
 *
 */
public class FindNum {
	/**
	 * 1-二分查找(递减)
	 * @param array
	 * @param item
	 * @return
	 */
	public static int binarySearch(int[] array, int item) {
		if(array != null && array.length > 0) {
			int flag = -1;
			int low = 0;
			int high = array.length -1;
			int mid;
			while(low <= high) {
				mid = (high - low) / 2 + low;
				if(item < array[mid]) {
					low = mid + 1;
				} else if(item > array[mid]) {
					high = mid - 1;
				} else {
					flag = mid;
					break;
				}
			}
			return flag;
		} else {
			System.out.println("数组为空！");
			return -1;
		}
	}
	
	public static int searchNumber(int[] array, int low, int high, int item) {
		if(array != null && array.length > 0 && low<=high) {
			if(low == high) {
				if(array[low] == item) {
					return low;
				} else {
					return -1;
				}
			} else {
				int mid = (high - low) / 2 + low;
				if(array[mid] == item) {
					return mid;
				} else {
					if(array[low] >= array[mid]) {
						if(item <= array[low] && item > array[mid]) {
							return searchNumber(array, low, mid-1, item);
						} else {
							return searchNumber(array, mid+1, high, item);
						}
					} else {
						if(item < array[mid] && item >= array[high]) {
							return searchNumber(array, mid+1, high, item);
						} else {
							return searchNumber(array, low, mid-1, item);
						}
					}
				}
			}
		} else {
			System.out.println("数组为空！");
			return -1;
		}
	}
	
	
	public static void main(String[] args) {
		int[] array = {7,6,5,4,3,2,1,9,8};
		System.out.println("index:" + searchNumber(array,0,array.length-1,4));
	}

}
