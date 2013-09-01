package DesignPattern.CreationalPattern.Visitor;
/**
 * 访问者模式
 * @author Raolilin-2013.5.6
 *
 */
//抽象访问者
public interface Visitor {
	//可以访问哪些对象
	public void visit(ConcreteElement1 el1);
	public void visit(ConcreteElement2 el2);
}
