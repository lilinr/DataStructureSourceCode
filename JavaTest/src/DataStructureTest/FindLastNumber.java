package DataStructureTest;
/**
 * n个数字（0,1,…,n-1）形成一个圆圈
 * 从数字 0 开始，每次从这个圆圈中删除第 m个数字（第一个为当前数字本身，
 * 第二个为当前数字的下一个数字）。当一个数字删除后，
 * 从被删除数字的下一个继续删除第 m 个数字。
 * 求出在这个圆圈中剩下的最后一个数字。 
 * @author raolilin-2013.5.3
 *
 */
public class FindLastNumber {
	/**
	 * 1-求出在这个圆圈中剩下的最后一个数字
	 * @param n
	 * @param m
	 * @return
	 */
	public static int getLastNumber(int n, int m) {
		if(n<=0 || m<0) {
			System.out.println("n应该大于0,m应大于等于0");
			return -1;
		}
		int[] queue = new int[n];
		for(int i=0; i<n; i++) {
			queue[i] = i;
		}
		int deleteIndex = -1;
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<m; j++) {
				while(queue[(deleteIndex + 1) % n] == -1) {
					deleteIndex = (deleteIndex + 1) % n;
				}
				deleteIndex = (deleteIndex + 1) % n;
			}
			queue[deleteIndex] = -1;
		}
		int index = 0;
		while(queue[index] == -1) {
			index++;
		}
		return queue[index];
	}
	
	
	
	public static void main(String[] args) {
		int n = 166;
		int m = 5;
		System.out.println("n=" + n + ",m=" + m + ",剩下最后一个数字为：" + getLastNumber(n, m));
		System.out.println("递归n=" + n + ",m=" + m + ",剩下最后一个数字为：" + getLastNumber2(n, m));
	}
	/**
	 * 2-递归方法f(n,m) = (f(n-1,m)+m)%n
	 * @param n
	 * @param m
	 * @return
	 */
	public static int getLastNumber2(int n, int m) {
		if(n<=0 || m<0) {
			System.out.println("n应该大于0,m应大于等于0");
			return -1;
		} else if(n>1) {
			return (getLastNumber2(n-1, m) + m) % n;
		} else {
			return 0;
		}
	}
}
