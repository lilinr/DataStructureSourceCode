package DesignPattern.CreationalPattern.Mediator;
/**
 * �н���ģʽ
 * @author Raolilin-2013.5.5
 *
 */
public class ConcreteColleague2 extends Colleague {
	public ConcreteColleague2(Mediator mediator) {
		super(mediator);
	}
	//ʵ�־����ж�����
	public void action() {
		System.out.println("����ͬ��2���ж�������");
	}

}
