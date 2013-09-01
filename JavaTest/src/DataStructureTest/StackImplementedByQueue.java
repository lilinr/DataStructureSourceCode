package DataStructureTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 一个队列实现栈
 * 
 * @author raolilin-2013.6.5
 * 
 */
public class StackImplementedByQueue {
	private LinkedList<Integer> queue;
	public StackImplementedByQueue() {
		queue = new LinkedList<Integer>();
	}
	// 入栈
	public Integer push(int item) {
		queue.offer(item);
		return item;
	}

	// 出栈
	public Integer pop() {
		Integer re = null;
		if (!queue.isEmpty()) {
			int size = queue.size() - 1;
			while (size > 0) {
				re = queue.poll();
				queue.offer(re);
				size--;
			}
			re = queue.poll();
		}
		return re;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackImplementedByQueue stack = new StackImplementedByQueue();
		List<Integer> re = new ArrayList<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		re.add(stack.pop());
		stack.push(4);
		re.add(stack.pop());
		stack.push(5);
		re.add(stack.pop());
		re.add(stack.pop());
		re.add(stack.pop());
		System.out.println(re.toString());
	}

}
