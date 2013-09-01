package DataStructureTest;
/**
 * 在字符串中找出连续最长的数字串
 * @author raolilin-2013.5.11
 *
 */
public class MaxSubStr {
	/**
	 * 1-getMaxSubStr
	 * @param str
	 * @return
	 */
	public static String getMaxSubStr(String str) {
		if(str != null && !str.trim().equals("")) {
			int start = 0;
			int end = 0;
			char[] strChar = str.toCharArray();
			int i = 0;
			int j;
			while(i < strChar.length) {
				for(j=i+1; j<strChar.length; j++) {
					if(strChar[j-1]+1 != strChar[j]) {
						break;
					}
				}
				if((j-i) > (end-start)) {
					start = i;
					end = j;
				}
				i = j;
			}
			return str.substring(start, end);
		} else {
			System.out.println("str is null!");
			return null;
		}
	}
	
	/**
	 * 2-getMaxNumSubStr
	 * @param str
	 * @return
	 */
	public static String getMaxNumSubStr(String str) {
		if(str != null && !str.trim().equals("")) {
			int start = 0;
			int end = 0;
			char[] strChar = str.toCharArray();
			int i = 0;
			int j;
			while(i < strChar.length) {
				if(strChar[i] >= '0' && strChar[i] <= '9') {
					for(j=i+1; j<strChar.length; j++) {
						if(strChar[j-1]+1 != strChar[j]) {
							break;
						}
					}
					if((j-i) > (end-start)) {
						start = i;
						end = j;
					}
					i = j;
				} else {
					i++;
				}
			}
			return str.substring(start, end);
		} else {
			System.out.println("str is null!");
			return null;
		}
	}
	
	/**
	 * 2-getMaxNumSubStr2,数字子串不是连续的
	 * @param str
	 * @return
	 */
	public static String getMaxNumSubStr2(String str) {
		if(str != null && !str.trim().equals("")) {
			int start = 0;
			int end = 0;
			char[] strChar = str.toCharArray();
			int i = 0;
			int j;
			while(i < strChar.length) {
				if(strChar[i] >= '0' && strChar[i] <= '9') {
					for(j=i+1; j<strChar.length; j++) {
						if(strChar[j] < '0' || strChar[j] > '9') {
							break;
						}
					}
					if((j-i) > (end-start)) {
						start = i;
						end = j;
					}
					i = j;
				} else {
					i++;
				}
			}
			return str.substring(start, end);
		} else {
			System.out.println("str is null!");
			return null;
		}
	}
	
	public static void main(String[] args) {
		String str = "11111111111111111111111111111ABCDEFGHIJKLMNabcdefg123456789";
//		String str ="abc123def123456ee123456789dd";
		String maxSubStr = getMaxSubStr(str);
		String maxNumSubStr = getMaxNumSubStr(str);
		String maxNumSubStr2 = getMaxNumSubStr2(str);
		System.out.println(str + "的最大子串为:" + maxSubStr + ",长度为" + maxSubStr.length());
		System.out.println(str + "的最大数字子串为:" + maxNumSubStr + ",长度为" + maxNumSubStr.length());
		System.out.println(str + "的最大数字子串(不连续)为:" + maxNumSubStr2 + ",长度为" + maxNumSubStr2.length());
	}

}
