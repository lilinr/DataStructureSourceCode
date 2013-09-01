package DataStructureTest;
/**
 * ������С��K��Ԫ��--ʹ������
 * @author raolilin-2013.5.1
 *
 */
public class MinK {
	/**
	 * 1-�ѵ���
	 * array[start,����,end]������array[start]���ܲ�����󶥶ѣ�����Ķ�����
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
	 * 2-��ʼ��K-�󶥶�
	 * @param array
	 * @param k
	 */
	public static void heapInit(int[] array, int k) {
		if(null == array || array.length < k) {
			System.out.println("����Ϊ�ջ����������С��ָ��ֵk");
		} else {
			for(int i=k/2; i>=0; i--) {
				heapAdjust(array, i, k-1);
			}
		}
	}
	
	/**
	 * 3-�ҵ���С��K��������ӡ����
	 * @param array
	 * @param k
	 */
	public static void printMinK(int[] array, int k) {
		if(null == array || array.length < k) {
			System.out.println("����Ϊ�ջ����������С��ָ��ֵk");
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
			System.out.print("\n��С" + k + "��Ԫ��");
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
