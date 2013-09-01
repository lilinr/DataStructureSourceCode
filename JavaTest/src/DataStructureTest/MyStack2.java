package DataStructureTest;
/**
 * ���ݽṹ��֮3������ջ�����ݽṹ��Ҫ�����һ��min�����ܹ��õ�ջ����Сֵ��
 * Ҫ��min��pop��push��ʱ�临�Ӷ�Ϊo(1)
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
	 * 1-Ԫ����ջ
	 * @param item
	 * @return
	 */
	public boolean push(int item) {
		if(top == STACK_SIZE-1) {
			System.out.println("ջ������");
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
	 * 2-Ԫ�س�ջ
	 * @return
	 */
	public int pop() {
		if(top == -1) {
			System.out.println("ջΪ�գ�");
			return -1;
		} else {
			top --;
			return mainStack[top+1];
		}
	}
	/**
	 * 3-min����
	 * @return
	 */
	public int min() {
		if(top == -1) {
			System.out.println("ջΪ�գ�");
			return -1;
		} else {
			return mainStack[assistStack[top]];
		}
	}
	/**
	 * 4-����ջ˳���ӡջԪ��
	 */
	public void printStack() {
		System.out.println("����ջ˳���ӡջԪ��:");
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
