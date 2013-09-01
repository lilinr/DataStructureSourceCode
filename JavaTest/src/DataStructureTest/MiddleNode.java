package DataStructureTest;
/**
 * 输入一个单向链表。
 * 如果该链表的结点数为奇数, 输出中间的结点；
 * 如果链表结点数为偶数，输出中间两个结点前面的一个。
 * @author raolilin-2013.5.3
 *
 */
/*
 class MyNode {
	private int data;
	private MyNode next;
	
	public MyNode() {
		
	}
	
	public MyNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public MyNode getNext() {
		return next;
	}

	public void setNext(MyNode next) {
		this.next = next;
	}
	
}
 */
public class MiddleNode {
	/**
	 * 1-找到满足条件的中间节点（不含头结点）
	 * @param head
	 * @return
	 */
	public static MyNode getMiddleNode(MyNode head) {
		if(head == null) {
			System.out.println("链表为空！");
			return null;
		} else {
			System.out.println("head结点的data为：" + head.getData());
			MyNode temp = head;
			MyNode middleNode = head;
			while(temp != null) {
				temp = temp.getNext();
				if(temp != null) {
					temp = temp.getNext();
				}
				if(temp != null) {
					System.out.println("temp：" + temp.getData());
					middleNode = middleNode.getNext();
					System.out.println("临时中间结点的data为：" + middleNode.getData());
				} else {
					break;
				}
			}
			return middleNode;
		}
	}
	public static void main(String[] args) {
		MyNode[] nodeArray = new MyNode[12];
		for(int i=0; i<nodeArray.length; i++) {
			nodeArray[i] = new MyNode(i+1);
			if(i>0) {
				nodeArray[i-1].setNext(nodeArray[i]);
			}
		}
		MyNode middleNode = getMiddleNode(nodeArray[0]);
		if(middleNode != null) {
			System.out.println("中间结点的data为：" + middleNode.getData());
		} else {
			System.out.println("不存在中间结点");
		}
	}

}
