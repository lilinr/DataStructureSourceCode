package DataStructureTest;
/**
 * ����һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䡣
 * �����е����Կո��������Ϊ������������ź���ͨ��ĸһ������ 
 * ��������I am a student.�������student. a am I��
 * @author raolilin-2013.5.1
 *
 */
public class ReversalWords {
	/**
	 * 1-��תһ���ַ����������ַ�
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
	 * 2-��ת����˳��
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
		System.out.println("��תǰ");
		System.out.println(str);
		System.out.println("��ת��");
		str = reversalWords(str);
		System.out.println(str);
	}

}
