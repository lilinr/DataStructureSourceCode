package DataStructureTest;

/**
 * ����ÿ��������ǰ������ʮ���������ų��ֵĴ���
 * @author raolilin-2013.4.27
 * 
 */
public class TenNumber {
	private static final boolean OK = true;
	private static final boolean NOT_OK = false;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nArray = {1,2,3,4,5,6,7,8,9,10};
		for(int n : nArray) {
			System.out.println(n + "��Ԫ���������£�");
			int[] top = generateArrayN(n);
			printArray(top);
			int[] bottom = getNextArray(n);
			printArray(bottom);
		}
	}

	/**
	 * 1-����n���������飨n���ڵ���4��С�ڵ���10��
	 * @param n
	 * @return
	 */
	public static int[] generateArrayN(int n) {
		if (n > 10 || n < 4) {
			System.out.println("n������ڵ���4��С�ڵ���10��");
			return null;
		} else {
			int[] arrayN = new int[n];
			for (int i = 0; i < n; i++) {
				arrayN[i] = i;
			}
			return arrayN;
		}
	}

	/**
	 * 2-���ĳ����������arrayN�г��ֵĴ���
	 * @param value
	 * @param arrayN
	 * @return
	 */
	public static int getCount(int value, int[] arrayN) {
		int count = 0;
		for (int i = 0; i < arrayN.length; i++) {
			if (value == arrayN[i]) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * 3-�������飬����ÿ��������ǰ������ʮ���������ų��ֵĴ���
	 * ��n=5ʱ���н���ģ������㷨��ȱ�ݣ�û�н������
	 * @param n
	 * @return
	 */
	public static int[] getNextArray(int n) {
		int[] top = generateArrayN(n);
		if(top != null) {
			int[] bottom = new int[n];
			for(int i=0; i<n; i++) {
				bottom[i] = 0;
			}
			for(int j=0; ; j++) {
				boolean flag = OK;
				for(int k=0; k<n; k++) {
					int count = getCount(top[k], bottom);
					if(count == bottom[k]) {
						flag = flag & OK;
					} else {
						flag = flag & NOT_OK;
						bottom[k] = count;
					}
				}
				if(flag) {
					break;
				}
				if(j > n+4) {
					System.out.println("n=" + n + "ʱû�н����");
					return null;
				}
			}
			return bottom;
		} else {
			return null;
		}
	}
	
	public static void printArray(int[] arrayN) {
		if(arrayN == null) {
			System.out.println("arrayNΪ�գ�");
		} else {
			for(int i=0; i< arrayN.length; i++) {
				System.out.print(arrayN[i] + " ");
			}
			System.out.println();
		}
	}
}
