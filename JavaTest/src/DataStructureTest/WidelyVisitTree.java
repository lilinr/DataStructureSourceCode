package DataStructureTest;

import java.util.Queue;

/**
 * ����һ�Ŷ�Ԫ�����������°����ӡ����ÿ����㣬ͬһ���а��մ������ҵ�˳���ӡ��
 * @author raolilin-2013.5.3
 *
 */
public class WidelyVisitTree {
	
	/**
	 * 1-�����Ԫ������
	 * @param root
	 * @param item
	 */
	public static void insertBiTreeNode(BiTreeNode root, int item) {
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
	 * 2-��ӡ������������
	 * @param node
	 */
	public static void printNode(BiTreeNode node) {
		if(node != null) {
			System.out.print(node.getData() + " ");
		} else {
			System.out.println("���Ϊ�գ�");
		}
	}
	/**
	 * 3-������ȱ���
	 * @param root
	 */
	public static void widelyPrintTree(BiTreeNode root) {
		if(root != null) {
			final int MAX = 50;
			int front = 0;
			int rear = 0;//front==rear�Կ�,(front+1)%MAX = rear/MAX����
			BiTreeNode[] queue = new BiTreeNode[MAX];
			queue[rear] = root;
			rear = (rear + 1) % MAX;//���
			BiTreeNode temp;
			while(front != rear) {
				temp = queue[front];
				front = (front + 1) % MAX;//����
				printNode(temp);
				if(temp.getLeftChild() != null) {
					if(front%MAX == (rear+1)%MAX) {
						System.out.println("Queue is full!");
						return;
					}
					queue[rear] = temp.getLeftChild();
					rear = (rear + 1) % MAX;//���
				}
				if(temp.getRightChild() != null) {
					if(front%MAX == (rear+1)%MAX) {
						System.out.println("Queue is full!");
						return;
					}
					queue[rear] = temp.getRightChild();
					rear = (rear + 1) % MAX;//���
				}
			}
		} else {
			System.out.println("��Ԫ��Ϊ�գ�");
		}
	}
	
	/**
	 * 4-���������ӡ��Ԫ������
	 * @param root
	 */
	public static void inOrderPrint(BiTreeNode root) {
		if(root != null) {
			inOrderPrint(root.getLeftChild());
			System.out.print(root.getData() + "-->");
			inOrderPrint(root.getRightChild());
		}
	}
	
	public static void main(String[] args) {
		int[] array = {11,10, 6, 14, 4, 8, 12, 16, 20, 1, 35, 3};
		BiTreeNode root = new BiTreeNode();
		for(int i=0; i<array.length; i++) {
			insertBiTreeNode(root, array[i]);
		}
		inOrderPrint(root);
		System.out.println();
		widelyPrintTree(root);
	}

}
/*
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
*/