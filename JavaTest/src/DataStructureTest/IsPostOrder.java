package DataStructureTest;
/**
 * �ж����������ǲ��Ƕ�Ԫ�������ĺ���������
 * @author raoliln-2013.5.1
 *
 */
public class IsPostOrder {

	/**
	 * 1-�ݹ��ж�һ�����������ǲ��Ƕ�Ԫ�������ĺ���������
	 * @param array
	 * @param start ��
	 * @param end   ��
	 * @return
	 */
	public static boolean isPostOrder(int[] array, int start, int end) {
		if(null == array || array.length == 0) {
			System.out.println("��������Ϊ�գ�");
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
		System.out.println("array�ǲ��Ƕ�Ԫ�������ĺ�����������" + isPostOrder(array, 0, array.length-1));
	}

}
