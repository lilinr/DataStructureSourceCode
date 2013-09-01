package DataStructureTest;
/**
 * 
 * @author raolilin-2013.5.15
 *
 */
public class BiTreeNodeOperation {

	/**
	 * 输入二叉树中的两个结点，输出这两个结点在数中最低的共同父结点
	 * @param root
	 * @param node1
	 * @param node2
	 * @return
	 */
	public static BiTreeNode getCommonNode(BiTreeNode root, BiTreeNode node1, BiTreeNode node2) {
		if(root != null) {
			if((isParent(root.getLeftChild(),node1) && isParent(root.getRightChild(), node2))
					|| (isParent(root.getLeftChild(),node2) && isParent(root.getRightChild(), node1))) {
				return root;
			} else if(isParent(root.getLeftChild(),node1) && isParent(root.getLeftChild(), node2)) {
				return getCommonNode(root.getLeftChild(), node1, node2);
			} else {
				return getCommonNode(root.getRightChild(), node1, node2);
			}
		} else {
			return null;
		}
		
	}
	
	//一棵排序二叉树，令  f=(最大值+最小值)/2，设计一个算法，找出距离 f值最近、大于 f值的结点（递归）
	public static BiTreeNode getFNode(BiTreeNode root) {
		int f = (getMin(root).getData() + getMax(root).getData()) / 2;
		System.out.println(f);
		return getNodeTemp(root, f);
	}
	private static BiTreeNode getMin(BiTreeNode root) {
		if(root != null) {
			BiTreeNode temp = root;
			while(temp.getLeftChild() != null) {
				temp = temp.getLeftChild();
			}
			System.out.println("min" + temp.getData());
			return temp;
		} else {
			return null;
		}
	}
	private static BiTreeNode getMax(BiTreeNode root) {
		if(root != null) {
			BiTreeNode temp = root;
			while(temp.getRightChild() != null) {
				temp = temp.getRightChild();
			}
			System.out.println("max" + temp.getData());
			return temp;
		} else {
			return null;
		}
	}
	private static BiTreeNode getNodeTemp(BiTreeNode root, int f) {
		if(root != null) {
			if(f == root.getData()) {
				return getMin(root.getRightChild());
			} else if(f > root.getData()) {
				return getNodeTemp(root.getRightChild(), f);
			} else {
				if(root.getLeftChild() == null || (root.getLeftChild().getRightChild() == null && root.getLeftChild().getData() == f)) {
					return root;
				} else {
					return getNodeTemp(root.getLeftChild(), f);
				}
			}
		} else {
			return null;
		}
	}
	//一棵排序二叉树，令  f=(最大值+最小值)/2，设计一个算法，找出距离 f值最近、大于 f值的结点（非递归）
	public static BiTreeNode getFNode2(BiTreeNode root) {
		int diff = Integer.MAX_VALUE;
		int f = (getMin(root).getData() + getMax(root).getData()) / 2;
		BiTreeNode result = root;
		while(root != null) {
			if(root.getData() > f) {
				if(root.getData() - f < diff) {
					diff = root.getData() - f;
					result = root;
				}
				root = root.getLeftChild();
			} else {
				root = root.getRightChild();
			}
		}
		return result;
	}
	public static boolean isParent(BiTreeNode root, BiTreeNode node) {
		if(root != null) {
			if(root.getLeftChild() == node || root.getRightChild() == node) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {11,10, 6, 14, 4, 8, 12, 16, 20, 1, 23, 3};
		BiTreeNode root = new BiTreeNode();
		BiTreeToBiLink treeToLink = new BiTreeToBiLink();
		for(int i=0; i<array.length; i++) {
			treeToLink.insertBiTreeNode(root, array[i]);
		}
		treeToLink.inOrderPrint(root);
		System.out.println();
		System.out.println(getFNode(root).getData());
		System.out.println();
		System.out.println(getFNode2(root).getData());
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