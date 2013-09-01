package DataStructureTest;
/**
 * 斐波纳契数
 * @author raolilin-2013.5.6
 *
 */
public class Fibonaccil {
	private int counter = 0;
	/**
	 * 1-递归
	 * @param n
	 * @return
	 */
	public int fibonaccil1(int n) {
		counter++;
		if(n < 0) {
			System.out.println("n应该大于等于0！");
			return -1;
		} else if(n == 0 || n == 1) {
			return n;
		} else {
			return fibonaccil1(n-1) + fibonaccil1(n-2);
		}
	}
	/**
	 * 2-非递归，循环
	 * @param n
	 * @return
	 */
	public  int fibonaccil2(int n) {
		if(n < 0) {
			System.out.println("n应该大于等于0！");
			return -1;
		} else {
			int f0 = 0;
			int f1 = 1;
			int f2 = n;
			for(int i=2; i<=n; i++) {
				f2 = f0 + f1;
				f0 = f1;
				f1 = f2;
			}
			return f2;
		}
	}
	
	public static void main(String[] args) {
		Fibonaccil f = new Fibonaccil();
		int n = 10;
		System.out.println("递归f(" + n + ")=" + f.fibonaccil1(n));
		System.out.println("递归f(" + n + ")递归次数=" + f.counter);
		System.out.println("非递归f(" + n + ")=" + f.fibonaccil2(n));
	}

}
