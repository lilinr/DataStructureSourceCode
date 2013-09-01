package search;
public class Search {
	public static void main(String[] args) {
		
	}
	
	/**
	 * 1-˳�����-o(n)
	 * @param array
	 * @param item
	 * @return ��������Ԫ�ص��±�
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
			System.out.println("����Ϊ�գ�");
			return -1;
		}
	}
	/**
	 * 2-���ֲ��ң��۰���ң�-����� -o(log n)
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
			System.out.println("����Ϊ�գ�");
			return -1;
		}
	}
	/**
	 * 3-��ֵ����-�����-o(log n)-ƽ��������õĲ��ҷ�������ֻ�ʺ��ڹؼ�����ȷֲ��ı�
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
			System.out.println("����Ϊ�գ�");
			return -1;
		}
	}
	/* 
	 * 4-쳲��������ң��ƽ�ָ��-�����-o(log n)
	 * ���ڱ�ΪF(i)-1�ı�
	 * mid = low + F(i-1)-1
	 */
	/*
	 * 5-�ֿ����-���ƽ�����ҳ���Ϊ������n+1��
	 */
	
	/**
	 * 6-����������-
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
			System.out.println("����������Ϊ�գ�");
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