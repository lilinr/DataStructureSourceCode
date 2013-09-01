package DataStructureTest;

import java.util.Stack;

/**
 * 
 * @author raolilin-2013.5.14
 *
 */
public class StackOperation {
	
	/**
	 * 1-用递归方法颠倒一个栈
	 * @param stack
	 */
	public static void inverseStack(Stack<Integer> stack) {
		if(!stack.empty()) {
			int topEnum = stack.pop();
			inverseStack(stack);
			addToButtom(stack, topEnum);
		}
	}
	
	/**
	 * 1-1-用递归方法把栈顶元素放在栈底
	 * @param stack
	 * @param topEnum
	 */
	public static void addToButtom(Stack<Integer> stack, int topEnum) {
		if(stack.empty()) {
			stack.push(topEnum);
		} else {
			int temp = stack.pop();
			addToButtom(stack, topEnum);
			stack.push(temp);
		}
	} 
	
	/**
	 * 0-打印栈内的元素
	 * @param stack
	 */
	public static void printStack(Stack<Integer> stack) {
		if(!stack.empty()) {
			Stack<Integer> stackClone = (Stack<Integer>)stack.clone();
			while(!stackClone.empty()) {
				System.out.print(stackClone.pop());
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer> ();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		printStack(stack);
		inverseStack(stack);
		printStack(stack);
	}

}
