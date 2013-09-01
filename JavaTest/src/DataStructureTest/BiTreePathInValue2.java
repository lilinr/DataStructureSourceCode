package DataStructureTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：输入一个整数和一棵二元树。   
 * 从树的根结点开始往下访问一直到叶结点所经过的所有结点形成一条路径。 
 * 打印出和与输入整数相等的所有路径。   
 * 递归方法
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

public class BiTreePathInValue2 {
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
	public static void getPathsInValue(BiTreeNode root,List<BiTreeNode> path, int tempSum, int value) {
		if(null == root) {
			System.out.println("树为空！");
		} else {
			path.add(root);
			tempSum = tempSum + root.getData();
			boolean isLeaf = (root.getLeftChild() == null) && (root.getRightChild() == null);
			if(isLeaf && tempSum == value) {
				System.out.print("PathInValue(" + value + ")");
				for(BiTreeNode node : path) {
					System.out.print(node.getData() + "-->");
				}
				System.out.print("end\n");
			}
			getPathsInValue(root.getLeftChild(), path, tempSum, value);
			getPathsInValue(root.getRightChild(), path, tempSum, value);
			path.remove(path.size()-1);
		}
		
	}
	
	public static void main(String[] args) {
		int[] array = {10, 5, 4, 12, 7, 3};
		BiTreeNode root = new BiTreeNode();
		for(int i=0; i<array.length; i++) {
			insertBiTreeNode(root, array[i]);
		}
		List<BiTreeNode> path = new ArrayList<BiTreeNode>();
		getPathsInValue(root, path, 0, 22);
	}

}

