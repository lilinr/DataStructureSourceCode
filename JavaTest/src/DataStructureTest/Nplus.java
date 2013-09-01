package DataStructureTest;
/**
 * 求 1+2+…+n
 * 要求：不能使用乘除法、for、while、if、else、switch、case 
 * 等关键字以及条件判断语句（A?B:C）。
 * @author raolilin-2013.5.2
 *
 */
public class Nplus {
	/**
	 * 1-使用递归和短路与实现
	 * @param n
	 * @return
	 */
	public static int getNplus(int n) {
		if(n < 0) {
			return -1;
		}
		int result = 0;
		boolean temp = (n != 0) && ((result=getNplus(n-1)) == 0);
		return result + n;
	}
	public static void main(String[] args) {
		int n = 100;
		System.out.println("当n=" + n + "时1+2+...+n=" + getNplus(n));
	}

}
