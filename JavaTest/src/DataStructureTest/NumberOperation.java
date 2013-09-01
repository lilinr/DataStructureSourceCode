package DataStructureTest;


/**
 * 
 * @author raolilin-2013.5.14
 *
 */
public class NumberOperation {
	
	/**
	 * 1-输入一个正整数数组，将它们连接起来排成一个数，输出能排出的所有数字中最小的一个。
	 * @param array
	 * @return
	 */
	public static String getMinNum(int[] array) {
		if(array != null && array.length != 0) {
			if(array.length == 1) {
				return array[0] + "";
			} else {
				String result = "";
				String[] arrayStr = new String[array.length];
				for(int i=0; i<array.length; i++) {
					arrayStr[i] = array[i] + "";
				}
				printStringArray(arrayStr);
				sortStrArray(arrayStr);
				printStringArray(arrayStr);
				for(int i=0; i<arrayStr.length; i++) {
					if(i<arrayStr.length-1 && isPre(arrayStr[i], arrayStr[i+1])) {
						if(arrayStr[i].compareTo(arrayStr[i+1].substring(arrayStr[i].length())) > 0) {
							String temp = arrayStr[i];
							arrayStr[i] = arrayStr[i+1];
							arrayStr[i+1] = temp;
						}
					}
					result = result + arrayStr[i];
				}
				
				return result;
			}
		} else {
			System.out.println("array is null!");
			return null;
		}
	}
	/**
	 * 2-String[] 排序，冒泡
	 * @param array
	 */
	public static void sortStrArray(String[] array) {
		if(array != null) {
			String temp;
			int len = array.length;
			boolean changed = false;
			for(int i=0; i<len-1; i++) {
				for(int j=i+1; j<len; j++) {
					if(array[i].compareTo(array[j]) > 0) {
						temp = array[i];
						array[i] = array[j];
						array[j] = temp;
						changed = true;
					}
				}
				if(!changed) {
					break;
				}
			}
		}
	}
	/**
	 * 3-str1是不是str2的前缀
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isPre(String str1, String str2) {
		if(str1 != null && str2 != null) {
			if(str1.length() < str2.length()) {
				if(str1.equals(str2.substring(0, str1.length()))) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void printStringArray(String[] array) {
		if(array != null) {
			for(int i=0; i<array.length; i++) {
				System.out.println(array[i]);
			}
		}
	}
	
	/**
	 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
	 * 输入一个排好序的数组的一个旋转，输出旋转数组的最小元素。
	 * 例如数组{3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为 1。
	 * @param array
	 * @return
	 */
	public static int getMinNum2(int[] array) {
		if(array != null && array.length != 0) {
			int low = 0;
			int high = array.length - 1;
			if(array[low] <= array[high]) {//数组未旋转
				return array[low];
			} else {
				int mid;
				while(low<high) {
					mid = (high - low) / 2 + low;
					if(array[low] < array[mid]) {
						low = mid;
					} else if(array[low] > array[high]) {
						high = mid;
					} else {
						break;
					}
				}
				return array[low+1];
			}
			
		} else {
			System.out.println("array is null!");
			return Integer.MAX_VALUE;
		}
	}
	
	/**
	 * 实现函数double Power(double base,int exponent)，求base的exponent次方。
	 * @param base
	 * @param exponent
	 * @return
	 */
	public boolean isInvalidInput = false;
	public double power(double base, int exponent) {
		if(isEqual(base, 0.0) && exponent<=0) {
			isInvalidInput = true;
			return 0.0;
		}
		int absExp = (exponent >= 0) ? exponent : (-exponent);
		double result = 1.0;
		for(int i=0; i<absExp; i++) {
			result *= base;
		}
		if(exponent < 0) {
			result = 1 / result;
		}
		return result;
	}
	public boolean isEqual(double a, double b) {
		double delta = a-b;
		if(delta < 0.000001 && delta > -0.000001) {
			return true;
		} else {
			return false;
		}
	}
	
