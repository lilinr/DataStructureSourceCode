package DataStructureTest;
/**
 * 排序二叉树
 * @author Raolilin 2013.8.26
 * 
 */
public class BiTreeOperation {
	public MyNode1 root;
	
	public void insert(int data) {
		if(root == null) {
			root = new MyNode1(data);
		} else {
			MyNode1 parent = root;
			MyNode1 temp;
			boolean isLeft;
			while(parent != null) {
				if(data > parent.data) {
					temp = parent.right;
					isLeft = false;
				} else {
					temp = parent.left;
					isLeft = true;
				}
				if(temp != null) {
					parent = temp;
				} else {
					temp = new MyNode1(data);
					if(isLeft) {
						parent.left = temp;
					} else {
						parent.right = temp;
					}
					break;
				}
			}
		}
	}
	
	public void inOrderPrint(MyNode1 node) {
		if(node != null) {
			inOrderPrint(node.left);
			System.out.print(node.data + "\t");
			inOrderPrint(node.right);
		}
	}
	
	public void preOrderPrint(MyNode1 node) {
		if(node != null) {
			System.out.print(node.data + "\t");
			preOrderPrint(node.left);
			preOrderPrint(node.right);
		}
	}
	
	//根据线序遍历和中序遍历重建二叉树
	public MyNode1 constructTree(int[] preOrder, int[] inOrder) {
		if(preOrder == null || inOrder == null) {
			System.out.println("Invalid inputs.0");
			return null;
		}
		return constructCore(preOrder, 0, preOrder.length-1,
				             inOrder, 0, inOrder.length-1);
	}
	private MyNode1 constructCore(int[] preOrder, int preStart, int preEnd,
								  int[] inOrder, int inStart, int inEnd) {
		if(preOrder == null || inOrder == null
				|| preStart > preEnd
				|| inStart > inEnd
				|| inEnd - inStart != preEnd - preStart) {
			System.out.println("Invalid inputs.1");
			return null;
		}
		MyNode1 root = new MyNode1(preOrder[preStart]);
		if(preStart == preEnd) {
			if(preOrder[preStart] == inOrder[inStart] && inStart == inEnd) {
				return root;
			} else {
				System.out.println("Invalid inputs.2");
				return null;
			}
		} else {
			//划分左右子树
			int i = inStart;
			int leftLen = 0;
			while(i <= inEnd && inOrder[i] != preOrder[preStart]) {
				++i;
				++leftLen;
			}
			if(i > inEnd && inOrder[i] != preOrder[preStart]) {
				System.out.println("Invalid inputs.3");
				return null;
			}
			if(leftLen > 0) {
				//构建左子树
				root.left = constructCore(preOrder, preStart+1, preStart+leftLen,
						inOrder, inStart, inStart+leftLen-1);
			}
			if(preEnd - 1 - leftLen > 0) {
				//构建右子树
				root.right = constructCore(preOrder, preStart+leftLen+1, preEnd,
						inOrder, inStart+leftLen+1, inEnd);
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		BiTreeOperation tree = new BiTreeOperation();
		tree.root = new MyNode1(4);
		int[] array = {12,33,5,1,6,9,16};
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + "\t");
			tree.insert(array[i]);
		}
		System.out.println();
		System.out.println(tree.root.data);
		tree.inOrderPrint(tree.root);
		System.out.println();
		tree.preOrderPrint(tree.root);
		*/
		BiTreeOperation tree = new BiTreeOperation();
//		int[] preOrder = {4, 2, 1, 3, 6, 5, 7};
//		int[] inOrder = {1, 2, 3, 4, 5, 6, 7};
		
//		int[] preOrder = {4, 2, 1, 6, 5, 7};
//		int[] inOrder = {1, 2, 4, 5, 6, 7};
		
		int[] preOrder = {1, 2, 3};
		int[] inOrder = {1, 2, 3};
		tree.root = tree.constructTree(null, inOrder);
		tree.preOrderPrint(tree.root);
		System.out.println();
		tree.inOrderPrint(tree.root);		
	}

}

class MyNode1 {
	public int data;
	public MyNode1 left;
	public MyNode1 right;
	
	public MyNode1() {
		
	}
	
	public MyNode1(int data) {
		this.data = data;
	}
}