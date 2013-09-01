package DataStructureTest;
/**
 * 求二叉树中节点的最大距离 
 * @author raolilin-2013.5.1
 *
 */
//1-定义二叉树的节点的数据结构
class Node {
	private int data;
	private Node leftChild;
	private Node rightChild;
	private int nMaxLeft;
	private int nMaxRight;
	public Node() {
		
	}
	public Node(int data, Node leftChild, Node rightChild) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	public Node getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	public int getnMaxLeft() {
		return nMaxLeft;
	}
	public void setnMaxLeft(int nMaxLeft) {
		this.nMaxLeft = nMaxLeft;
	}
	public int getnMaxRight() {
		return nMaxRight;
	}
	public void setnMaxRight(int nMaxRight) {
		this.nMaxRight = nMaxRight;
	}
	
}
public class MaxLenOfTree {
	private int maxLen = 0;
	/**
	 * 2-递归寻找最大距离
	 * @param root
	 */
	private void getMaxLenTemp(Node root) {
		if(null != root) {
			System.out.println("maxLen=" + maxLen);
			//如果左子树为空，那么该节点的左边最长距离为 0
			if(root.getLeftChild() == null) {
				root.setnMaxLeft(0);
			}
			//如果右子树为空，那么该节点的右边最长距离为 0 
			if(root.getRightChild() == null) {
				root.setnMaxRight(0);
			}
			//如果左子树不为空，递归寻找左子树最长距离 
			if(root.getLeftChild() != null) {
				getMaxLenTemp(root.getLeftChild());
			}
			//如果右子树不为空，递归寻找右子树最长距离 
			if(root.getRightChild() != null) {
				getMaxLenTemp(root.getRightChild());
			}
			//计算左边子树最长节点距离
			if(root.getLeftChild() != null) {
				int nTempMax = 0;
				if(root.getLeftChild().getnMaxLeft() > root.getLeftChild().getnMaxRight()) {
					nTempMax =root.getLeftChild().getnMaxLeft();
				} else {
					nTempMax =root.getLeftChild().getnMaxRight();
				}
				root.setnMaxLeft(nTempMax + 1);
			}
			//计算右子树最长节点距离
			if(root.getRightChild() != null) {
				int nTempMax = 0;
				if(root.getRightChild().getnMaxLeft() > root.getRightChild().getnMaxRight()) {
					nTempMax =root.getRightChild().getnMaxLeft();
				} else {
					nTempMax =root.getRightChild().getnMaxRight();
				}
				root.setnMaxRight(nTempMax + 1);
			}
			//更新最长距离 
			if(root.getnMaxLeft() + root.getnMaxRight() > maxLen) {
				maxLen = root.getnMaxLeft() + root.getnMaxRight();
			}
		}
	}
	
	/**
	 * 3-封装getMaxLen方法
	 * @param root
	 * @return
	 */
	public int getMaxLen(Node root) {
		getMaxLenTemp(root);
		int max = maxLen;
		maxLen = 0;
		return max;
	}
	
	public static void main(String[] args) {
		Node node4 = new Node(4, null, null);
		Node node5 = new Node(5, null, null);
		Node node8 = new Node(8, null, null);
		Node node13 = new Node(13, null, null);
		Node node14 = new Node(14, null, null);
		Node node11 = new Node(11, node13, null);
		Node node9 = new Node(9, node11, null);
		Node node12 = new Node(12, null, node14);
		Node node10 = new Node(10, null, node12);
		Node node7 = new Node(7, node10, null);
		Node node2 = new Node(2, node4, node5);
		Node node6 = new Node(6, node8, node9);
		Node node3 = new Node(3, node6, node7);
		Node node1 = new Node(1, node2, node3);
		int max = new MaxLenOfTree().getMaxLen(node1);
		System.out.println("node1:" + node1.getnMaxLeft() + " " + node1.getnMaxRight());
		System.out.println("node3:" + node3.getnMaxLeft() + " " + node3.getnMaxRight());
		System.out.println("MaxLenOfTree is " + max + ".");
	}

}
