package DataStructureTest;
/**
 * ����һ��������������������е����� k ����� ��
 * @author raolilin-2013.5.3
 *
 */
public class KthNode {
	/**
	 * 1-��ø���������������ͷ��㣩�ĵ�����k�����
	 * @param head
	 * @return
	 */
	public static MyNode getKthNode1(MyNode head, int k) {
		if(head == null || k <= 0) {
			System.out.println("����Ϊ�գ�����kС�ڵ���0��");
			return null;
		} else {
			int count = 0;
			MyNode temp = head;
			MyNode kthNode = null;
			while(temp != null) {
				count++;
				temp = temp.getNext();
				if(count == k) {
					kthNode = head;
				} else if(count > k) {
					kthNode = kthNode.getNext();
				}
			}
			return kthNode;
		}
	}
	/**
	 * 2-��ø�������������ͷ��㣩�ĵ�����k�����
	 * @param head
	 * @return
	 */
	public static MyNode getKthNode2(MyNode head, int k) {
		if(k <= 0) {
			System.out.println("kС�ڵ���0��");
			return null;
		} else {
			int count = 0;
			MyNode temp = head.getNext();
			MyNode kthNode = null;
			while(temp != null) {
				count++;
				temp = temp.getNext();
				if(count == k) {
					kthNode = head.getNext();
				} else if(count > k) {
					kthNode = kthNode.getNext();
				}
			}
			return kthNode;
		}
	}
	
	public static void main(String[] args) {
		MyNode[] nodeArray = new MyNode[10];
		for(int i=0; i<nodeArray.length; i++) {
			nodeArray[i] = new MyNode(i+1);
			if(i>0) {
				nodeArray[i-1].setNext(nodeArray[i]);
			}
		}
		int k = 1;
		MyNode kthNode = getKthNode1(nodeArray[0], k);
		if(kthNode != null) {
			System.out.println("������" + k + "������dataΪ��" + kthNode.getData());
		} else {
			System.out.println("�����ڵ�����" + k + "�����");
		}
	}

}

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