package DataStructureTest;

/**
 * Ѱ�ҳ�����������ֻ�������� 2��3 ��5 ����
 * 
 * @author raolilin-2013.5.13
 * 
 */
public class ChouShu {
	//��ӡС�ڵ���n�����г�������С����Ч�ʵ�
	public static void printUglyNumber(int n) {
		if(n > 0) {
			System.out.print("��ӡС�ڵ���" + n + "�����г���:\n");
			int counter = 0;
			for(int i=1; i<=n; i++) {
				int temp = i;
				while(temp % 2 == 0) {
					temp = temp / 2;
				}
				while(temp % 3 == 0) {
					temp = temp / 3;
				}
				while(temp % 5 == 0) {
					temp = temp / 5;
				}
				if(temp == 1) {
					System.out.print(i + "\t");
					counter++;
					if(counter % 10 == 0) {
						System.out.print("\n");
					}
				}
			}
			System.out.print("\n�ܹ���" + counter + "��������");
		} else {
			System.out.println("nӦ�ô���0");
		}
	}
	

	// �����������е���С��
	public static int getMin(int number1, int number2, int number3) {
		int min = (number1 < number2) ? number1 : number2;
		min = (min < number3) ? min : number3;
		return min;
	}

	// ���ص� index ������
	public static int getUglyNumber(int index) {
		if (index <= 0) {
			return 0;
		}

		int[] pUglyNumbers = new int[index];
		pUglyNumbers[0] = 1;
		int nextUglyIndex = 1;

		int[] pMultiply2 = pUglyNumbers;
		int[] pMultiply3 = pUglyNumbers;
		int[] pMultiply5 = pUglyNumbers;
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		while (nextUglyIndex < index) {
			int min = getMin(pMultiply2[i2] * 2, pMultiply3[i3] * 3, pMultiply5[i5] * 5);
			pUglyNumbers[nextUglyIndex] = min;

			while (pMultiply2[i2] * 2 <= pUglyNumbers[nextUglyIndex]) {
				++i2;
			}
			while (pMultiply3[i3] * 3 <= pUglyNumbers[nextUglyIndex]) {
				++i3;
			}
			while (pMultiply5[i5] * 5 <= pUglyNumbers[nextUglyIndex]) {
				++i5;
			}

			++nextUglyIndex;
		}

		int ugly = pUglyNumbers[nextUglyIndex - 1];
		return ugly;

	}

	public static void main(String[] args) {
		System.out.println(getUglyNumber(5));
		printUglyNumber(1500);
	}

}
