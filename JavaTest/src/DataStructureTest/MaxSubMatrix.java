package DataStructureTest;

/**
 * 求一个矩阵中最大的二维矩阵(元素和最大)
 * 
 * @author raolilin-2013.5.10
 * 
 */
public class MaxSubMatrix {
	/**
	 * 1-获取最大二维数组
	 * @param matrix
	 * @return
	 */
	public static int[][] getSubMatrix(int[][] matrix) {
		if(matrix != null) {
			int[][] result = new int[2][2];
			int row = matrix.length;
			int col = matrix[0].length;
			int sum = 0;
			int temp = 0;
			int m = 0;
			int n = 0;
			for(int i=0; i<row-1; i++) {
				for(int j=0; j<col-1; j++) {
					temp = matrix[i][j] + matrix[i][j+1] + matrix[i+1][j] + matrix[i+1][j+1];
					if(temp >= sum) {
						sum = temp;
						m = i;
						n = j;
					}
				}
			}
			result[0][0] = matrix[m][n];
			result[0][1] = matrix[m][n+1];
			result[1][0] = matrix[m+1][n];
			result[1][1] = matrix[m+1][n+1];
			return result;
		} else {
			System.out.println("matrix is null!");
			return null;
		}
	}
	/**
	 * 2-print matrix
	 * @param matrix
	 */
	public static void printMatrix(int[][] matrix) {
		if(matrix != null) {
			System.out.println("---------matrix is-----------------");
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
	
	public static void main(String[] args) {
		int[][] a = { { 2, 3, 4 }, { 1, 3, 3 }, { 1, 4, 6 }, { 1, 4, 8 },
				{ 2, 3, 2 } };
		printMatrix(a);
		int[][] res = getSubMatrix(a);
		printMatrix(res);
		
		int[][] b = { { 1, 2, 0, 3, 4 }, { 2, 3, 4, 5, 1 }, { 1, 1, 5, 3, 0 } };
		printMatrix(b);
		res = getSubMatrix(b);
		printMatrix(res);
		
	}

}
