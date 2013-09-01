package DesignPattern.CreationalPattern.Visitor;
/**
 * ������ģʽ
 * @author Raolilin-2013.5.6
 *
 */
//���������
public class ConcreteVisitor implements Visitor {
	//����Ԫ��1
	public void visit(ConcreteElement1 el1) {
		el1.operation();
	}
	//����Ԫ��2
	public void visit(ConcreteElement2 el2) {
		el2.operation();
	}

}
