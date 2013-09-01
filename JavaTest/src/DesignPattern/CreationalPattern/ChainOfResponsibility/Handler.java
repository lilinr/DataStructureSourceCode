package DesignPattern.CreationalPattern.ChainOfResponsibility;
/**
 * 责任链模式
 * @author Raolilin-2013.5.4
 *
 */
public abstract class Handler {
	private Handler successor;
	//处理方法
	public abstract void handleRequest();
	public Handler getSuccessor() {
		return successor;
	}
	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}
}
