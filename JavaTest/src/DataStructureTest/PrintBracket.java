package DataStructureTest;
/**
 * 四对括号可以有多少种匹配排列方式
 * @author Administrator
 *
 */
public class PrintBracket {
	public static int counter = 0;
	/**
	 * 1-printBracket
	 * @param left
	 * @param right
	 * @param print
	 */
	public static void printBracket(int left, int right, String print) {
		if(left == 0 && right == 0) {
			System.out.println(print);
			counter++;
		} else if(left == 0 && right > 0) {
			printBracket(left, right-1, print + ")");
		} else if(left >= right && right > 0){
			printBracket(left-1, right, print + "(");
		} else if(left < right && left > 0) {
			printBracket(left-1, right, print + "(");
			printBracket(left, right-1, print + ")");
		} 
	}
	
	public static void main(String[] args) {
		printBracket(4, 4, "");
		System.out.println("总共" + counter + "种");
	}

}
