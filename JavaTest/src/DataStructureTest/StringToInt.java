package DataStructureTest;
/**
 * ����һ����ʾ�������ַ������Ѹ��ַ���ת�������������
 * @author raolilin-2013.5.12
 *
 */
public class StringToInt {
	/**
	 * 1-stringToInt-��������
	 * @param intStr
	 * @return
	 */
	public static int stringToInt(String intStr) {
		if(intStr != null && !intStr.trim().equals("")) {
			char[] intArray = intStr.toCharArray();
			int result = 0;
			int factor = 1;
			for(int i=intArray.length-1; i>=0; i--) {
				if(intArray[i]<48 || intArray[i]>57) {
					System.out.println("intStr is not correct!");
					return -1;
				} else {
					result = (intArray[i] - 48)*factor + result;
					factor*=10;
				}
			}
			return result;
		} else {
			System.out.println("intStr is null!");
			return -1;
		}
	}
	
	public boolean hasResult;
	public int strIoInt2(String intStr) {
		if(intStr != null && !intStr.trim().equals("")) {
			char[] intArray = intStr.toCharArray();
			int result = 0;
			int sign = 1;
			if(intArray[0] == '-') {
				sign = -1;
			} else if(intArray[0] == '+') {
				sign = 1;
			} else if(intArray[0]>='0' && intArray[0]<'9') {
				result = intArray[0] - '0';
			} else {
				hasResult = false;
				System.out.println("intStr is not correct!");
				return 0;
			}
			for(int i=1; i<intArray.length; i++) {
				if(intArray[i]<'0' || intArray[i]>'9') {
					hasResult = false;
					System.out.println("intStr is not correct!");
					return 0;
				} else {
					result = (intArray[i] - '0') + result*10;
					if(result < 0) {
						hasResult = false;
						System.out.println("intStr����ֵ�Ѿ�����int�ı�ʾ��Χ!");
						return 0;
					}
				}
			}
			hasResult = true;
			return result*sign;
		} else {
			hasResult = false;
			System.out.println("intStr is null!");
			return 0;
		}
	}
	
	public static void main(String[] args) {
		String intStr = "+111111111111111234445511111111111";
//		System.out.println("'" + intStr + "'" + "ת��Ϊ����λ" + stringToInt(intStr));
		StringToInt test = new StringToInt();
		int result = test.strIoInt2(intStr);
		if(test.hasResult) {
			System.out.println("'" + intStr + "'" + "ת��Ϊ����λ" + result);
		} 
		
	}

}
