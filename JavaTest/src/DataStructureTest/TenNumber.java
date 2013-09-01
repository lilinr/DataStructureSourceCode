package DataStructureTest;

/**
 * 下排每个数是先前上排那十个数在下排出现的次数
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
			System.out.println(n + "个元素数组如下：");
			int[] top = generateArrayN(n);
			printArray(top);
			int[] bottom = getNextArray(n);
			printArray(bottom);
		}
	}

	/**
	 * 1-生成n个数的数组（n大于等于4且小于等于10）
	 * @param n
	 * @return
	 */
	public static int[] generateArrayN(int n) {
		if (n > 10 || n < 4) {
			System.out.println("n必须大于等于4且小于等于10！");
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
	 * 2-获得某个数在数组arrayN中出现的次数
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
	 * 3-产生数组，下排每个数是先前上排那十个数在下排出现的次数
	 * 当n=5时是有结果的，但是算法有缺陷，没有解出来。
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
					System.out.println("n=" + n + "时没有结果！");
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
			System.out.println("arrayN为空！");
		} else {
			for(int i=0; i< arrayN.length; i++) {
				System.out.print(arrayN[i] + " ");
			}
			System.out.println();
		}
	}
}
