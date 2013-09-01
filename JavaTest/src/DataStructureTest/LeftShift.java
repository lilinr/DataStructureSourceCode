package DataStructureTest;
/**
 * ×óÐý×ª×Ö·û´®
 * @author raolilin-2013.5.11
 *
 */
public class LeftShift {
	/**
	 * 1-×óÐý×ª×Ö·û´®
	 * @param str
	 * @param k
	 */
	public static void leftShift(char[] strChar, int k) {
		if(strChar != null && strChar.length != 0) {
			k = (k + strChar.length) % strChar.length;
			char temp;
			for(int i=0; i<k/2; i++) {
				temp = strChar[i];
				strChar[i] = strChar[k-1-i];
				strChar[k-1-i] = temp;
			}
			for(int i=k; i<(k+strChar.length)/2; i++) {
				temp = strChar[i];
				strChar[i] = strChar[k+strChar.length-1-i];
				strChar[k+strChar.length-1-i] = temp;
			}
			for(int i=0; i<strChar.length/2; i++) {
				temp = strChar[i];
				strChar[i] = strChar[strChar.length-1-i];
				strChar[strChar.length-1-i] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "abcdefghi";
		char[] strChar = str.toCharArray();
		int n = 8;
		leftShift(strChar, n);
		String newStr = new String(strChar);
		System.out.println(str + "×óÒÆ" + n + "Î»ºóÎª" + newStr);
	}

}
