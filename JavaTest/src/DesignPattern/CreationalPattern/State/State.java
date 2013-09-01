package DesignPattern.CreationalPattern.State;
/**
 * ״̬ģʽ
 * @author Raolilin-2013.5.6
 *
 */
//����״̬
public abstract class State {
	protected Context context;
	
	public void setContext(Context context) {
		this.context = context;
	}
	
	//������Ϊ
	public abstract void handle();
}
