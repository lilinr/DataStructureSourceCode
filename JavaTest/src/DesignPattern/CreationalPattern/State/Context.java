package DesignPattern.CreationalPattern.State;
/**
 * ״̬ģʽ
 * @author Raolilin-2013.5.6
 *
 */
//������ɫ
public class Context {
	public static State STATE1 = new ConcreteState1();
	public static State STATE2 = new ConcreteState2();
	
	private State currentState;
	
	public State getCurrentState() {
		return this.currentState;
	}
	
	public void setCurrentState(State currentState) {
		this.currentState = currentState;
		currentState.setContext(this);
	}
	//��Ϊί��
	public void handle1() {
		//�л���״̬1
		this.setCurrentState(STATE1);
		this.currentState.handle();
	}
	public void handle2() {
		//�л���״̬2
		this.setCurrentState(STATE2);
		this.currentState.handle();
	}
}
