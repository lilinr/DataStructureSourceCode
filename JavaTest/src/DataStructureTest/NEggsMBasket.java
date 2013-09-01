package DataStructureTest;

/**
 * n 个鸡蛋 m个篮子 每个篮子必须有鸡蛋
 * 
 * @author raolilin-2013.5.19
 * 
 */
public class NEggsMBasket {

	public static void easyWay(int N, int M, int start, StringBuffer path) {
		if(M > 0) {
			System.out.println("n=" + N + ",m=" + M + ",start=" + start);
			if (N == 0) {
				System.out.println(path);
			}
			if (start <= N && M == 1) {
				path.append(N);
				System.out.println(path);
				path.setLength(path.length() - 1);
				return;
			}
			for (int i = start; i <= N - 1; i++) {
				// 此处 i<=N-1 的意思就是最多取到 N-1 因为如果你取满了， 后面的就必然有空的,此题一定要 N 个篮子都用上
				// 取N 的话代表的意思就是最多 N 个篮子 ，可以有的不用(不放鸡蛋)
				easyWay(N - i, M - 1, i, path.append(i));
				path.setLength(path.length() - 1);
			}
		}
		
	}
	
	public static void easyWay(int N, int M, int start, String path) {
		if(M > 0) {
			if (N == 0) {
				System.out.println(path);
			}
			if (start <= N && M == 1) {
				System.out.println(path + N);
				return;
			}
			for (int i = start; i <= N - 1; i++) {
				// 此处 i<=N-1 的意思就是最多取到 N-1 因为如果你取满了， 后面的就必然有空的,此题一定要 N 个篮子都用上
				// 取N 的话代表的意思就是最多 N 个篮子 ，可以有的不用(不放鸡蛋)
				easyWay(N - i, M - 1, i, path+i);
			}
		}
	}

	public static void main(String[] args) {
		easyWay(0, 1, 1, new StringBuffer());
		easyWay(6, 0, 1, "");
		int[] d = new int[6];
	}

}
