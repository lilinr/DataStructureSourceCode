package DataStructureTest;

/**
 * 
 * @author raolilin-2013.5.12
 * 
 */
public class ArrayOperation {
	/**
	 * 1-输入一个整数数组，调整数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
	 * 
	 * @param array
	 */
	public static void adjustArray(int[] array) {
		if (array != null && array.length != 0) {
			int temp;
			int low = 0;
			int high = array.length - 1;
			while (low < high) {
				while (low < high && (array[high] % 2 == 0)) {// 通常 (n & 1) ==
																// 0; 比 (n % 2)
																// == 0; 要快!
					high--;
				}
				if (low < high) {
					temp = array[high];
					array[high] = array[low];
					array[low] = temp;
					low++;
				}
				while (low < high && (array[low] % 2 == 1)) {
					low++;
				}
				if (low < high) {
					temp = array[high];
					array[high] = array[low];
					array[low] = temp;
					high--;
				}
			}
		} else {
			System.out.println("array is null!");
		}
	}

	/**
	 * 1-改进
	 * 
	 * @param array
	 */
	public static void adjustArray2(int[] array) {
		if (array != null && array.length != 0) {
			int temp;
			int low = 0;
			int high = array.length - 1;
			while (low < high) {
				while (low < high && (array[high] % 2 == 0)) {// 通常 (n & 1) ==
																// 0; 比 (n % 2)
																// == 0; 要快!
					high--;
				}
				while (low < high && (array[low] % 2 == 1)) {
					low++;
				}
				if (low < high) {
					temp = array[high];
					array[high] = array[low];
					array[low] = temp;
//					high--;
//					low++;
				}
			}
		} else {
			System.out.println("array is null!");
		}
	}

	/**
	 * 2-一个数组中除了两个数字之外，
	 * 其余数字均出现了两次(或偶数次)。
	 * 请写出程序查找出这两个只出现一次的数字，
	 * 要求时间复杂度为 O(n)，空间复杂度为 O(1)。
	 * @param array
	 * @return
	 */
	public static int[] getTheTwoNumber(int[] array) {
		if (array != null && array.length > 1) {
			int num1 = 0;
			int num2 = 0;
			int ansXor = 0;
			for (int i = 0; i < array.length; i++) {
				ansXor ^= array[i]; // 异或
			}
			int pos = findFirstOne(ansXor);
			for (int i = 0; i < array.length; i++) {
				if (testBit(array[i], pos)) {
					num1 ^= array[i];
				} else {
					num2 ^= array[i];
				}
			}
			return new int[] { num1, num2 };
		} else {
			System.out.println("array is not correct!");
			return null;
		}
	}

	public static int findFirstOne(int value) { // 取二进制中首个为1的位置
		int pos = 1;
		while ((value & 1) != 1) {
			value = value >> 1;
			pos++;
		}
		return pos;
	}

