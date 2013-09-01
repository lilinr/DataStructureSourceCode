package DesignPattern.CreationalPattern.Mediator;
/**
 * 中介者模式
 * @author Raolilin-2013.5.5
 *
 */
public class ConcreteColleague1 extends Colleague {
	public ConcreteColleague1(Mediator mediator) {
		super(mediator);
	}
	//实现具体行动方法
	public void action() {
		System.out.println("这是同事1的行动方法！");
	}

}
