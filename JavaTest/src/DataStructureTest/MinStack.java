package DataStructureTest;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

	// maybe we can use origin array rather than ArrayList
	private List<Integer> dataStack;
	private List<Integer> auxStack;// store the position of MinElement

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(3);
		minStack.printStatus();
		minStack.push(4);
		minStack.printStatus();
		minStack.push(2);
		minStack.printStatus();
		minStack.push(1);
		minStack.printStatus();
		minStack.pop();
		minStack.printStatus();
		minStack.pop();
		minStack.printStatus();
		minStack.push(0);
		minStack.printStatus();
	}

	public MinStack() {
		dataStack = new ArrayList<Integer>();
		auxStack = new ArrayList<Integer>();
	}

	public void push(int item) {
		if (isEmpty()) {
			dataStack.add(item);
			auxStack.add(0);// position=0
		} else {
			dataStack.add(item);
			int minIndex = auxStack.get(auxStack.size() - 1);
			int min = dataStack.get(minIndex);
			if (min > item) {
				auxStack.add(dataStack.size() - 1);
			} else {
				auxStack.add(minIndex);
			}
		}
	}

	public int pop() {
		int top = -1;
		if (isEmpty()) {
			System.out.println("no element,no pop");
		} else {
			auxStack.remove(auxStack.size() - 1);
			top = dataStack.remove(dataStack.size() - 1);
		}
		return top;

	}

	public int min() {
		int min = -1;
		if (!isEmpty()) {
			int minIndex = auxStack.get(auxStack.size() - 1);
			min = dataStack.get(minIndex);
		}
		return min;
	}

	public boolean isEmpty() {
		return dataStack.size() == 0;
	}

	public void printStatus() {
		System.out.println("数据栈\t辅助栈\t最小值");
		for (int i = 0; i < dataStack.size(); i++) {
			System.out.print(dataStack.get(i) + ",");
		}
		System.out.print("\t");
		for (int i = 0; i < dataStack.size(); i++) {
			System.out.print(auxStack.get(i) + ",");
		}
		System.out.print("\t");
		System.out.print(this.min());
		System.out.println();
	}
}
