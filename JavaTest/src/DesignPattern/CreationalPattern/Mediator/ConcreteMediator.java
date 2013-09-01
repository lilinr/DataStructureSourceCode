package DesignPattern.CreationalPattern.Mediator;
/**
 * 中介者模式
 * @author Raolilin-2013.5.5
 *
 */
public class ConcreteMediator extends Mediator {
	private ConcreteColleague1 colleague1;
	private ConcreteColleague2 colleague2;
	public void colleagueChanged(Colleague c) {
		c.action();
	}
	//工厂方法，创建同事对象
	public void createConcreteColleagues() {
		colleague1 = new ConcreteColleague1(this);
		colleague2 = new ConcreteColleague2(this);
	}
	public ConcreteColleague1 getColleague1() {
		return colleague1;
	}
	public ConcreteColleague2 getColleague2() {
		return colleague2;
	}
	
}
