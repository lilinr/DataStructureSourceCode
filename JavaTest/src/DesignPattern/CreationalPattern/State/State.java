package DesignPattern.CreationalPattern.State;
/**
 * 状态模式
 * @author Raolilin-2013.5.6
 *
 */
//抽象状态
public abstract class State {
	protected Context context;
	
	public void setContext(Context context) {
		this.context = context;
	}
	
	//抽象行为
	public abstract void handle();
}
