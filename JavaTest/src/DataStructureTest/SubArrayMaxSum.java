package DataStructureTest;
/**
 * �����������ͣ�ʱ�临�Ӷ�Ϊo(n)
 * @author raolilin-2013.4.30
 *
 */
public class SubArrayMaxSum {
	public static int getSubArrayMaxSum(int[] array) throws NullPointerException{
		if(null == array || array.length == 0) {
			throw new NullPointerException("getSubArrayMaxSum(int[] array)����Ϊ�գ�");
		}
		int result = 0;
		int tempSum = 0;
		int maxNegative = array[0];
		
		for(int i=0; i<array.length; i++) {
			if(tempSum <= 0) {
				tempSum = array[i];
			} else {
				tempSum = tempSum + array[i];
			}
			//result��������������
			if(tempSum > result) {
				result = tempSum;
			}
			if(array[i] > maxNegative) {
				maxNegative = array[i];
			}
		}
		
		if(maxNegative <= 0) {
			return maxNegative;
		} 
		return result;
	}
	
	public static void main(String[] args) {
		int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
		int maxSum = getSubArrayMaxSum(array);
		System.out.println("maxSum=" + maxSum);
	}

}
