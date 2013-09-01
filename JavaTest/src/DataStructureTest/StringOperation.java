package DataStructureTest;

import java.util.Stack;

/**
 * 
 * @author raolilin-2013.5.12
 *
 */
public class StringOperation {
	/**
	 * 1-输入两个字符串，从第一字符串中删除第二个字符串中所有的字符
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static String operateString(String str1, String str2) {
		if(str1 != null && str1.length() != 0) {
			if(str2 == null) {
				return str1;
			} else {
				char[] array = str1.toCharArray();
				for(int i=0; i<array.length; i++) {
					if(str2.indexOf(array[i]) != -1) {
						array[i] = '\n';
					}
				}
				String result = new String(array);
				result = result.replace("\n", "");
				return result;
			}
		} else {
			System.out.println("str1 is null!");
			return null;
		}
	}
	
	/**
	 * 给你一个字符串，找出该字符串中对称的子字符串的最大长度。
	 * @param str
	 * @return
	 */
	public static int getMaxLen(String str) {
		if(str != null && str.length() != 0) {
			int maxLen = 0;
			int tempLen;
			char[] array = str.toCharArray();
			for(int i=0; i<array.length; i++) {
				tempLen = getLen1(i, array);
				if(tempLen > maxLen) {
					maxLen = tempLen;
				}
				tempLen = getLen2(i, array);
				if(tempLen > maxLen) {
					maxLen = tempLen;
				}
			}
			return maxLen;
		} else {
			System.out.println("str is null!");
			return 0;
		}
	}
	public static int getLen1(int index, char[] array) {
		if(array != null && array.length != 0) {
			if(index>=0 && index<array.length) {
				int left = index - 1;
				int right = index + 1;
				while(left>=0 && right<array.length) {
					if(array[left] == array[right]) {
						left--;
						right++;
					} else {
						break;
					}
				}
				return right - left - 1;
			}
		}
		System.out.println("1 inputs are not correct!");
		return 0;
	}
	public static int getLen2(int index, char[] array) {
		if(array != null && array.length != 0) {
			if(index>=0 && index<array.length) {
				if(index<array.length-1 && array[index]==array[index+1]) {

					int left = index - 1;
					int right = index + 2;
					while(left>=0 && right<array.length) {
						if(array[left] == array[right]) {
							left--;
							right++;
						} else {
							break;
						}
					}
					return right - left - 1;
				} else {
					return 1;
				}
			}
		}
		System.out.println("2 inputs are not correct!");
		return 0;
	}
	
	/**
	 * 已知一个字符串，比如 asderwsde,寻找其中的一个子字符串比如 sde 的个数，如果没有返回 0，
	 * 有的话返回子字符串的个数
	 * @param str
	 * @param subStr
	 * @return
	 */
	public static int getSubStrNum(String str, String subStr) {
		if(str != null && subStr != null) {
			char[] strArray = str.toCharArray();
			char[] subStrArray = subStr.toCharArray();
			int counter = 0;
			int i = 0;
			int j;
			while(i < strArray.length) {
				j = i;
				for(int k=0; k<subStrArray.length; k++) {
					
					if(j < strArray.length && strArray[j] == subStrArray[k]) {
						j++;
					} else {
						break;
					}
				}
				if(j-i < subStrArray.length) {
					i++;
				} else {
					counter++;
					i = j + 1;
				}
			}
			return counter;
		} else {
			System.out.println("inputs are null!");
			return 0;
		}
	}
	
