package DataStructureTest;

import java.util.ArrayList;
import java.util.List;

/**
 * ��Ŀ������һ��������һ�ö�Ԫ����   
 * �����ĸ���㿪ʼ���·���һֱ��Ҷ��������������н���γ�һ��·���� 
 * ��ӡ����������������ȵ�����·����   
 * �ݹ鷽��
 * @author raolilin-2013.4.30
 *
 */
/**
 * 1-�����Ԫ��������ݽṹ
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
	 * 2-�����Ԫ��
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
	 * 3-Ѱ������������·��
	 * @param root
	 * @param value
	 * @return
	 */
	public static void getPathsInValue(BiTreeNode root,List<BiTreeNode> path, int tempSum, int value) {
		if(null == root) {
			System.out.println("��Ϊ�գ�");
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

