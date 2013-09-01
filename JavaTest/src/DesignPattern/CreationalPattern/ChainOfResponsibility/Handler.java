package DesignPattern.CreationalPattern.ChainOfResponsibility;
/**
 * ������ģʽ
 * @author Raolilin-2013.5.4
 *
 */
public abstract class Handler {
	private Handler successor;
	//������
	public abstract void handleRequest();
	public Handler getSuccessor() {
		return successor;
	}
	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}
}