	/**
	 * 函数将字符串中的字符'*'移到串的前部分
	 * @param str
	 * @return
	 */
	public static int getNumOfXING(String str) {
		if(str != null && str.length() != 0) {
			int counter = 0;
			char[] strArray = str.toCharArray();
			for(int i=0; i<strArray.length; i++) {
				if(strArray[i] == '*') {
					counter++;
					if(i > 0 && strArray[i-1] != '*') {
						for(int j=i; j>counter-1; j--) {
							strArray[j] = strArray[j-1];
							System.out.println("right shift");
						}
						strArray[counter-1] = '*';
					}
				}
			}
			System.out.println(new String(strArray));
			return counter;
		} else {
			System.out.println("str is null!");
			return -1;
		}
	}
	/**
	 * 删除字符串中的数字并压缩字符串
	 * @param str
	 * @return
	 */
	public static String getString(String str) {
		if(str != null && str.length() != 0) {
			char[] strArray = str.toCharArray();
			int i;
			for(i=0; i<strArray.length; i++) {
				if(strArray[i] >= '0' && strArray[i] <= '9') {
					break;
				}
			}
			if(i < strArray.length) {
				for(int j=i+1; j<strArray.length; j++) {
					if(strArray[j] < '0' || strArray[j] > '9') {
						strArray[i] = strArray[j];
						i++;
					}
				}
			}
			return new String(strArray).substring(0, i);
		} else {
			System.out.println("str is null!");
			return null;
		}
	}
	/**
	 * 给出一个函数来合并两个字符串 A和 B。字符串 A的后几个字节和字符串 B的前几个字节重叠
	 * @param a
	 * @param b
	 * @return
	 */
	public static String getTheResult(String a, String b) {
		if(a == null || b == null || a.length() == 0 || b.length() == 0) {
			System.out.println("inputs are incorrect!");
			return null;
		} else {
			char[] aArr = a.toCharArray();
			char[] bArr = b.toCharArray();
			int aLen = aArr.length;
			int bLen = bArr.length;
			int start = aLen;
			for(int i=0; i<aLen; i++) {
				int k;
				//找到a中与b的第一个字符相同的下标
				for(k = i; k<aLen; k++) {
					if(aArr[k] == bArr[0]) {
						break;
					}
				}
				if(k == aLen) {
					break;//a中不存在与b的第一个字符相同的字符
				}
				int j = 0;
				while(j < bLen && j + k < aLen) {
					if(aArr[j + k] == bArr[j]) {
						j++;
					} else {
						break;
					}
				}
				//找到，输出结果
				if(j+k == aLen) {
					start = start - j;
					break;
				}
			}
			return a.substring(0, start) + b;
		}
	}
	
	//逆置str
	public static String inverseString(String str) {
		if(str != null && str.length() != 0) {
			char[] strArray = str.toCharArray();
			for(int i=0; i<strArray.length/2; i++) {
				strArray[i] ^= strArray[strArray.length-1-i];
				strArray[strArray.length-1-i] ^= strArray[i];
				strArray[i] ^= strArray[strArray.length-1-i];
			}
			return new String(strArray);
		} else {
			System.out.println("str is null!");
			return null;
		}
	}
	/**
	 * 找出两个字符串中最大公共子字符串 , 如"abccade","dgcadde"的最大子串为"cad"
	 * @param a
	 * @param b
	 * @return
	 */
	public static String getMaxSub(String a, String b) {
		if(a != null && b != null & a.length() != 0 && b.length() != 0) {
			int start = 0;
			int end = 0;
			char[] aArr = a.toCharArray();
			char[] bArr = b.toCharArray();
			for(int i=0; i<aArr.length; i++) {
				int tempStart = i;
				int tempEnd = i + 1;
				int j = 0;
				while(j < bArr.length) {
					int temp = j;
					for(j=temp; j<bArr.length; j++) {
						if(aArr[i] == bArr[j]) {
							j++;
							break;
						}
					}
					int k = j;
					while(k < bArr.length && tempEnd < aArr.length) {
						if(aArr[tempEnd] == bArr[k]) {
							tempEnd++;
							k++;
						} else {
							break;
						}
					}
					if(tempEnd - tempStart > end - start) {
						start = tempStart;
						end = tempEnd;
					}
				}
			}
			return a.substring(start, end);
		} else {
			System.out.println("inputs are null!");
			return null;
		}
	}
	//找出s2 字符串在s1字符串中第一次出现的位置（不包括s2的串结束符） 
	public static int strstr(String str1, String str2) {
		int result = -1;
		if(str1 != null && str2 != null) {
			char[] arr1 = str1.toCharArray();
			char[] arr2 = str2.toCharArray();
			int i;
			for(i=0; i<arr1.length; i++) {
				int j;
				for(j=0; j<arr2.length&&i+j<arr1.length; j++) {
					if(arr1[i+j] != arr2[j]) {
						break;
					}
				}
				if(j == arr2.length) {
					break;
				}
			}
			if(i < arr1.length) {
				result = i;
			}
		}
		return result;
	}
	//比较字符串 s1 和s2 的前 n 个字符 
	//返回结果：如果前 n 字节完全相等，返回值就=0；在前n 字节比较过程中，如果出现 s1[n]与	s2[n]不等，则返回(s1[n]-s2[n]) 
	public static int strncmp(String str1, String str2, int n) {
		if(n < 0 || str1 == null || str2 == null) {
			return 0;
		} else {
			char[] arr1 = str1.toCharArray();
			char[] arr2 = str2.toCharArray();
			int i = 0;
			while(i<n && i<arr1.length && i<arr2.length) {
				if(arr1[i] != arr2[i]) {
					break;
				} else {
					i++;
				}
			}
			if(i == n || (i == arr1.length && i == arr2.length)) {
				return 0;
			} else if(i == arr1.length && i < arr2.length) {
				return arr2[i];
			} else {
				return arr1[i];
			}
		}
	}
	
