package DataStructureTest;
/**
 * 输入一棵二元树的根结点，求该树的深度
 * @author raolilin-2013.5.12
 *
 */
public class TreeDeep {
	/**
	 * 1-递归方法
	 * @param root
	 * @return
	 */
	public static int getDeep(BiTreeNode root) {
		if(root != null) {
			int deepL = getDeep(root.getLeftChild());
			int deepR = getDeep(root.getRightChild());
//			return ((deepL>deepR) ? deepL : deepR) + 1;
			return ((deepL>deepR) ? (deepL+1) : (deepR+1));
		} else {
			return 0;
		}
	}
	
	/**
	 * 2-构造二元查找树
	 * @param root
	 * @param item
	 */
	void insertBiTreeNode(BiTreeNode root, int item) {
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
	
	public static void main(String[] args) {
		int[] array = {11,10, 6, 14, 4, 8, 12, 16, 20, 1, 35, 3};
		BiTreeNode root = new BiTreeNode();
		BiTreeToBiLink treeToLink = new BiTreeToBiLink();
		for(int i=0; i<array.length; i++) {
			treeToLink.insertBiTreeNode(root, array[i]);
		}
		System.out.println("root的深度为:" + getDeep(root));
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
*/