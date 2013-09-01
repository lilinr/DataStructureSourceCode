package DataStructureTest;
/**
 * n�����֣�0,1,��,n-1���γ�һ��ԲȦ
 * ������ 0 ��ʼ��ÿ�δ����ԲȦ��ɾ���� m�����֣���һ��Ϊ��ǰ���ֱ���
 * �ڶ���Ϊ��ǰ���ֵ���һ�����֣�����һ������ɾ����
 * �ӱ�ɾ�����ֵ���һ������ɾ���� m �����֡�
 * ��������ԲȦ��ʣ�µ����һ�����֡� 
 * @author raolilin-2013.5.3
 *
 */
public class FindLastNumber {
	/**
	 * 1-��������ԲȦ��ʣ�µ����һ������
	 * @param n
	 * @param m
	 * @return
	 */
	public static int getLastNumber(int n, int m) {
		if(n<=0 || m<0) {
			System.out.println("nӦ�ô���0,mӦ���ڵ���0");
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
		System.out.println("n=" + n + ",m=" + m + ",ʣ�����һ������Ϊ��" + getLastNumber(n, m));
		System.out.println("�ݹ�n=" + n + ",m=" + m + ",ʣ�����һ������Ϊ��" + getLastNumber2(n, m));
	}
	/**
	 * 2-�ݹ鷽��f(n,m) = (f(n-1,m)+m)%n
	 * @param n
	 * @param m
	 * @return
	 */
	public static int getLastNumber2(int n, int m) {
		if(n<=0 || m<0) {
			System.out.println("nӦ�ô���0,mӦ���ڵ���0");
			return -1;
		} else if(n>1) {
			return (getLastNumber2(n-1, m) + m) % n;
		} else {
			return 0;
		}
	}
}
