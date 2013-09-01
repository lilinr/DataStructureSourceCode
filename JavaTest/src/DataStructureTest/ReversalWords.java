package DataStructureTest;
/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 句子中单词以空格符隔开。为简单起见，标点符号和普通字母一样处理。 
 * 例如输入I am a student.，则输出student. a am I。
 * @author raolilin-2013.5.1
 *
 */
public class ReversalWords {
	/**
	 * 1-翻转一个字符串的所有字符
	 * @param str
	 * @return
	 */
	public static String reversal(String str) {
		if(null == str || str.length() == 0) {
			return null;
		} else {
			char[] results = str.toCharArray();
			char temp;
			for(int i=0; i<results.length/2; i++) {
				temp = results[i];
				results[i] = results[results.length-i-1];
				results[results.length-i-1] = temp;
			}
			return new String(results);
		}
	}
	
	/**
	 * 2-翻转单词顺序
	 * @param str
	 * @return
	 */
	public static String reversalWords(String str) {
		if(null == str || str.length() == 0) {
			return null;
		} else {
			str = reversal(str);
			String[] strArray = str.split(" ");
			StringBuffer result = new StringBuffer();
			for(int i=0; i<strArray.length; i++) {
				strArray[i] = reversal(strArray[i]);
				result.append(strArray[i]);
				if(i != str.length()-1) {
					result.append(" ");
				}
			}
			return new String(result);
		}
	}
	
	public static void main(String[] args) {
		String str = "I am very happy to go to school!";
		System.out.println("翻转前");
		System.out.println(str);
		System.out.println("翻转后");
		str = reversalWords(str);
		System.out.println(str);
	}

}
