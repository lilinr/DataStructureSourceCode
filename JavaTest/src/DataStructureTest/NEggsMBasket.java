package DataStructureTest;

/**
 * n ������ m������ ÿ�����ӱ����м���
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
				// �˴� i<=N-1 ����˼�������ȡ�� N-1 ��Ϊ�����ȡ���ˣ� ����ľͱ�Ȼ�пյ�,����һ��Ҫ N �����Ӷ�����
				// ȡN �Ļ��������˼������� N ������ �������еĲ���(���ż���)
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
				// �˴� i<=N-1 ����˼�������ȡ�� N-1 ��Ϊ�����ȡ���ˣ� ����ľͱ�Ȼ�пյ�,����һ��Ҫ N �����Ӷ�����
				// ȡN �Ļ��������˼������� N ������ �������еĲ���(���ż���)
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