	public static boolean testBit(int value, int pos) { // 测试某位置是否为1
		return ((value >> pos) & 1) != 0;
	}

	
	/**
	 * 用递归的方法判断整数组 a[N]是不是升序排列 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean isAscArray(int[] array, int start, int end) {
		if(array != null && array.length != 0 && start >=0 && start < end && end < array.length) {
			if(start + 1 == end && end == array.length-1) {
				return array[start] < array[end];
			} else {
				return array[start] < array[start+1] && isAscArray(array, start+1, end);
			}
		} else {
			System.out.println("inputs are incorrect!");
			return false;
		}
	}
	
	
	/**
	 * 0-printArray
	 * 
	 * @param array
	 */
	public static void printArray(int[] array) {
		if (array != null && array.length != 0) {
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + ",");
			}
			System.out.println("end");
		} else {
			System.out.println("array is null!");
		}
	}
	/**
	 * 两个数组 a[N]，b[N]，其中 A[N]的各个元素值已知，现给 b[i]赋值，
	 * b[i] = a[0]*a[1]*a[2]...*a[N-1]/a[i]； 
	 * 要求： 
	 * 1.不准用除法运算 
	 * 2.除了循环计数值，a[N],b[N]外，不准再用其他任何变量（包括局部变量，全局变量等） 
	 * 3.满足时间复杂度 O（n），空间复杂度 O（1）。
	 * @param a
	 * @return
	 */
	public static int[] getB(int[] a) {
		if(a != null && a.length != 0) {
			int[] b = new int[a.length];
			b[0] = 1;
			//计算左半边
			for(int i=1; i<a.length; i++) {
				b[i] = b[i-1] * a[i-1];
			}
			//计算右半边
			b[0] = a[a.length-1];
			for(int i=a.length-2; i>0; i--) {
				b[i] *= b[0];
				b[0] *= a[i];
			}
			return b;
		} else {
			System.out.println("array is null!");
			return null;
		}
	}
	/**
	 * 有一个整数数组，请求出两两之差绝对值最小的值，只要得出最小值即可，不需要求出是哪两个数 
	 * @param array
	 * @return
	 */
	public static int getMinAbs(int[] array) {
		if(array != null && array.length != 0) {
			int minAbs = Integer.MAX_VALUE;
			for(int i=0; i<array.length; i++) {
				for(int j=i+1; j<array.length; j++) {
					int temp;
					if(array[i] > array[j]) {
						temp = array[i] - array[j];
					} else {
						temp = array[j] - array[i];
					}
					if(temp < minAbs) {
						minAbs = temp;
					}
				}
			}
			return minAbs;
		} else {
			System.out.println("array is null!");
			return -1;
		}
	}

	//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字 
	public static void printMatrix(int[][] matrix) {
		if(matrix != null) {
			int left = 0;
			int right = matrix[0].length - 1;
			int up = 0;
			int down = matrix.length - 1;
			int i = up;
			int j = left;
			while(left <= right && up <= down) {
				//向右输出,i=up,j=left
				while(j < right) {
					System.out.print(matrix[i][j] + "  ");
					j++;
				}
				up++;
				//向下输出,i=up,j=right
				while(i < down) {
					System.out.print(matrix[i][j] + "  ");
					i++;
				}
				right--;
				//向左输出,i=down,j=right
				while(j > left) {
					System.out.print(matrix[i][j] + "  ");
					j--;
				}
				down--;
				//向上输出,i=down,j=left
				while(i > up) {
					System.out.print(matrix[i][j] + "  ");
					i--;
				}
				left++;
			}
			System.out.println();
		} else {
			System.out.println("matrix is null!");
		}
	}
	public static void printMatrixByIndex(int[][] matrix) {
		if(matrix != null) {
			int row = matrix.length;
			int col = matrix[0].length;
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					System.out.print(matrix[i][j] + "\t");
				}
				System.out.println();
			}
		} else {
			System.out.println("matrix is null!");
		}
	}
	/**
	 * 打印如下形式的矩阵； 
n=5:
1   2   9 10 25
4   3   8 11 24
5   6   7 12 23
16 15 14 13 22
17 18 19 20 21
n=6:
1   2   9 10 25 26
4   3   8 11 24 27
5   6   7 12 23 28
16 15 14 13 22 29
17 18 19 20 21 30
36 35 34 33 32 31
	 * @param n
	 * @return
	 */
	public static int[][] getMatrixByN(int n) {
		if(n > 0) {
			int[][] array = new int[n][n];
			int counter = 1;
			int row = 0;
			int col = 0;
			for(int i=0; i<n; i++) {
				if(i % 2 == 0) {
					while(col <= i) {
						array[row][col] = counter++;
						col++;
					}
					while(row > 0) {
						array[row-1][col-1] = counter++;
						row--;
					}
				} else {
					while(row <= i) {
						array[row][col] = counter++;
						row++;
					}
					while(col > 0) {
						array[row-1][col-1] = counter++;
						col--;
					}
				}
			}
			return array;
		} else {
			return null;
		}
	}
	
	/**
	 * 二维数组中的查找
	 * 在一个二维数组中，每一行都是从左到右递增，每一列都是从上到下递增。
	 * @param array
	 * @param value
	 * @return
	 */
	public static boolean find(int[][] array,int row, int col, int value) {
		boolean ret = false;
		if(null != array && row > 0 && col > 0) {
			int tempRow = 0;
			int tempCol = col - 1;
			while(tempRow < row && tempCol >= 0) {
				int temp = array[tempRow][tempCol];
				if(temp == value) {
					ret = true;
					break;
				} else if(temp < value) {
					++tempRow;
				} else {
					--tempCol;
				}
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		printArray(array);
		adjustArray2(array);
		printArray(array);
		
//		int[] array = {1,2,3,4,5,6,4,3,2,1};
//		int[] result = getTheTwoNumber(array);
//		System.out.println(result[0] + "_" + result[1]);
//		int[] array = { 2, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//		System.out.println(isAscArray(array, 0 , array.length-1));
//		System.out.println(isAscArray(new int[]{ 2, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 0 , array.length-1));
//		System.out.println(getMinAbs(new int[]{1,5,3,99,999,9999,99999,599}));
//		System.out.println((new int[]{}) == null);
//		System.out.println((new int[]{}).length == 0);
		
//		int[][] matrix = {{1,2,3,4,5},{14,15,16,17,6},{13,20,19,18,7},{12,11,10,9,8}};
//		printMatrixByIndex(matrix);
//		printMatrix(matrix);
		
//		printMatrixByIndex(getMatrixByN(10));
		
		/*
		 * 1,2,8,9
		 * 2,4,9,12
		 * 4,7,10,13
		 * 6,8,11,15
		 */
//		int row = 4;
//		int col = 4;
//		int[][] array = {{1,2,8,9}, {2,4,9,12}, {4,7,10,13}, {6,8,11,15}};
//		System.out.println(find(array, row, col, 16));
	}

}
