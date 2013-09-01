package DesignPattern.CreationalPattern.Mediator;
/**
 * 中介者模式
 * @author Raolilin-2013.5.5
 *
 */
public abstract class Colleague {
	private Mediator mediator;
	public Colleague(Mediator mediator) {
		this.mediator = mediator;
	}
	public Mediator getMediator() {
		return mediator;
	}
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	//抽象行动方法，由子类实现
	public abstract void action();
	//业务方法
	public void change() {
		this.mediator.colleagueChanged(this);
	}
}
