package DesignPattern.CreationalPattern.Visitor;
/**
 * ������ģʽ
 * @author Raolilin-2013.5.6
 *
 */
//���������
public interface Visitor {
	//���Է�����Щ����
	public void visit(ConcreteElement1 el1);
	public void visit(ConcreteElement2 el2);
}
