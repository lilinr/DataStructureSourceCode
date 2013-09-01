package DataStructureTest;
/**
 * 输入一颗二元查找树，将该树转换为它的镜像
 * @author raolilin-2013.5.3
 *
 */
public class MirrorOfBiTree {
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
	 * 2-交换给定结点的左右孩子
	 * @param parent
	 */
	public static void swapChild(BiTreeNode parent) {
		BiTreeNode temp = parent.getLeftChild();
		parent.setLeftChild(parent.getRightChild());
		parent.setRightChild(temp);
	}
	/**
	 * 3-后序遍历-递归
	 * @param root
	 */
	public static void postOrderSwap1(BiTreeNode root) {
		if(root != null) {
			postOrderSwap1(root.getLeftChild());
			postOrderSwap1(root.getRightChild());
			swapChild(root);
		}
	}
	/**
	 * 4-后序遍历-非递归
	 * @param root
	 */
	public static void postOrderSwap2(BiTreeNode root) {
		int top = 0;
		final int MAX = 51;
		BiTreeNode[] stack = new BiTreeNode[MAX];
		boolean[] rChildIsVisited = new boolean[MAX];
		BiTreeNode temp = root;
		do {
			while(temp != null) {
				if(top == MAX-1) {
					System.out.println("Stack is full!");
					return;
				} else {
					top++;
					stack[top] = temp;
					temp = temp.getLeftChild();
					rChildIsVisited[top] = false;
				}
			}
			while(top !=0 && rChildIsVisited[top]) {
				swapChild(stack[top]);
				top--;
			}
			if(top != 0) {
				temp = stack[top];
				rChildIsVisited[top] = true;
				temp = temp.getRightChild();
			}
		} while(top != 0 || temp != null);
		stack = null;
	}
	
	/**
	 * 5-中序遍历打印二元查找树
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
		System.out.println("递归镜像之前：");
		inOrderPrint(root);
		postOrderSwap1(root);
		System.out.println("\n递归镜像之后：");
		inOrderPrint(root);
//		System.out.println("\n非递归镜像之前：");
//		inOrderPrint(root);
//		postOrderSwap2(root);
//		System.out.println("\n非递归镜像之后：");
//		inOrderPrint(root);
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