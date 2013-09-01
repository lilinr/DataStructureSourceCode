package DataStructureTest;
/**
 * �� 1+2+��+n
 * Ҫ�󣺲���ʹ�ó˳�����for��while��if��else��switch��case 
 * �ȹؼ����Լ������ж���䣨A?B:C����
 * @author raolilin-2013.5.2
 *
 */
public class Nplus {
	/**
	 * 1-ʹ�õݹ�Ͷ�·��ʵ��
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
		System.out.println("��n=" + n + "ʱ1+2+...+n=" + getNplus(n));
	}

}
