package DataStructureTest;
/**
 * 1.�����ᣩ����һ���������󣬴���һ�����㣬�Ծ���������Ԫ�ؼ�һʱ��
 * ��Ҫ�����ڣ��������ң�ĳһ��Ԫ��Ҳ��һ��
 * �ָ���һ���������ж����Ƿ��ܹ���һ��ȫ����󾭹���������õ���
 * 2.�����ᣩһ���������飬����Ϊn�������Ϊm �ݣ�ʹ���ݵĺ���ȣ���m�����ֵ��
 * @author raolilin-2013.5.8
 *
 */
public class MaxtricFromZero {
	
	
	/**
	 * 2(1)-����������ѡ������
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
	 * 2(2)-������֮��
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
	 * 2(3)-�ҵ�m�����ֵ
	 * @param array
	 * @return
	 */
	public static int getMaxNum(int[] array) {
		if(array != null && array.length != 0) {
			int count = 1;
			//����������
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
