package DataStructure;

public class Bnodept {
	public int data;
	public Bnodept lChild;
	public Bnodept rChild;
	public Bnodept(int data, Bnodept lChild, Bnodept rChild) {
		this.data = data;
		this.lChild = lChild;
		this.rChild = rChild;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Bnodept getlChild() {
		return lChild;
	}
	public void setlChild(Bnodept lChild) {
		this.lChild = lChild;
	}
	public Bnodept getrChild() {
		return rChild;
	}
	public void setrChild(Bnodept rChild) {
		this.rChild = rChild;
	}
	
	public static void visit(int data) {
		System.out.print(data + " ");
	}
	//先根序遍历
	public static void preOrder(Bnodept t) {
		if(t != null) {
			visit(t.data);
			preOrder(t.lChild);
			preOrder(t.rChild);
		}
	}
	//中根序遍历
	public static void inOrder(Bnodept t) {
		if(t != null) {
			inOrder(t.lChild);
			visit(t.data);
			inOrder(t.rChild);
		}
	}
	//后根序遍历
	public static void postOrder(Bnodept t) {
		if(t != null) {
			postOrder(t.lChild);
			postOrder(t.rChild);
			visit(t.data);
		}
	}
	//先根序非递归
	public static void preOrder2(Bnodept t) {
		Bnodept[] stack = new Bnodept[51];
		int top = 0;
		do {
			while(t != null) {
				visit(t.data);
				if(top == 50) {
					System.out.println("stack full!");
					return;
				}
				stack[++top] = t;
				t = t.lChild;
			}
			if(top != 0) {
				t = stack[top--];
				t = t.rChild;
			}
		} while(top != 0 || t != null);
		stack = null;
	}
	//中根序非递归
	public static void inOrder2(Bnodept t) {
		Bnodept[] stack = new Bnodept[51];
		int top = 0;
		do {
			
			while(t != null) {
				if(top == 50) {
					System.out.println("stack full!");
					return;
				}
				stack[++top] = t;
				t = t.lChild;
			}
			if(top != 0) {
				t = stack[top--];
				visit(t.data);
				t = t.rChild;
			}
		} while(top != 0 || t != null);
		stack = null;
	}
	//后根序非递归
	public static void postOrder2(Bnodept t) {
		Bnodept[] stack = new Bnodept[51];
		char[] stackFlag = new char[51];//'L' 'R'
		int top = 0;
		do {
			while(t != null) {
				if(top == 50) {
					System.out.println("stack full!");
					return;
				}
				stack[++top] = t;
				stackFlag[top] = 'L';
				t = t.lChild;
			}
			while(top != 0 && stackFlag[top] == 'R') {
				visit(stack[top].data);
				top--;
				
			}
			if(top != 0) {
				t = stack[top];
				stackFlag[top] = 'R';
				t = t.rChild;
			}
		} while(top != 0 || t != null);
		stack = null;
	}
}
