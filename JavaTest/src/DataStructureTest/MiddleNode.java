package DataStructureTest;
/**
 * ����һ����������
 * ���������Ľ����Ϊ����, ����м�Ľ�㣻
 * �����������Ϊż��������м��������ǰ���һ����
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
	 * 1-�ҵ������������м�ڵ㣨����ͷ��㣩
	 * @param head
	 * @return
	 */
	public static MyNode getMiddleNode(MyNode head) {
		if(head == null) {
			System.out.println("����Ϊ�գ�");
			return null;
		} else {
			System.out.println("head����dataΪ��" + head.getData());
			MyNode temp = head;
			MyNode middleNode = head;
			while(temp != null) {
				temp = temp.getNext();
				if(temp != null) {
					temp = temp.getNext();
				}
				if(temp != null) {
					System.out.println("temp��" + temp.getData());
					middleNode = middleNode.getNext();
					System.out.println("��ʱ�м����dataΪ��" + middleNode.getData());
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
			System.out.println("�м����dataΪ��" + middleNode.getData());
		} else {
			System.out.println("�������м���");
		}
	}

}