	/**
	 * 表达式求值，一个字符串只由'+','-',和‘0’-‘9’组成，并且'+','-'只作为二元运算符。
	 * @param str
	 * @param result
	 * @return
	 */
	public static boolean calculate(String str, Value result) {
		if(str == null || result == null || str.length() == 0) {
			return false;
		} else {
			boolean flag = true;
			char[] arr = str.toCharArray();
			int len = arr.length - 1;
			Stack<Integer> opNum = new Stack<Integer>();
			Stack<Character> opType = new Stack<Character>();
			while(len >= 0) {
				if(arr[len] > '9' && arr[len] < '0' && arr[len] != '+' && arr[len] != '-') {
					flag = false;
					break;
				} else {
					if(arr[len] == '+' || arr[len] == '-') {
						opType.push(arr[len]);
						len--;
					} else {
						int tempNum = arr[len] - '0';
						int exp = 1;
						int i = len - 1;
						while(i >= 0 && arr[i] != '+' && arr[i] != '-') {
							exp *= 10;
							tempNum += (arr[i] - '0')*exp;
							i--;
							
						}
						len = i;
						opNum.push(tempNum);
					}
				}
			}
			if(flag) {
				if(opNum.size() != opType.size() + 1) {
					flag = false;
				}
			}
			if(flag) {
				int a;
				int b;
				char op;
				int res;
				while(!opType.isEmpty()) {
					a = opNum.pop();
					b = opNum.pop();
					op = opType.pop();
					if(op == '+') {
						res = a + b;
					} else {
						res = a - b;
					}
					opNum.push(res);
				}
				result.value = opNum.pop();
			}
			return flag;
		}
	}
	
	//给定一个字串X，求它最长字串S，使得S=SR，SR为S的反序，即如果S=abc，则SR=cba例子：X=abccba，则输出S=abccba
	public static String getHuiWen(String str) {
		if(str != null && str.length() != 0) {
			//不会！
			return str;
		} else {
			return null;
		}
	}
	
	public static boolean isHuiWen(String str) {
		if(str != null && str.length() != 0) {
			boolean result = false;
			char[] arr = str.toCharArray();
			int i;
			for(i=0; i<arr.length/2; i++) {
				if(arr[i] != arr[arr.length - i -1]) {
					break;
				}
			}
			if(i == arr.length) {
				result = true;
			}
			return result;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
//		String str1 = "They are students.";
//		String str2 = "aeiou";
//		System.out.println(str1);
//		System.out.println(str2);
//		System.out.println(operateString(str1, str2));
		
		
//		String str = "1234543212345678987654321";
//		System.out.println(str + "中对称的子字符串的最大长度为" + getMaxLen(str));
//		String str1 = "sderwsde";
//		String str2 = "sde";
//		System.out.println(getSubStrNum(str1, str2));
		
//		System.out.println(getNumOfXING(""));
//		System.out.println(getNumOfXING("******"));
//		System.out.println(getNumOfXING("a*s**d*f*d*f"));
//		System.out.println(getString("dfsha1kh2ga3hd"));
//		String str = "dfafsdfadsf";
//		System.out.println(str + "---inverse:" + inverseString(str));
		
//		System.out.println(getTheResult("abcgh", "ghabc"));
		
		
//		System.out.println(getMaxSub("abcbbbbb", "ghabcbbbfbbbbbbb"));
		
//		System.out.println(strstr("asdfghjk","ghjkl"));
//		System.out.println(strncmp("asdf","asdf",6));
//		System.out.println('h' + 0);
		
		Value result = new Value();
		String str = "1+1+2+2+3+3-3-22-11";
		System.out.println(calculate(str, result));
		System.out.println(result.value);
	}

}
class Value {
	public int value;
}