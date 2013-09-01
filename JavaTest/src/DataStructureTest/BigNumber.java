package DataStructureTest;
/**
 * 
 * @author Raolilin 2013-9-1
 *
 */
public class BigNumber {
	//模拟数字加1
	private static boolean increase(char[] number) {
		if(null == number || number.length == 0) {
			System.out.println("Invalid input.");
			return false;
		} else {
			boolean isOverflow = false;
			int len = number.length;
			int nTakeOver = 0;
			for(int i=len-1; i>=0; --i) {
				int nValue = number[i] - '0' + nTakeOver;
				if(i == len - 1) {
					nValue ++;
				}
				if(nValue >= 10) {
					if(i == 0) {
						isOverflow = true;
					} else {
						nValue -= 10;
						nTakeOver = 1;
						number[i] = (char) (nValue + '0');
					}
				} else {
					number[i] = (char) (nValue + '0');
					break;//!!!!
				}
			}
			return isOverflow;
		}
	}
	
	private static void print(char[] number) {
		if(null == number || number.length == 0) {
			System.out.println("Invalid input.");
		} else {
			boolean isStartWithZero = true;
			int len = number.length;
			for(int i=0; i<len; ++i) {
				if(isStartWithZero && number[i] != '0') {
					isStartWithZero = false;
				}
				if(!isStartWithZero) {
					System.out.print(number[i]);
				}
			}
		}
	}
	
	public static void printOneToN(int n) {
		char[] number = new char[n];
		for(int i=0; i<n; i++) {
			number[i] = '0';
		}
		int i = 1;
		while(!increase(number)) {
			print(number);
			++i;
			if(i % 10 == 1) {
				System.out.println();
			} else {
				System.out.print("\t");
			}
		}
	}
	
	//全排列
	private static void printNumber(char[] number, int length, int index) {
		if(index == length) {
			print(number);
			if(number[length-1] == '0') {
				System.out.println();
			} else {
				System.out.print("\t");
			}
		} else {
			for(int i=0; i<10; ++i) {
				number[index] = (char) (i + '0');
				printNumber(number, length, index + 1);
			}
		}
	}
	
	public static void printOneToN2(int n) {
		char[] number = new char[n];
		for(int i=0; i<n; i++) {
			number[i] = '0';
		}
		printNumber(number, n, 0);
	}
	public static void main(String[] args) {
		int n = 2;
		printOneToN(n);
		System.out.println();
		printOneToN2(n);
	}

}
