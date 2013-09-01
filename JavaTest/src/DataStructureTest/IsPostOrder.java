package DataStructureTest;
/**
 * 判断整数序列是不是二元查找树的后序遍历结果
 * @author raoliln-2013.5.1
 *
 */
public class IsPostOrder {

	/**
	 * 1-递归判断一个整数序列是不是二元查找树的后序遍历结果
	 * @param array
	 * @param start 含
	 * @param end   含
	 * @return
	 */
	public static boolean isPostOrder(int[] array, int start, int end) {
		if(null == array || array.length == 0) {
			System.out.println("整数序列为空！");
			return false;
		}
		if(start >= end || start + 1 == end) {
			return true;
		} else {
			System.out.println("start" + start);
			System.out.println("end" + end);
			int i;
			int j;
			for(i=start; i<end; i++) {
				if(array[i] > array[end]) {
					break;
				}
			}
			for(j=i+1; j<end; j++) {
				if(array[j] < array[end]) {
					break;
				}
			}
			if(j < end) {
				return false;
			} else {
				return isPostOrder(array, start, i-1) && isPostOrder(array, i, end-1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {4, 6, 5, 12, 14, 15, 10};
		System.out.println("array是不是二元查找树的后序遍历结果：" + isPostOrder(array, 0, array.length-1));
	}

}
