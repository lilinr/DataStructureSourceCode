package DataStructureTest;
/**
 * ��һ���ַ������ҵ���һ��ֻ����һ�ε��ַ��������� abaccdeff������� b��
 * @author raolilin-2013.5.3
 *
 */
public class OnceChar {
	/**
	 * 1-��һ���ַ������ҵ���һ��ֻ����һ�ε��ַ����±��
	 * @param str
	 * @return
	 */
	private static int getOnceCharIndex(String str) {
		if(str != null && !str.trim().equals("")) {
			char[] array = str.toCharArray();
			int i;
			int j;
			for(i=0; i<array.length; i++) {
				for(j=0; j<array.length; j++) {
					if(i != j && array[i] == array[j]) {
						break;
					}
				}
				if(j == array.length) {
					break;
				}
			}
			if(i < array.length) {
				return i;
			} else {
				return -1;
			}
		} else {
			System.out.println("�ַ���Ϊ�գ�");
			return -1;
		}
	}
	/**
	 * 2-��һ���ַ������ҵ���һ��ֻ����һ�ε��ַ�
	 * @param str
	 * @return
	 */
	public static char getOnceChar(String str) {
		int index = getOnceCharIndex(str);
		if(index != -1) {
			return str.charAt(index);
		} else {
			System.out.println("û��������ַ���");
			return '0';//�����ַ�'0'�Ǳ���
		}
	}
	/**
	 * 3-��һ���ַ������ҵ���һ��ֻ����һ�ε��ַ�
	 * @param str
	 * @return
	 */
	public static char getOnceChar2(String str) {
		if(str != null && !str.trim().equals("")) {
			int[] count = new int[256];
			for(int i=0; i<count.length; i++) {
				count[i] = 0;
			}
			char[] array = str.toCharArray();
			for(int i=0; i<array.length; i++) {
				count[array[i]]++;
			}
			int i;
			for(i=0; i<count.length; i++) {
				if(count[i] == 1) {
					break;
				}
			}
			if(i < count.length) {
				return (char)i;
			} else {
				System.out.println("û��������ַ���");
				return '0';//�����ַ�'0'�Ǳ���
			}
			
		} else {
			System.out.println("�ַ���Ϊ�գ�");
			return '0';//�����ַ�'0'�Ǳ���
		}
	}
	
	public static void main(String[] args) {
		String str = "abbbcccddefg";
		System.out.println(str + "�ĵ�һ��ֻ����һ�ε��ַ�Ϊ��" + getOnceChar(str));
		System.out.println(str + "�ĵ�һ��ֻ����һ�ε��ַ�Ϊ��" + getOnceChar2(str));
	}

}
