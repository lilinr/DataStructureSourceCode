package DesignPattern.CreationalPattern.Mediator;
/**
 * �н���ģʽ
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
	//�����ж�������������ʵ��
	public abstract void action();
	//ҵ�񷽷�
	public void change() {
		this.mediator.colleagueChanged(this);
	}
}
