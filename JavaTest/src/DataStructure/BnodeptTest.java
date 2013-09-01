package DataStructure;

public class BnodeptTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bnodept c = new Bnodept(4, null, null);
		Bnodept d = new Bnodept(5, null, null);
		Bnodept f = new Bnodept(7, null, null);
		Bnodept g = new Bnodept(8, null, null);
		Bnodept b = new Bnodept(3, c, d);
		Bnodept e = new Bnodept(6, f, g);
		Bnodept a = new Bnodept(2, b, null);
		Bnodept root = new Bnodept(1, a, e);
//		System.out.println("先根序遍历：");
//		Bnodept.preOrder(root);
//		System.out.println();
//		System.out.println("先根序遍历2：");
//		Bnodept.preOrder2(root);
//		System.out.println();
//		System.out.println("中根序遍历：");
//		Bnodept.inOrder(root);
//		System.out.println();
//		System.out.println("中根序遍历2：");
//		Bnodept.inOrder2(root);
//		System.out.println();
		System.out.println("后根序遍历：");
		Bnodept.postOrder(root);
		System.out.println();
		System.out.println("后根序遍历2：");
		Bnodept.postOrder2(root);
	}

}
