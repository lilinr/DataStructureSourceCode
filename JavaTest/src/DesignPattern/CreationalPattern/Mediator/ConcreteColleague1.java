package DesignPattern.CreationalPattern.Mediator;
/**
 * �н���ģʽ
 * @author Raolilin-2013.5.5
 *
 */
public class ConcreteColleague1 extends Colleague {
	public ConcreteColleague1(Mediator mediator) {
		super(mediator);
	}
	//ʵ�־����ж�����
	public void action() {
		System.out.println("����ͬ��1���ж�������");
	}

}
