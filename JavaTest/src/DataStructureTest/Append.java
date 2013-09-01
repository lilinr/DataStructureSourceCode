package DataStructureTest;
/**
 * �����ǽ�������Ĳ�����1->2->3  ��  2->3->5  ��Ϊ  1->2->3->5 
 * ����ֻ���������������޸�������������ݡ�
 * @author raolilin-2013.5.8
 *
 */
public class Append {
	/**
	 * 1-��������
	 * @param head
	 * @param item
	 */
	public static void insertLinkNode(LinkNode head, int item) {//�����ͷ���
		if(head != null) {
			LinkNode node = new LinkNode();
			node.setData(item);
			node.setNext(head.getNext());
			head.setNext(node);
		}
	}
	/**
	 * 2-append
	 * @param aHead
	 * @param bHead
	 * @return
	 */
	public static LinkNode append(LinkNode aHead, LinkNode bHead) {
		if(aHead.getNext() == null) {
			return aHead;
		} else if(aHead.getNext() != null && bHead.getNext() == null) {
			return bHead;
		} else {
			LinkNode head = new LinkNode();
			LinkNode tail = head;
			LinkNode temp;
			LinkNode tempA = aHead.getNext();
			LinkNode tempB = bHead.getNext();
			while(tempA != null && tempB != null) {
				if(tempA.getData() < tempB.getData()) {
					temp = new LinkNode();
					temp.setData(tempA.getData());
					tail.setNext(temp);
					tail = temp;
					tempA = tempA.getNext();
				} else if(tempA.getData() > tempB.getData()) {
					temp = new LinkNode();
					temp.setData(tempB.getData());
					tail.setNext(temp);
					tail = temp;
					tempB = tempB.getNext();
				} else {
					temp = new LinkNode();
					temp.setData(tempB.getData());
					tail.setNext(temp);
					tail = temp;
					tempB = tempB.getNext();
					tempA = tempA.getNext();
				}
			}
			while(tempA != null) {
				temp = new LinkNode();
				temp.setData(tempA.getData());
				tail.setNext(temp);
				tail = temp;
				tempA = tempA.getNext();
			}
			while(tempB != null) {
				temp = new LinkNode();
				temp.setData(tempB.getData());
				tail.setNext(temp);
				tail = temp;
				tempB = tempB.getNext();
			}
			return head;
		}
	}
	/**
	 * 3-print
	 * @param head
	 */
	public static void printLink(LinkNode head) {
		if(head != null) {
			LinkNode temp = head.getNext();
			while(temp != null) {
				System.out.print(temp.getData() + ">>");
				temp = temp.getNext();
			}
			System.out.println("end!");
		}
	}
	
	public static void main(String[] args) {
		int[] a = {5,4,3,1};
		int[] b = {7,6,3,2,1};
		LinkNode aHead = new LinkNode();
		LinkNode bHead = new LinkNode();
		for(int i=0; i<a.length; i++) {
			insertLinkNode(aHead, a[i]);
		}
		for(int i=0; i<b.length; i++) {
			insertLinkNode(bHead, b[i]);
		}
		LinkNode cHead = append(aHead, bHead);
		printLink(aHead);
		printLink(bHead);
		printLink(cHead);
	}

}

class LinkNode {
	private int data;
	private LinkNode next;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LinkNode getNext() {
		return next;
	}
	public void setNext(LinkNode next) {
		this.next = next;
	}
}