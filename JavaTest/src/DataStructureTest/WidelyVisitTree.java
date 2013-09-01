package DataStructureTest;

import java.util.Queue;

/**
 * 输入一颗二元树，从上往下按层打印树的每个结点，同一层中按照从左往右的顺序打印。
 * @author raolilin-2013.5.3
 *
 */
public class WidelyVisitTree {
	
	/**
	 * 1-构造二元查找树
	 * @param root
	 * @param item
	 */
	public static void insertBiTreeNode(BiTreeNode root, int item) {
		if(root == null) {
			System.out.println("root结点为空！");
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
	 * 2-打印单个结点的数据
	 * @param node
	 */
	public static void printNode(BiTreeNode node) {
		if(node != null) {
			System.out.print(node.getData() + " ");
		} else {
			System.out.println("结点为空！");
		}
	}
	/**
	 * 3-广度优先遍历
	 * @param root
	 */
	public static void widelyPrintTree(BiTreeNode root) {
		if(root != null) {
			final int MAX = 50;
			int front = 0;
			int rear = 0;//front==rear对空,(front+1)%MAX = rear/MAX队满
			BiTreeNode[] queue = new BiTreeNode[MAX];
			queue[rear] = root;
			rear = (rear + 1) % MAX;//入队
			BiTreeNode temp;
			while(front != rear) {
				temp = queue[front];
				front = (front + 1) % MAX;//出队
				printNode(temp);
				if(temp.getLeftChild() != null) {
					if(front%MAX == (rear+1)%MAX) {
						System.out.println("Queue is full!");
						return;
					}
					queue[rear] = temp.getLeftChild();
					rear = (rear + 1) % MAX;//入队
				}
				if(temp.getRightChild() != null) {
					if(front%MAX == (rear+1)%MAX) {
						System.out.println("Queue is full!");
						return;
					}
					queue[rear] = temp.getRightChild();
					rear = (rear + 1) % MAX;//入队
				}
			}
		} else {
			System.out.println("二元树为空！");
		}
	}
	
	/**
	 * 4-中序遍历打印二元查找树
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