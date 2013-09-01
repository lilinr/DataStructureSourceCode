package DesignPattern.CreationalPattern.Mediator;
/**
 * 中介者模式
 * @author Raolilin-2013.5.5
 *
 */
public class ConcreteColleague2 extends Colleague {
	public ConcreteColleague2(Mediator mediator) {
		super(mediator);
	}
	//实现具体行动方法
	public void action() {
		System.out.println("这是同事2的行动方法！");
	}

}
