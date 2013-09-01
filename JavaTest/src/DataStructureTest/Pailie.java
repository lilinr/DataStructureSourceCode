package DataStructureTest;

public class Pailie {
	private static int count = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		System.out.println("pailie(" + s + ",)");
		pailie(s, "");
		System.out.println("共有" + count + "种排列");
		
	}

	public static void pailie(String s, String p) {
		if(null == s || s.length()<1) {
			count++;
			System.out.println(p);
		} else {
			int[] index = new int[s.length()];
			for(int i=0; i<s.length(); i++) {
				index[i] = s.indexOf(s.charAt(i));
			}
			for(int i=0; i<s.length(); i++) {
				if(i == index[i]) {
					System.out.println("pailie(" + s.substring(1) + ","+ p + s.substring(0, 1) + ")");
					pailie(s.substring(1), p + s.substring(0, 1));
				}
				s = s.substring(1) + s.substring(0, 1);//循环移位
			}
		}
	}
}