	//优化方法:有问题！2,7=32
	public static double powerWithUnsingedExponent(double base, int absExp) { 
	     if(absExp==0) {
	         return 1; 
	     }
	     else if(absExp==1) {
	         return base; 
	     }
	     double result=1.0*base; 
	     for(int i=2;i<=absExp;i=i*2) {
	         result*=result; 
	     }
	     if(absExp%2==1) {//如果指数为奇数，还得再乘一次底数 
	         result*=base; 
	     }
	     return result; 
	} 
	
	/**
	 * 数组中有一个数字出现的次数超过了数组长度的一半，找出这个数字
	 * @param array
	 */
	public static int getTheNum(int[] array) {
		if(array != null && array.length != 0) {
			int i = array.length - 1;
			while(i > 1) {
				int j = i - 1;
				while(j>=0 && array[i] == array[j]) {
					j--;
				}
				if(j == -1) {
					break;
				}
				array[j] = array[i-1];
				i -= 2;
			}
			return array[i];
		} else {
			System.out.println("array is null!");
			return Integer.MAX_VALUE;
		}
	}
	/**
	 * 一个 int 数组，里面数据无任何限制，要求求出所有这样的数 a[i]，
	 * 其左边的数都小于等于它，右边的数都大于等于它。
	 * @param array
	 */
	public static void printResults(int[] array) {
		if(array != null && array.length != 0) {
			int minTemp = array[array.length - 1];
			int maxTemp = array[0];
			int[] temp = new int[array.length];
			for(int i=array.length-1; i>=0; i--) {
				if(array[i] < minTemp) {
					minTemp = array[i];
				}
				temp[i] = minTemp;
			}
			for(int i=0; i<array.length; i++) {
				if(array[i] > maxTemp) {
					maxTemp = array[i];
				}
				if(maxTemp <= temp[i]) {
					System.out.println(array[i]);
				}
			}
		}
	}
	//实现a除以b
	public static int myDivideOperation(int a, int b) throws Exception {
		if(b != 0) {
			int flag = 1;
			if(a < 0) {
				a = -a;
				flag = flag*(-1);
			}
			if(b < 0) {
				b = -b;
				flag = flag*(-1);
			}
			int count = 0;
			while(a >= b) {
				a -= b;
				count++;
			}
			return count*flag;
		} else {
			System.out.println("除数为0！");
			throw new Exception("除数为0！");
		}
	}
	//编程实现两个正整数的除法（不能用除法操作符）
	public static int[] myDivideOperation2(int a, int b) throws Exception {
		if(a > 0 && b > 0) {
			int[] result = new int[]{0, 0};
			if(a < b) {
				result[0] = 0;
				result[1] = a;
			} else {
				while(a >= b) {
					a -= b;
					result[0]++;
				}
				result[1] = a;
			}
			return result;
		} else {
			System.out.println("输入参数错误");
			throw new Exception("输入参数错误");
		}
	}
	
	/**
	 * 编程实现：把十进制数(long型)分别以二进制和十六进制形式输出，不能使用 printf 系列。
	 * @param data
	 */
	public static void printBiAndOx(long data) {
		long shang = data;
		long yushu;
		StringBuffer resultBi = new StringBuffer();
		StringBuffer resultOx = new StringBuffer();
		while(shang != 1) {
			yushu = shang % 2;
			resultBi.insert(0, yushu);
			shang /= 2;
		}
		resultBi.insert(0, shang);
		for(int i=resultBi.length(); i>0; i-=4) {
			int j = i - 4;
			if(j <= 0) {
				j = 0;
			}
			String temp = resultBi.substring(j, i);
			if(temp.equals("0000")) {
				resultOx.insert(0, "0");
			} else if(temp.equals("0001") || temp.equals("1")) {
				resultOx.insert(0, "1");
			} else if(temp.equals("0010") || temp.equals("10")) {
				resultOx.insert(0, "2");
			} else if(temp.equals("0011") || temp.equals("11")) {
				resultOx.insert(0, "3");
			} else if(temp.equals("0100") || temp.equals("100")) {
				resultOx.insert(0, "4");
			} else if(temp.equals("0101") || temp.equals("101")) {
				resultOx.insert(0, "5");
			} else if(temp.equals("0110") || temp.equals("110")) {
				resultOx.insert(0, "6");
			} else if(temp.equals("0111") || temp.equals("111")) {
				resultOx.insert(0, "7");
			} else if(temp.equals("1000")) {
				resultOx.insert(0, "8");
			} else if(temp.equals("1001")) {
				resultOx.insert(0, "9");
			} else if(temp.equals("1010")) {
				resultOx.insert(0, "A");
			} else if(temp.equals("1011")) {
				resultOx.insert(0, "B");
			} else if(temp.equals("1100")) {
				resultOx.insert(0, "C");
			} else if(temp.equals("1101")) {
				resultOx.insert(0, "D");
			} else if(temp.equals("1110")) {
				resultOx.insert(0, "E");
			} else if(temp.equals("1111")) {
				resultOx.insert(0, "F");
			}
		}
		System.out.println(data + "的二进制位:" + resultBi);
		System.out.println(data + "的16进制位:" + resultOx);
	}
	//定义一个类似函数的宏，宏运算的结果来表示大于和小于 
	public static int compare(int a, int b) {
		return (Math.abs(a-b) != (a-b)) ? -1 : (((a-b) == 0) ? 0 : 1);
	}
	
