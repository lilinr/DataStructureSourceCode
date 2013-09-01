package DesignPattern.CreationalPattern.Command;
/**
 * ÃüÁîÄ£Ê½
 * @author Raolilin-2013.5.3
 *
 */
public class Client {
	public static void main(String[] args) {
		Invoker invoker = new Invoker();
		Receiver receiver = new Receiver();
		Command command = new ConcreteCommand(receiver);
		invoker.setCommand(command);
		invoker.action();
	}
}
