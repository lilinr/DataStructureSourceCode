package DataStructureTest;
/**
 * �������� n����˳������� 1���� nλ 10������
 * @author raolilin-2013.5.13
 *
 */
public class Print1ToN {
	/**
	 * 1-��˳������� 1���� nλ 10������
	 * @param n
	 */
	public static void printNumbers(int n) {
		if(n > 0) {
			int max = 1;
			while(n > 0) {
				max *= 10;
				n--;
			}
			System.out.println("�� 1���� nλ 10������:");
			for(int i=1; i<max; i++) {
				System.out.print(i + "\t");
				if(i % 10 == 0) {
					System.out.print("\n");
				}
			}
		} else {
			System.out.println("nӦ�ô���0��");
		}
	}
	
	/**
	 * 2-3-��˳������� 1���� nλ 10�����������ݹ飩
	 * @param n
	 */
	public static void printNumbers2(int n) {
		if(n > 0) {
			char[] res = new char[n];
			printTheResult(res, n, 0);
		} else {
			System.out.println("nӦ�ô���0��");
		}
	}
	
	/**
	 * 2-2-�ݹ��ӡ
	 * @param res
	 * @param length
	 * @param index
	 */
	public static void printTheResult(char[] res, int length, int index) {
		if(index == length) {
			printTemp(res);
		} else {
			for(int i=0; i<=9; i++) {
				res[index] = (char) ('0' + i);
				printTheResult(res, length, index+1);
			}
		}
	}
	
	/**
	 * 2-1-��ӡ�ַ����͵�����
	 * @param res
	 */
	public static void printTemp(char[] res) {
		if(res != null) {
			int len = res.length;
			boolean canPrint = false;
			for(int i=0; i<len-1; i++) {
				if(!canPrint && res[i] != '0') {
					canPrint = true;
				}
				if(canPrint) {
					System.out.print(res[i]);
				}
			}
			System.out.println(res[len-1]);
		}
	}
	
	public static void main(String[] args) {
		printNumbers(3);
		printNumbers2(3);
		
	}

}
