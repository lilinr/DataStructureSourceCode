package DesignPattern.CreationalPattern.ChainOfResponsibility;
/**
 * 责任链模式
 * @author Raolilin-2013.5.4
 *
 */
public class Client {
	public static void main(String[] args) {
		Handler h1 = new ConcreteHandler();
		Handler h2 = new ConcreteHandler();
		h1.setSuccessor(h2);
		h1.handleRequest();
	}

}
