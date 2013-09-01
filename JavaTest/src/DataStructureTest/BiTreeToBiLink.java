package DataStructureTest;
/**
 * �Ѷ�Ԫ������ת��Ϊ�����˫������
 * @author raolilin-2013.4.25
 *
 */
public class BiTreeToBiLink {

	private BiTreeNode head;
	private BiTreeNode preNode;

	
	public BiTreeNode getHead() {
		return this.head;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {11,10, 6, 14, 4, 8, 12, 16, 20, 1, 35, 3};
		BiTreeNode root = null;
		BiTreeToBiLink treeToLink = new BiTreeToBiLink();
//		for(int i=0; i<array.length; i++) {
//			treeToLink.insertBiTreeNode(root, array[i]);
//		}
		for(int i=0; i<array.length; i++) {
			root = treeToLink.insertBiTreeNode2(root, array[i]);
		}
		treeToLink.inOrderPrint(root);
		treeToLink.inOrderChange(root);
		System.out.println();
		treeToLink.printBiLink(treeToLink.getHead());
	}
	
	/**
	 * 1-�����Ԫ������
	 * @param root
	 * @param item
	 */
	void insertBiTreeNode(BiTreeNode root, int item) {
		if(root == null) {
			System.out.println("root���Ϊ�գ�");
			return;
		} else if(root.getData() == 0) {
			root.setData(item);
		} else if(root.getData() > item) {
			if(root.getLeftChild() == null) {
				BiTreeNode temp = new BiTreeNode();
				temp.setData(item);
				root.setLeftChild(temp);
			} else {
				insertBiTreeNode(root.getLeftChild(), item);
			}
		} else {
			if(root.getRightChild() == null) {
				BiTreeNode temp = new BiTreeNode();
				temp.setData(item);
				root.setRightChild(temp);
			} else {
				insertBiTreeNode(root.getRightChild(), item);
			}
		}
	}
	
	/**
	 * 1-�����Ԫ������--�ǵݹ�
	 * @param root
	 * @param item
	 */
	BiTreeNode insertBiTreeNode2(BiTreeNode root, int item) {
		if(root == null) {
			root = new BiTreeNode();
			root.setData(item);
		} else {
			BiTreeNode temp = root;
			while(temp != null) {
				if(temp.getData() > item) {
					if(temp.getLeftChild() == null) {
						BiTreeNode child = new BiTreeNode();
						child.setData(item);
						temp.setLeftChild(child);
						return root;
					} else {
						temp = temp.getLeftChild();
					}
				} else {
					if(temp.getRightChild() == null) {
						BiTreeNode child = new BiTreeNode();
						child.setData(item);
						temp.setRightChild(child);
						return root;
					} else {
						temp = temp.getRightChild();
					}
				}
			}
		}
		return root;
	}
	
	/**
	 * 2-�������������i�����ʱ��������i�����͵�i-1������ָ��
	 * @param currentNode
	 */
	void changePointer(BiTreeNode currentNode) {
		if(preNode == null) {
			head = currentNode;
		} else {
			currentNode.setLeftChild(preNode);
			preNode.setRightChild(currentNode);
		}
		preNode = currentNode;
	}

	/**
	 * 3-���������Ԫ������������ָ��
	 * @param root
	 */
	void inOrderChange(BiTreeNode root) {
		if(root != null) {
			inOrderChange(root.getLeftChild());
			changePointer(root);
			inOrderChange(root.getRightChild());
		}
	}
	
	/**
	 * 4-���������ӡ��Ԫ������
	 * @param root
	 */
	void inOrderPrint(BiTreeNode root) {
		if(root != null) {
			inOrderPrint(root.getLeftChild());
			System.out.print(root.getData() + "-->");
			inOrderPrint(root.getRightChild());
		}
	}
	
	/**
	 * 5-˫�������ӡ˫������
	 * @param head
	 */
	void printBiLink(BiTreeNode head) {
		BiTreeNode current = head;
		BiTreeNode tail = head;
		System.out.println("����");
		while(current != null) {
			System.out.print(current.getData() + "-->");
			tail = current;
			current = current.getRightChild();
		}
		System.out.println();
		System.out.println("����");
		while(tail != null) {
			System.out.print(tail.getData() + "==>");
			tail = tail.getLeftChild();
		}
		
	}
}

class BiTreeNode {
	private BiTreeNode leftChild;
	private BiTreeNode rightChild;
	private int data;
	public BiTreeNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(BiTreeNode leftChild) {
		this.leftChild = leftChild;
	}
	public BiTreeNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(BiTreeNode rightChild) {
		this.rightChild = rightChild;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
}