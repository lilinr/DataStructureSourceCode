package DataStructureTest;

import java.util.ArrayList;
import java.util.List;

/**
 * ��Ŀ������һ��������һ�ö�Ԫ����   
 * �����ĸ���㿪ʼ���·���һֱ��Ҷ��������������н���γ�һ��·���� 
 * ��ӡ����������������ȵ�����·����   
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

public class BiTreePathInValue {
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
	public static List<int[]> getPathsInValue(BiTreeNode root, int value) {
		if(null == root) {
			System.out.println("��Ϊ�գ�");
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
					//�����µĺͣ�����������һ���ڵ�
					System.out.println("tempNode.getData() + sums[top] < value");
					top++;
					nodes[top] = tempNode;
					sums[top] = tempNode.getData() + sums[top-1];
					tempNode = tempNode.getLeftChild();
				} else if(tempNode.getData() + sums[top] > value) {
					//���֮�ʹ���value�����ص���һ��δ�����Һ��ӵĽڵ�
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
						//�������value��ΪҶ�ӽڵ㣬����·����
						top++;
						nodes[top] = tempNode;
						sums[top] = tempNode.getData() + sums[top-1];
						rightChildIsVisited[top] = true;//�����ٷ���Ҷ�ӽڵ���Һ���
						path = new int[top];
						for(int i=1; i<=top; i++) {
							path[i-1] = nodes[i].getData();
						}
						pathes.add(path);
					}
					//Ȼ�󷵻ص���һ��δ�����Һ��ӵĽڵ�
					while(rightChildIsVisited[top]) {
						top--;
					}
					if(top == 0) {
						break;
					}
					tempNode = nodes[top].getRightChild();
					rightChildIsVisited[top] = true;//��ʾ�ѷ��ʸýڵ���Һ���
				}
			} else {
				//���ص���һ��δ�����Һ��ӵĽڵ�
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
	 * 4-��ӡ·��
	 * @param pathes
	 */
	public static void printPathes(List<int[]> pathes) {
		if(pathes != null) {
			System.out.println("Pathes��Ϊ�գ�size=" + pathes.size());
			for(int j=0; j<pathes.size(); j++) {
				System.out.print("Path" + j + ":");
				for(int i=0; i<pathes.get(j).length; i++) {
					System.out.print(pathes.get(j)[i] + "-->");
				}
				System.out.print("end.\n");
			}
		} else {
			System.out.println("PathesΪ�գ�");
		}
	}
	/**
	 * 5-���������Ԫ��
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
		System.out.println("��ӡPathes��");
		printPathes(pathes);
	}

}

