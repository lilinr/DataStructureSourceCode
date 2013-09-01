package DataStructureTest;
/**
 * 数据结构题之3：定义栈的数据结构，要求添加一个min函数能够得到栈的最小值。
 * 要求min、pop和push的时间复杂度为o(1)
 * @author raolilin-2013.4.28
 *
 */
/**
 * 1-设计好栈元素的数据结构
 * 定义了元素的数据结构，除了data之外，还有next和pre“指针”，
 * 指向比自己大的数据和比自己小的数据元素。
 */
class StackElement {
	private int data;
	private int next;
	private int pre;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getPre() {
		return pre;
	}
	public void setPre(int pre) {
		this.pre = pre;
	}
}
public class MyStack {
	private final int NULL_STATUS = -1;
	private final int STACK_SIZE = 10;
	private int top;
	private int min;
	private StackElement[] stack;
	
	public MyStack() {
		top = NULL_STATUS;
		min = NULL_STATUS;
		stack = new StackElement[STACK_SIZE];
	}
	
	/**
	 * 2-元素入栈
	 * @param item
	 * @return
	 */
	public boolean push(int item) {
		if(top == STACK_SIZE) {
			System.out.println("栈已满！");
			return false;
		} else {
			top++;
			stack[top] = new StackElement();
			stack[top].setData(item);
			if(min == NULL_STATUS) {
				min = top;
				stack[top].setPre(NULL_STATUS);
				stack[top].setNext(NULL_STATUS);
			} else {
				int pre = NULL_STATUS;
				int current = min;
				while(current != NULL_STATUS) {
					if(item < stack[current].getData()) {
						break;
					}
					pre = current;
					current = stack[pre].getNext();
				}
				if(current != NULL_STATUS) {
					stack[top].setNext(current);
					stack[top].setPre(pre);
					if(pre != NULL_STATUS) {
						stack[pre].setNext(top);
					} else {
						min = top;
					}
					stack[current].setPre(top);
				} else {
					stack[pre].setNext(top);
					stack[top].setPre(pre);
					stack[top].setNext(NULL_STATUS);
				}
			}
			return true;
		}
	}
	
	/**
	 * 3-元素出栈
	 * @return
	 */
	public int pop() {
		if(top == NULL_STATUS) {
			System.out.println("栈为空！");
			return NULL_STATUS;
		} else {
			if(min == top) {
				min = stack[top].getNext();
				stack[min].setPre(NULL_STATUS);
			} else {
				stack[stack[top].getPre()].setNext(stack[top].getNext());
				if(stack[top].getNext() != NULL_STATUS) {
					stack[stack[top].getNext()].setPre(stack[top].getPre());
				} else {
					stack[stack[top].getPre()].setNext(NULL_STATUS);
				}
			}
			top--;
			return stack[top+1].getData();
		}
	}
	
	/**
	 * 4-min方法
	 * @return
	 */
	public int min() {
		if(top == NULL_STATUS) {
			System.out.println("栈为空！");
			return NULL_STATUS;
		} else {
			return stack[min].getData();
		}
	}
	
	/**
	 * 5-按出栈顺序打印栈元素
	 */
	public void printStack() {
		System.out.println("按出栈顺序打印栈元素:");
		for(int i=top; i>=0; i--) {
//			System.out.print(stack[i].getData() + "_" + stack[i].getPre() + "&" + stack[i].getNext() + "\t");
			System.out.print(stack[i].getData() + "\t");
		}
		System.out.println();
	}
	/**
	 * 6-按升序打印栈元素
	 */
	public void printStackOrderByAsc() {
		System.out.println("按升序打印栈元素:");
		int temp = min;
		while(temp != NULL_STATUS) {
			System.out.print(stack[temp].getData() + "\t");
			temp = stack[temp].getNext();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack myStack = new MyStack();
		myStack.push(8);
		myStack.push(7);
		myStack.push(6);
		myStack.push(9);
		myStack.push(5);
		System.out.println("min()=" + myStack.min());
		myStack.printStack();
		myStack.printStackOrderByAsc();
		System.out.println("pop=" + myStack.pop());
		System.out.println("min()=" + myStack.min());
		myStack.printStack();
		myStack.printStackOrderByAsc();
		System.out.println("pop=" + myStack.pop());
		System.out.println("min()=" + myStack.min());
		myStack.printStack();
		myStack.printStackOrderByAsc();
		System.out.println("pop=" + myStack.pop());
		System.out.println("min()=" + myStack.min());
		myStack.printStack();
		myStack.printStackOrderByAsc();
		System.out.println("pop=" + myStack.pop());
	}
	
}

