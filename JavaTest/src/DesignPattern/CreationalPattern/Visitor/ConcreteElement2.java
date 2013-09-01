package DesignPattern.CreationalPattern.Visitor;
/**
 * 访问者模式
 * @author Raolilin-2013.5.6
 *
 */
//具体元素
public class ConcreteElement2 extends Element {
	//接收方法
	public void accept(Visitor vi) {
		vi.visit(this);
	}
	//业务逻辑方法
	public void operation() {
		System.out.println("访问元素2");
	}
}
