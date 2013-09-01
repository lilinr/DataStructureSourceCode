package DesignPattern.CreationalPattern.Command;
/**
 * ����ģʽ
 * @author Raolilin-2013.5.3
 *
 */
public class ConcreteCommand implements Command {
	private Receiver receiver;
	public ConcreteCommand(Receiver receiver) {
		this.receiver = receiver;
	}
	//ִ�з���
	public void execute() {
		this.receiver.action();
	}

}
