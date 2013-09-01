package DataStructureTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：输入一个整数和一棵二元树。   
 * 从树的根结点开始往下访问一直到叶结点所经过的所有结点形成一条路径。 
 * 打印出和与输入整数相等的所有路径。   
 * @author raolilin-2013.4.30
 *
 */
/**
 * 1-定义二元树结点数据结构
 */
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

public class BiTreePathInValue {
	private static final int MAX = 10;
	/**
	 * 2-构造二元树
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
	 * 3-寻找满足条件的路径
	 * @param root
	 * @param value
	 * @return
	 */
	public static List<int[]> getPathsInValue(BiTreeNode root, int value) {
		if(null == root) {
			System.out.println("树为空！");
			return null;
		}
		List<int[]> pathes = new ArrayList<int[]>();
		int[] path;
		BiTreeNode[] nodes = new BiTreeNode[MAX];
		int[] sums = new int[MAX];
		boolean[] rightChildIsVisited = new boolean[MAX];
		int top = 0;
		BiTreeNode tempNode = root;
		while(top >= 0) {
			if(tempNode != null) {
				if(tempNode.getData() + sums[top] < value) {
					//保存新的和，继续访问下一个节点
					System.out.println("tempNode.getData() + sums[top] < value");
					top++;
					nodes[top] = tempNode;
					sums[top] = tempNode.getData() + sums[top-1];
					tempNode = tempNode.getLeftChild();
				} else if(tempNode.getData() + sums[top] > value) {
					//如果之和大于value，返回到上一个未访问右孩子的节点
					System.out.println("tempNode.getData() + sums[top] < value");

					while(rightChildIsVisited[top]) {
						top--;
					}
					if(top == 0) {
						break;
					}
					tempNode = nodes[top].getRightChild();
					rightChildIsVisited[top] = true;
				} else {
					System.out.println("tempNode.getData() + sums[top] = value");
					if(tempNode.getLeftChild() == null && tempNode.getRightChild() == null) {
						//如果等于value且为叶子节点，保存路径，
						top++;
						nodes[top] = tempNode;
						sums[top] = tempNode.getData() + sums[top-1];
						rightChildIsVisited[top] = true;//不会再访问叶子节点的右孩子
						path = new int[top];
						for(int i=1; i<=top; i++) {
							path[i-1] = nodes[i].getData();
						}
						pathes.add(path);
					}
					//然后返回到上一个未访问右孩子的节点
					while(rightChildIsVisited[top]) {
						top--;
					}
					if(top == 0) {
						break;
					}
					tempNode = nodes[top].getRightChild();
					rightChildIsVisited[top] = true;//表示已访问该节点的右孩子
				}
			} else {
				//返回到上一个未访问右孩子的节点
				System.out.println("tempNode == null");
				while(rightChildIsVisited[top]) {
					top--;
				}
				if(top == 0) {
					break;
				}
				tempNode = nodes[top].getRightChild();
				rightChildIsVisited[top] = true;
			}
		}
		return pathes;
	}
	
	/**
	 * 4-打印路径
	 * @param pathes
	 */
	public static void printPathes(List<int[]> pathes) {
		if(pathes != null) {
			System.out.println("Pathes不为空！size=" + pathes.size());
			for(int j=0; j<pathes.size(); j++) {
				System.out.print("Path" + j + ":");
				for(int i=0; i<pathes.get(j).length; i++) {
					System.out.print(pathes.get(j)[i] + "-->");
				}
				System.out.print("end.\n");
			}
		} else {
			System.out.println("Pathes为空！");
		}
	}
	/**
	 * 5-中序遍历二元树
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
		int[] array = {10, 5, 4, 12, 7,   3};
		BiTreeNode root = new BiTreeNode();
		for(int i=0; i<array.length; i++) {
			insertBiTreeNode(root, array[i]);
		}
		List<int[]> pathes = getPathsInValue(root, 22);
		inOrderPrint(root);
		System.out.print("\n");
		System.out.println("打印Pathes！");
		printPathes(pathes);
	}

}

