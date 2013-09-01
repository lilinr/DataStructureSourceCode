package search;
public class Search {
	public static void main(String[] args) {
		
	}
	
	/**
	 * 1-顺序查找-o(n)
	 * @param array
	 * @param item
	 * @return 返回数组元素的下标
	 */
	public static int sequenceSearch(int[] array, int item) {
		if(array != null && array.length > 0) {
			for(int i=0; i<array.length; i++) {
				if(item == array[i]) {
					return i;
				}
			}
			return -1;
		} else {
			System.out.println("数组为空！");
			return -1;
		}
	}
	/**
	 * 2-二分查找（折半查找）-有序表 -o(log n)
	 * @param array
	 * @param item
	 * @return
	 */
	public static int binarySearch(int[] array, int item) {
		if(array != null && array.length > 0) {
			int flag = -1;
			int low = 0;
			int high = array.length -1;
			int mid;
			while(low <= high) {
				mid = (high - low) / 2 + low;
				if(item > array[mid]) {
					low = mid + 1;
				} else if(item < array[mid]) {
					high = mid - 1;
				} else {
					flag = mid;
					break;
				}
			}
			return flag;
		} else {
			System.out.println("数组为空！");
			return -1;
		}
	}
	/**
	 * 3-差值查找-有序表-o(log n)-平均性能最好的查找方法，但只适合于关键码均匀分布的表
	 * @param array
	 * @param item
	 * @return
	 */
	public static int insertSearch(int[] array, int item) {
		if(array != null && array.length > 0) {
			int flag = -1;
			int low = 0;
			int high = array.length -1;
			int mid;
			while(low <= high) {
				//mid = (high - low) / 2 + low;
				mid = (item - array[low]) / (array[high] - array[low]) * (high - low) + low;
				if(item > array[mid]) {
					low = mid + 1;
				} else if(item < array[mid]) {
					high = mid - 1;
				} else {
					flag = mid;
					break;
				}
			}
			return flag;
		} else {
			System.out.println("数组为空！");
			return -1;
		}
	}
	/* 
	 * 4-斐波那契查找（黄金分割法）-有序表-o(log n)
	 * 对于表长为F(i)-1的表
	 * mid = low + F(i-1)-1
	 */
	/*
	 * 5-分块查找-最短平均查找长度为（根号n+1）
	 */
	
	/**
	 * 6-二叉排序树-
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
	public static boolean biTreeSearch(BiTreeNode root, int item) {
		if(root != null) {
			if(root.getData() > item) {
				return biTreeSearch(root.getLeftChild(), item);
			} else if(root.getData() < item) {
				return biTreeSearch(root.getRightChild(), item);
			} else {
				return true;
			}
		} else {
			System.out.println("二叉排序树为空！");
			return false;
		}
	}
	
}

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