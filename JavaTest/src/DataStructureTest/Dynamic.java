package DataStructureTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态规划
 * @author raolilin-2013.5.29
 *
 */
public class Dynamic {
	//找硬币
	public static void printLeastCoin(int[] coin, int m) {
		if(coin != null && coin.length != 0 && m > 0) {
			int[] c = new int[m+1];
			int[] result = new int[m+1];
			for(int i=0; i<=m; i++) {
				c[i] = Integer.MAX_VALUE - 1;
				result[i] = Integer.MAX_VALUE;
			}
			for(int i=0; i<coin.length; i++) {
				int k = coin[i];
				for(int j=1; j<=m; j++) {
					if(j == k) {
						c[j] = 1;
						result[j] = k;
					} else if(j > k) {
						if(c[j-k] + 1 < c[j]) {
							c[j] = c[j-k] + 1;
							result[j] = k;
						}
					}
				}
			}
			int resultM= (c[m] != Integer.MAX_VALUE-1) ? c[m] : 0;
			System.out.println("要找" + m + "值的最少硬币个数为" + resultM + "个硬币，如下:");
			printResult(result, m);
		}
	}
	//找硬币
	public static void printLeastCoin2(int[] coin, int m) {
		if(coin != null && coin.length != 0 && m > 0) {
			int[] c = new int[m+1];
			int[] result = new int[m+1];
			for(int i=0; i<=m; i++) {
				c[i] = 0;
				result[i] = Integer.MAX_VALUE;
			}
			for(int i=0; i<coin.length; i++) {
				int k = coin[i];
				for(int j=1; j<=m; j++) {
					if(j == k) {
						c[j] = 1;
						result[j] = k;
					} else if(j > k) {
						if(c[j] == 0 && c[j-k] != 0) {
							c[j] = c[j-k] + 1;
							result[j] = k;
						} else if(c[j-k] != 0) {
							if(c[j-k] + 1 < c[j]) {
								c[j] = c[j-k] + 1;
								result[j] = k;
							}
						}
					}
				}
			}
			System.out.println("要找" + m + "值的最少硬币个数为" + c[m] + "个硬币，如下:");
			printResult(result, m);
		}
	}
	//找硬币
	public static void printResult(int[] result, int k) {
		if(result != null && result.length != 0 && k>0) {
			if(k == result[k]) {
				System.out.print(result[k] + "  ");
			} else if(k > result[k]) {
				printResult(result, result[k]);
				printResult(result, k - result[k]);
			}
		}
	}
	
	//石子合并
	public static void printStone(int[] number) {
		if(number != null && number.length != 0) {
			int n = number.length;
			int[][] sMin = new int[n][n];
			int[][] sMax = new int[n][n];
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					sMin[i][j] = 0;
					sMax[i][j] = 0;
				}
			}
			for(int step=2; step<=n; step++) {
				for(int i=0; i<n; i++) {
					for(int j=1; j<step; j++) {
						int t = (i + j) % (n);
						if(sMin[i][step-1] == 0 || sMin[i][j-1] + sMin[t][step-j-1] + sum(number, i, step) < sMin[i][step-1]) {
							sMin[i][step-1] = sMin[i][j-1] + sMin[t][step-j-1] + sum(number, i, step);
							System.out.println("sMin[" + i + "][" + (step-1) + "] = sMin[" + i + "][" + (j-1) + "] + sMin[" + t + "][" + (step-j) + "] + " + sum(number, i, step));
						} 
						if(sMax[i][step-1] == 0 || sMax[i][j-1] + sMax[t][step-j-1] + sum(number, i, step) > sMax[i][step-1]) {
							sMax[i][step-1] = sMax[i][j-1] + sMax[t][step-j-1] + sum(number, i, step);
						} 
					}
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(sMin[i][j] + "  ");
				}
				System.out.println();
			}
			
			for(int i=0; i<n; i++) {
				if(sMin[i][n-1] < min) {
					min = sMin[i][n-1];
				}
				if(sMax[i][n-1] > max) {
					max = sMax[i][n-1];
				}
			}
			System.out.println("min:" + min);
			System.out.println("max:" + max);
		}
	}
	//石子合并
	public static int sum(int[] number, int i, int j) {
		if(number != null && number.length != 0 && i>=0 && i<number.length && j>0 && j<=number.length) {
			int sum = 0;
			if(i+j <= number.length) {
				for(int k=i; k<i+j; k++) {
					sum += number[k];
				}
			} else {
				int t = (i+j) % (number.length);
				for(int k=0; k<t; k++) {
					sum += number[k]; 
				}
				for(int k=i; k<number.length; k++) {
					sum += number[k];
				}
			}
			return sum;
		} else {
			return -1;
		}
	}
	
	//最长公共子序列
	public static void findMaxSubString(String a, String b) {
		if(a == null || b == null || a.length() ==0 || b.length() == 0) {
			System.out.println("a or b is null!");
		} else {
			int lenA = a.length();
			int lenB = b.length();
			char[] arrA = a.toCharArray();
			char[] arrB = b.toCharArray();
			int[][] c = new int[lenA][lenB];
			char[][] direction = new char[lenA][lenB];//'L'-Left 'U'-Up '0'-LeftUp
			for(int i=0; i<lenA; i++) {
				for(int j=0; j<lenB; j++) {
					if(i == 0 || j == 0) {
						if(arrA[i] == arrB[j]) {
							c[i][j] = 1;
							direction[i][j] = '0';
						} else {
							direction[i][j] = '0';
							if(i > 0) {
								c[i][j] = c[i-1][j];
								direction[i][j] = 'U';
							}
							if(j > 0) {
								c[i][j] = c[i][j-1];
								direction[i][j] = 'L';
							}
						}
					} else {
						if(arrA[i] == arrB[j]) {
							c[i][j] = c[i-1][j-1] + 1;
							direction[i][j] = '0';
						} else {
							if(c[i-1][j] > c[i][j-1]) {
								c[i][j] = c[i-1][j];
								direction[i][j] = 'U';
							} else {
								c[i][j] = c[i][j-1];
								direction[i][j] = 'L';
							}
						}
					}
				}
			}
			System.out.println(a + "与" + b + "的最长公共子序列长度为" + c[lenA-1][lenB-1]);
			List<Character> result = new ArrayList<Character> ();
			while(lenA > 0 && lenB > 0) {
				if(direction[lenA-1][lenB-1] == '0') {
					result.add(arrA[lenA-1]);
					lenA--;
					lenB--;
				} else if(direction[lenA-1][lenB-1] == 'L') {
					lenB--;
				} else if(direction[lenA-1][lenB-1] == 'U') {
					lenA--;
				}
			}
			System.out.print(a + "与" + b + "的最长公共子序列长度为:");
			for(int i=result.size()-1; i>=0; i--) {
				System.out.print(result.get(i));
			}
			System.out.println();
		}
	}
	
	
	
	public static void main(String[] args) {
//		int[] coin = {1, 2, 5};
//		printLeastCoin(coin, 20);
		
//		int[] number = {4, 4, 5, 9};
//		printStone(number);
//		System.out.println(sum(number, 5 ,2));
		
		findMaxSubString("aabbccdd", "abcde");
	}

}
