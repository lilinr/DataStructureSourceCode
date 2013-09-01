package DataStructureTest;
/**
 * 数据结构题之3：定义栈的数据结构，要求添加一个min函数能够得到栈的最小值。
 * 要求min、pop和push的时间复杂度为o(1)
 * @author raolilin-2013.4.28
 *
 */
public class MyStack2 {
	private final int STACK_SIZE = 10;
	private int top;
	private int[] mainStack;
	private int[] assistStack;
	
	public MyStack2() {
		top = -1;
		mainStack = new int[STACK_SIZE];
		assistStack = new int[STACK_SIZE];
	}
	/**
	 * 1-元素入栈
	 * @param item
	 * @return
	 */
	public boolean push(int item) {
		if(top == STACK_SIZE-1) {
			System.out.println("栈已满！");
			return false;
		} else {
			top++;
			mainStack[top] = item;
			if(top != 0 && mainStack[assistStack[top-1]] < item) {
				assistStack[top] = assistStack[top-1];
			} else {
				assistStack[top] = top;
			}
			return true;
		}
	}
	/**
	 * 2-元素出栈
	 * @return
	 */
	public int pop() {
		if(top == -1) {
			System.out.println("栈为空！");
			return -1;
		} else {
			top --;
			return mainStack[top+1];
		}
	}
	/**
	 * 3-min函数
	 * @return
	 */
	public int min() {
		if(top == -1) {
			System.out.println("栈为空！");
			return -1;
		} else {
			return mainStack[assistStack[top]];
		}
	}
	/**
	 * 4-按出栈顺序打印栈元素
	 */
	public void printStack() {
		System.out.println("按出栈顺序打印栈元素:");
		for(int i=top; i>=0; i--) {
			System.out.print(mainStack[i] + "\t");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack2 myStack1 = new MyStack2();
		myStack1.push(8);
		myStack1.push(7);
		myStack1.push(6);
		myStack1.push(9);
		myStack1.push(5);
		System.out.println("myStack1.min()=" + myStack1.min());
		myStack1.printStack();
		
		MyStack2 myStack3 = new MyStack2();
		myStack3.push(5);
		myStack3.push(4);
		myStack3.push(5);
		myStack3.push(2);
		myStack3.push(3);
		System.out.println("myStack3.min()=" + myStack3.min());
		myStack3.printStack();
		myStack3.pop();
		System.out.println("myStack3.min()=" + myStack3.min());
		myStack3.printStack();
		myStack3.pop();
		System.out.println("myStack3.min()=" + myStack3.min());
		myStack3.printStack();
		myStack3.pop();
		System.out.println("myStack3.min()=" + myStack3.min());
		myStack3.printStack();
	}

}
