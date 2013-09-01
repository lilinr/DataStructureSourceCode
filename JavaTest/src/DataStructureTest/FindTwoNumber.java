package DataStructureTest;
/**
 * 输入一个已经按升序排序过的数组和一个数字。
 * @author raolilin-2013.5.3
 *
 */
public class FindTwoNumber {
	public static int[] getTwoNumber(int[] array, int value) {
		if(null == array || array.length == 0) {
			System.out.println("给定的数组为空！");
			return null;
		} else {
			int i = 0;
			int j = array.length - 1;
			while(i<j) {
				if(array[i] + array[j] > value) {
					j--;
				} else if(array[i] + array[j] < value) {
					i++;
				} else {
					break;
				}
			}
			if(i < j) {
				int[] result = {array[i], array[j]};
				return result;
			} else {
				return null;
			}
		}
	}
	public static void main(String[] args) {
		int[] array = {1, 4, 7, 11, 15};
		int[] result = getTwoNumber(array, 17);
		if(result != null) {
			System.out.println(result[0] + "---" + result[1]);
		} else {
			System.out.println("没有满足条件的两个数。");
		}
	}

}
