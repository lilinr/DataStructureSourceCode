package DataStructureTest;
/**
 * 单链表操作
 * @author raolilin-2013.5.11
 *
 */
public class LinkOperation {
	/**
	 * 1-构造链表
	 * @param head
	 * @param item
	 */
	public static void insertLinkNode(LinkNode head, int item) {//链表带头结点
		if(head != null) {
			LinkNode node = new LinkNode();
			node.setData(item);
			node.setNext(head.getNext());
			head.setNext(node);
		}
	}
	/**
	 * 1-构造链表-尾插法
	 * @param head
	 * @param item
	 */
	public static LinkNode insertLinkNode2(LinkNode head, int item) {//链表不带头结点
		if(head != null) {
			LinkNode temp = head;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			LinkNode node = new LinkNode();
			node.setData(item);
			temp.setNext(node);
		} else {
			head = new LinkNode();
			head.setData(item);
		}
		return head;
	}
	/**
	 * 2-1-就地逆置链表（带头结点）
	 * @param head
	 */
	public static void inverseLink(LinkNode head) {
		if(head != null && head.getNext() != null && head.getNext().getNext() != null) {
			LinkNode current = head.getNext().getNext();
			head.getNext().setNext(null);
			LinkNode next;
			while(current != null) {
				next = current.getNext();
				current.setNext(head.getNext());
				head.setNext(current);
				current = next;
			}
		} else {
			System.out.println("Link is null! 或者链表长度大于2才需要逆置。");
		}
	}
	/**
	 * 2-2-就地逆置链表（不带头结点）
	 * @param head
	 */
	public static LinkNode inverseLink2(LinkNode head) {
		if(head != null && head.getNext() != null) {
			LinkNode preNext = head;
			LinkNode current = head.getNext();
			LinkNode next;
			while(current != null) {
				next = current.getNext();
				current.setNext(preNext);
				preNext = current;
				current = next;
			}
			head.setNext(null);
			head = preNext;
			return head;
		} else {
			System.out.println("Link is null! 或者链表长度大于2才需要逆置。");
			return head;
		}
	}
	/**
	 * 2-3-就地逆置链表（不带头结点）
	 * @param head
	 */
	public static LinkNode inverseLink3(LinkNode head) {
		if(head != null && head.getNext() != null) {
			LinkNode preNext = null;
			LinkNode current = head;
			LinkNode next;
			while(current != null) {
				next = current.getNext();
				current.setNext(preNext);
				preNext = current;
				current = next;
			}
			head = preNext;
			return head;
		} else {
			System.out.println("Link is null! 或者链表长度大于2才需要逆置。");
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
	/**
	 * 3-print不带头结点
	 * @param head
	 */
	public static void printLink2(LinkNode head) {
		LinkNode temp = head;
		while(temp != null) {
			System.out.print(temp.getData() + ">>");
			temp = temp.getNext();
		}
		System.out.println("end!");
	}
	
	/**
	 * 4-o(1)复杂度删除指定结点(带头结点)
	 * @param head
	 * @param delete
	 */
	public static void deleteNode(LinkNode head, LinkNode delete) {
		if(head != null && delete != null) {
			if(delete.getNext() != null) {
				LinkNode temp = delete.getNext();
				delete.setData(temp.getData());
				delete.setNext(temp.getNext());
			} else {
				LinkNode temp = head;
				while(temp.getNext() != delete) {
					temp = temp.getNext();
				}
				temp.setNext(delete.getNext());
			}
		} else {
			System.out.println("inputs are not correct!");
		}
	}
	
	/**
	 * 5-输入一个链表的头结点，从尾到头反过来输出每个结点的值 (不带头结点)
	 * @param head
	 */
	public static void printInverse2(LinkNode head) {
		if(head != null) {
			printInverse2(head.getNext());
			System.out.print(head.getData() + ">>");
		}
	}
	/**
	 * 6-求不带头结点的单链表的长度，方法内不能定义变量，递归
	 * @param head
	 */
	public static int getLengthOfLink2(LinkNode head) {
		if(head != null) {
			return 1 + getLengthOfLink2(head.getNext());
		} else {
			return 0;
		}
	}
	
	/**
	 * 7-两个单向链表，找出它们的第一个公共结点
	 * @param aLink
	 * @param bLink
	 * @return
	 */
	public static LinkNode getCommonNode(LinkNode aLink, LinkNode bLink) {
		if(aLink != null && aLink.getNext() != null && bLink != null && bLink.getNext() != null) {
			if(aLink.getNext() == bLink.getNext()) {
				return aLink.getNext();
			}
			int aLen = getLengthOfLink(aLink);
			int bLen = getLengthOfLink(bLink);
			LinkNode aTemp = aLink.getNext();
			LinkNode bTemp = bLink.getNext();
			if(aLen > bLen) {
				while(aLen > bLen) {
					aTemp = aTemp.getNext();
					aLen--;
				}
			} else if(aLen < bLen){
				while(aLen < bLen) {
					bTemp = bTemp.getNext();
					bLen--;
				}
			}
			while(aLen > 0 && aTemp != bTemp) {
				aTemp = aTemp.getNext();
				bTemp = bTemp.getNext();
				aLen--;
			}
			if(aLen == 0) {
				aTemp = null;
			}
			return aTemp;
		} else {
			System.out.println("inputs are not correct!");
			return null;
		}
	}
	/**
	 * 6-求链表的长度（带头结点）
	 * @param head
	 * @return
	 */
	public static int getLengthOfLink(LinkNode head) {
		int counter = 0;
		LinkNode temp = head.getNext();
		while(temp != null) {
			counter++;
			temp = temp.getNext();
		}
		return counter;
	}
	
	//头插法，不带头结点
	public static DoubleNode insertDoubleNode(DoubleNode head, int item) {
		if(head != null) {
			DoubleNode insert = new DoubleNode();
			insert.setData(item);
			insert.setPre(head);
			insert.setNext(head.getNext());
			head.getNext().setPre(insert);
			head.setNext(insert);
		} else {
			head = new DoubleNode();
			head.setData(item);
			head.setNext(head);
			head.setPre(head);
		}
		return head;
	}
	
	//打印循环双向链表
	public static void printDoubleLink(DoubleNode head) {
		if(head != null) {
			DoubleNode pre = head;
			DoubleNode next = head;
			do {
				System.out.println(pre.getData() + "\t" + next.getData());
				pre = pre.getPre();
				next = next.getNext();
			} while(pre != head && next != head);
		} else {
			System.out.println("head is null");
		}
	}
	//删除双向循环链表里的值为data的节点
	public static Object[] deleteByData(DoubleNode head, int data) {
		boolean flag = false;
		if(head != null) {
			DoubleNode temp = head;
			do {
				if(temp.getData() == data) {
					if(temp.getNext() != temp.getPre()) {
						if(temp == head) {
							head = temp.getNext();
						}
						temp.getPre().setNext(temp.getNext());
						temp.getNext().setPre(temp.getPre());
						flag = true;
					} else {
						//只有一个节点，且值为data
						flag = true;
						head = null;
					}
				}
				temp = temp.getNext();
			} while(temp != head);
			return new Object[] {head, flag};
		} else {
			System.out.println("head is null");
			return new Object[] {head, flag};
		}
	}
	//判断head是否为空
	public static boolean isNull(DoubleNode head) {
		if(head == null || (head.getNext() == null && head.getPre() == null)) {
			return true;
		} else {
			return false;
		}
	} 
	//有两个双向循环链表 A，B，知道其头指针为：pHeadA,pHeadB，请写一函数将两链表中 data 值相同的结点删除
	public static Object[] deleteTheSame(DoubleNode aHead, DoubleNode bHead) {
		if(aHead != null && bHead != null) {
			boolean flag = false;
			DoubleNode temp = aHead;
			do {
				boolean flagTemp = (Boolean) deleteByData(bHead, temp.getData())[1];
				bHead = (DoubleNode) deleteByData(bHead, temp.getData())[0];
				if(isNull(bHead)) {
					return new Object[] {aHead, flag};
				}
				if(flagTemp) {
					if(temp.getNext() != temp.getPre()) {
						if(temp == aHead) {
							aHead = temp.getNext();
						}
						temp.getPre().setNext(temp.getNext());
						temp.getNext().setPre(temp.getPre());
						flag = true;
					} else {
						//只有一个节点，且值为data
						flag = true;
						aHead.setPre(null);
						aHead.setNext(null);
						break;
					}
				}
				temp = temp.getNext();
			} while(temp != aHead);
			return new Object[] {aHead, flag};
		} else {
			System.out.println("inputs are null!");
			return new Object[] {aHead, false};
		}
	}
	
	//给定n个整数,求对应的哈夫曼树的高度
	public static int getHuffmanLayer(int[] arr) {
		int maxLayer = 0;
		if(arr != null && arr.length != 0) {
			HuffNode[] huffNodes = new HuffNode[arr.length];
			for(int i=0; i<arr.length; i++) {
				huffNodes[i] = new HuffNode(arr[i], 1);
			}
			int length = huffNodes.length;
			while(length > 1) {
				huffNodeSort(huffNodes, length);
				printHuffNodes(huffNodes);
				huffNodes[length - 2].value += huffNodes[length - 1].value; 
				huffNodes[length - 2].layer = ((huffNodes[length - 1].layer > huffNodes[length - 2].layer) ? huffNodes[length - 1].layer : huffNodes[length - 2].layer) + 1;
				if(huffNodes[length - 2].layer > maxLayer) {
					maxLayer = huffNodes[length - 2].layer;
				}
				length--;
			}
		}
		return maxLayer;
	}
	public static void huffNodeSort(HuffNode[] arr, int length) {
		if(arr != null && arr.length != 0 && arr.length >= length) {
			boolean changed = false;
			for(int i=0; i<length-1; i++) {
				for(int j=i+1; j<length; j++) {
					if(arr[i].value <= arr[j].value) {
						changed = true;
						HuffNode temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
				if(!changed) {
					break;
				}
			}
		}
	}
	public static void huffNodeSort(HuffNode[] arr) {
		if(arr != null && arr.length != 0) {
			boolean changed = false;
			for(int i=0; i<arr.length-1; i++) {
				for(int j=i+1; j<arr.length; j++) {
					if(arr[i].value > arr[j].value) {
						changed = true;
						HuffNode temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
				if(!changed) {
					break;
				}
			}
		}
	}
	public static void printHuffNodes(HuffNode[] arr) {
		if(arr != null && arr.length != 0) {
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i].value + "  ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
//		int[] arr = {3,4,8,12,16,19};
//		int[] arr = {3,3,3,3,3,3};
//		System.out.println(getHuffmanLayer(arr));
		

		
//		int[] a = {1, 2, 3, 4, 5, 6};
//		int[] b = {2, 3, 6, 7, 8};
//		DoubleNode aHead = null;
//		DoubleNode bHead = null;
//		for(int i=0; i< a.length; i++) {
//			aHead = insertDoubleNode(aHead, a[i]);
//		}
//		for(int i=0; i< b.length; i++) {
//			bHead = insertDoubleNode(bHead, b[i]);
//		}
//		printDoubleLink(aHead);
//		System.out.println("*************");
//		printDoubleLink(bHead);
//		System.out.println("*************");
//		Object[] result = deleteTheSame(aHead, bHead);
//		aHead = (DoubleNode) result[0];
//		System.out.println((Boolean)result[1]);
//		printDoubleLink(aHead);
//		System.out.println("*************");
//		printDoubleLink(bHead);
//		System.out.println("*************");
//		int[] a = {9, 8, 7, 6, 5, 4, 3, 1};
//		int[] a = {3, 1};
//		int[] a = {1};
		int[] a = {};
//		LinkNode aHead = new LinkNode();
//		for(int i=0; i<a.length; i++) {
//			insertLinkNode(aHead, a[i]);
//		}
//		printLink(aHead);
//		inverseLink(aHead);
//		printLink(aHead);
		
		LinkNode aHead2 = null;
		for(int i=0; i<a.length; i++) {
			aHead2 = insertLinkNode2(aHead2, a[i]);
		}
		printLink2(aHead2);
//		printInverse2(aHead2);
//		System.out.println("\nlength is " + getLengthOfLink2(aHead2));
		aHead2 = inverseLink3(aHead2);
		printLink2(aHead2);
		
//		LinkNode head = new LinkNode();
//		LinkNode a1 = new LinkNode();
//		a1.setData(1);
//		LinkNode a2 = new LinkNode();
//		a2.setData(2);
//		LinkNode a3 = new LinkNode();
//		a3.setData(3);
//		LinkNode a4 = new LinkNode();
//		a4.setData(4);
//		head.setNext(a1);
//		a1.setNext(a2);
//		a2.setNext(a3);
//		a3.setNext(a4);
//		a4.setNext(null);
//		printLink(head);
//		deleteNode(head, a2);
//		printLink(head);
		

//		LinkNode h1 = new LinkNode();
//		h1.setData(5);
//		LinkNode h2 = new LinkNode();
//		h2.setData(6);
//		LinkNode h3 = new LinkNode();
//		h3.setData(7);
//		LinkNode h4 = new LinkNode();
//		h4.setData(8);
//		h1.setNext(h2);
//		h2.setNext(h3);
//		h3.setNext(h4);
//		h4.setNext(null);
//		LinkNode a = new LinkNode();
//		LinkNode a1 = new LinkNode();
//		a1.setData(1);
//		LinkNode a2 = new LinkNode();
//		a2.setData(2);
//		LinkNode a3 = new LinkNode();
//		a3.setData(3);
//		LinkNode a4 = new LinkNode();
//		a4.setData(4);
//		a.setNext(a1);
//		a1.setNext(a2);
//		a2.setNext(a3);
//		a3.setNext(a4);
//		a4.setNext(h1);
//		LinkNode b = new LinkNode();
//		LinkNode b1 = new LinkNode();
//		b1.setData(11);
//		LinkNode b2 = new LinkNode();
//		b2.setData(21);
//		LinkNode b3 = new LinkNode();
//		b3.setData(31);
//		LinkNode b4 = new LinkNode();
//		b4.setData(41);
//		b.setNext(b1);
//		b1.setNext(b2);
//		b2.setNext(b3);
//		b3.setNext(b4);
//		b4.setNext(h1);
//		
//		printLink(a);
//		printLink(b);
//		printLink2(getCommonNode(a,b));
		
	}

}

//双向链表节点
class DoubleNode {
	private int data;
	private DoubleNode pre;
	private DoubleNode next;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public DoubleNode getPre() {
		return pre;
	}
	public void setPre(DoubleNode pre) {
		this.pre = pre;
	}
	public DoubleNode getNext() {
		return next;
	}
	public void setNext(DoubleNode next) {
		this.next = next;
	}
}

class HuffNode {
	public int value;
	public int layer;
	public HuffNode() {
		
	}
	public HuffNode(int value, int layer) {
		this.value = value;
		this.layer = layer;
	}
}

/*
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
*/