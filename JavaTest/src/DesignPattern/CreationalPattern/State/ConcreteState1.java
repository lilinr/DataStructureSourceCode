package DesignPattern.CreationalPattern.State;
/**
 * 状态模式
 * @author Raolilin-2013.5.6
 *
 */
//具体状态1
public class ConcreteState1 extends State {
	//状态1的行为逻辑处理
	public void handle() {
		System.out.println("行为1的逻辑处理行为");
	}

}
