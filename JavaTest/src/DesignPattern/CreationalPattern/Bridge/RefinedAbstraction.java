package DesignPattern.CreationalPattern.Bridge;
/**
 * 桥梁模式
 * @author Raolilin-2013.5.1
 *
 */
//修正抽象化角色
public class RefinedAbstraction extends Abstraction {
	public RefinedAbstraction(Implementor imp) {
		super(imp);
	}
	//修正父类的方法
	public void operation() {
		//业务代码
	}
}
