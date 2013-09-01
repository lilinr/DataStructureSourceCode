package DesignPattern.CreationalPattern.Composite;
/**
 * ���ģʽ
 * @author Raolilin-2013.5.1
 *
 */
public class Client {

	public static void main(String[] args) {
		//����һ�����ڵ�
		Composite root = new Composite();
		//������֦�ڵ�
		Composite branch = new Composite();
		//����Ҷ�ӽڵ�
		Leaf leaf = new Leaf();
		//�������Խṹ
		root.add(branch);
		branch.add(leaf);
		display(root);
	}

	//���������ݹ飩
	public static void display(Composite root) {
		for(Component c : root.getChild()) {
			if(c instanceof Leaf) {
				c.operation();
			} else {
				c.operation();
				display((Composite) c);
			}
		}
	}
}