	//指定任意一个正整数 K，请用 A中的元素组成一个大于K 的最小正整数
	public static int getMinNum(int[] array, int data) {
		return getMin(array, intToArray(data), 0, new StringBuffer(), 0);
	}
	private static int getMin(int[] array, int[] kArray, int index, StringBuffer result, int aIndex) {
		if(aIndex < array.length && index < kArray.length) {
			int i;
			for(i=aIndex; i<array.length; i++) {
				if(array[i] >= kArray[index]) {
					break;
				}
			}
			if(i > array.length - 1) {
				return getMin(array, kArray, index, result, i+1);
			} else if(array[i] == kArray[index]) {
				result.append(array[i]);
				return getMin(array, kArray, index+1, result, 0);
			} else if(array[i] > kArray[index]) {
				result.append(array[i]);
			}
		}
		return Integer.parseInt(result.toString());
	}
	private static int[] intToArray(int data) {
		String dataStr = data + "";
		char[] dataArr = dataStr.toCharArray();
		int[] result = new int[dataStr.length()];
		for(int i=0; i<result.length; i++) {
			result[i] = dataArr[i] - '0';
		}
		return result;
	}
	

	//判断一个自然数是否是某个数的平方
	public static boolean isSquare(int n) {
		if(n > 0) {
			boolean result = false;
			int temp = 0;
			for(int i=1; i<n; i++) {
				temp = temp + (i*2 - 1);
				if(temp == n) {
					System.out.println(n + "=" + i + "*" + i);
					result = true;
				}
			}
			return result;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
//		String a = "12";
//		String b = "123";
//		System.out.println(isPre(a, b));
//		System.out.println(a.equals((b.substring(0, a.length()))));
//		System.out.println(a.compareTo(b));
//		System.out.print(b.substring(a.length()));
//		System.out.println("^^^^^^^^^^^^^^");
//		System.out.println(getMinNum(new int[] {32, 321, 322}));
//		System.out.println(getMinNum(new int[] {32, 321, 123, 12, 17, 121}));
//		System.out.println(getMinNum(new int[] {12, 12120, 1212}));
//		System.out.println(getMinNum2(new int[] {5,6,1,2,3,4}));
//		NumberOperation test = new NumberOperation();
//		double result = test.power(4, 0);
//		System.out.println(test.isInvalidInput + ":" + result);
//		System.out.println(powerWithUnsingedExponent(2,8));
//		System.out.println(getTheNum(new int[]{3,3,3,3,3}));
//		printResults(new int[]{7, 10, 2, 6, 19, 22, 32});
//		printResults(new int[]{3,3,3,3,3});
//		int a = 1;
//		int b = 2;
//		try {
//			int[] result = myDivideOperation2(a, b);
//			System.out.println("商=" + result[0] + ",余数=" + result[1]);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		printBiAndOx(16L);
		
//		System.out.println(compare(-6,-7));
		
//		System.out.println(getMinNum(new int[]{0, 2}, 22));
		
		System.out.println(isSquare(121));
		
	}

}
