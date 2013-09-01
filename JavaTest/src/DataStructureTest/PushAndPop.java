package DataStructureTest;
/**
 * 栈的 push、pop序列[数据结构]
 * @author Administrator
 *
 */
public class PushAndPop {
	/**
	 * 1-判断pop是否是push的pop序列
	 * @param push
	 * @param pop
	 * @return
	 */
	public static boolean judgePushPop(String push, String pop) {
		if(push != null && pop != null && !push.trim().equals("") && !pop.trim().equals("") && push.length() == pop.length()) {
			boolean result = true;
			char[] popChar = pop.toCharArray();
			int[] index = new int[push.length()];
			for(int i=0; i<index.length; i++) {
				index[i] = push.indexOf(popChar[i]);
			}
			int j = 0;
			while(j < pop.length()-1 && result) {
				if(index[j+1] > index[j]) {
					j++;
				} else {
					int k;
					for(k=j+1; k<pop.length()-1; k++) {
						if(index[k+1] > index[k]) {
							if(index[k+1] < index[j]) {
								result = false;
							}
							break;
						}
					}
//					if(k == pop.length() -1) {
//						break;
//					}
					j = k + 1;
				}
			}
			
			return result;
		} else {
			System.out.println("inputs are not correct!");
			return false;
		}
	}
	
	public static void main(String[] args) {
		String push = "12345";
//		String pop = "43521";
		String pop = "43512";
//		String pop = "12345";
		System.out.println("push=" + push);
		System.out.println("pop=" + pop);
		System.out.println(judgePushPop(push, pop));
	}

}
