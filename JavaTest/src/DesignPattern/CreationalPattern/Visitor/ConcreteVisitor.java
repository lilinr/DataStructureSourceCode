package DesignPattern.CreationalPattern.Visitor;
/**
 * 访问者模式
 * @author Raolilin-2013.5.6
 *
 */
//具体访问者
public class ConcreteVisitor implements Visitor {
	//访问元素1
	public void visit(ConcreteElement1 el1) {
		el1.operation();
	}
	//访问元素2
	public void visit(ConcreteElement2 el2) {
		el2.operation();
	}

}
