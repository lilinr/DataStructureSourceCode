package DesignPattern.CreationalPattern.Visitor;
/**
 * ������ģʽ
 * @author Raolilin-2013.5.6
 *
 */
//����Ԫ��
public class ConcreteElement2 extends Element {
	//���շ���
	public void accept(Visitor vi) {
		vi.visit(this);
	}
	//ҵ���߼�����
	public void operation() {
		System.out.println("����Ԫ��2");
	}
}
