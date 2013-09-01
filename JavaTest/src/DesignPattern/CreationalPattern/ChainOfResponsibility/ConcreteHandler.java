package DesignPattern.CreationalPattern.ChainOfResponsibility;
/**
 * 责任链模式
 * @author Raolilin-2013.5.4
 *
 */
public class ConcreteHandler extends Handler {
	//处理请求
	public void handleRequest() {
		if(getSuccessor() != null) {
			System.out.println("请求传递给" + getSuccessor());
			getSuccessor().handleRequest();
		} else {
			System.out.println("处理请求");
		}
	}

}
