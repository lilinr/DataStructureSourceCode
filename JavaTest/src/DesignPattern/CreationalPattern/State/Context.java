package DesignPattern.CreationalPattern.State;
/**
 * 状态模式
 * @author Raolilin-2013.5.6
 *
 */
//环境角色
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
	//行为委托
	public void handle1() {
		//切换到状态1
		this.setCurrentState(STATE1);
		this.currentState.handle();
	}
	public void handle2() {
		//切换到状态2
		this.setCurrentState(STATE2);
		this.currentState.handle();
	}
}
