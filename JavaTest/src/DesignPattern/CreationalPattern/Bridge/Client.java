package DesignPattern.CreationalPattern.Bridge;
/**
 * 桥梁模式
 * @author Raolilin-2013.5.1
 *
 */
public class Client {
	public static void main(String[] args) {
		//定义一个实例化角色
		Implementor imp = new ConcreteImplementor();
		//定义一个抽象化角色
		Abstraction abs = new RefinedAbstraction(imp);
		//执行
		abs.operation();
	}

}
