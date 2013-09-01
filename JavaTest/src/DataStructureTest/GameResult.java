package DataStructureTest;
/**
 * n 支队伍比赛
 * @author raoliln-2013..5.9
 *
 */
public class GameResult {
	/**
	 * 1-设置实力
	 * @param w
	 * @param sort
	 */
	public static int[][] getW() {
		int[][] w ={{0,0,2,3},{0,1,2,3},{2,2,2,2},{3,3,2,3}}; 
		return w;
	}
	/**
	 * 2-设置比赛顺序
	 * @param order
	 */
	public static int[] getOrder() {
		int[] order={2,3,0,1}; 
		return order;
	}
	/**
	 * 3-返回比赛结果
	 * @param w
	 * @param order
	 * @return
	 */
	public static int[] getResult(int[][] w, int[] order) {
		if(w != null && order != null) {
			int length = order.length;
			int[] result = new int[length];
			int[] temp = new int[length];
			for(int i=0; i<length; i++) {
				temp[i] = order[i];
			}
			int d = (length + 1) / 2;
			while(d > 1) {
				for(int i=0,j=0; j<d; i+=2,j++) {
					if(i < length - 1) {
						int n = temp[i];
						int m = temp[i+1];
						if(n == w[n][m]) {
							result[j] = n;
							result[length-1-j] = m;
						} else {
							result[j] = m;
							result[length-1-j] = n;
						}
					} else {
						result[j] = temp[i];
					}
				}
				for(int i=0; i<d; i++) {
					temp[i] = result[i];
				}
				length = d;
				d = (length + 1) / 2;
			} 
			return result;
			
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		int[] order = getOrder();
		int[][] w = getW();
		int[] result = getResult(w, order);
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i] + "--");
		}
	}

}
