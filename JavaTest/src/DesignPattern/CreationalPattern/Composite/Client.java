package DesignPattern.CreationalPattern.Composite;
/**
 * 组合模式
 * @author Raolilin-2013.5.1
 *
 */
public class Client {

	public static void main(String[] args) {
		//创建一个根节点
		Composite root = new Composite();
		//创建树枝节点
		Composite branch = new Composite();
		//创建叶子节点
		Leaf leaf = new Leaf();
		//构建属性结构
		root.add(branch);
		branch.add(leaf);
		display(root);
	}

	//遍历树（递归）
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
