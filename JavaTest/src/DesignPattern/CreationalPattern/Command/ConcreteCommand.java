package DesignPattern.CreationalPattern.Command;
/**
 * 命令模式
 * @author Raolilin-2013.5.3
 *
 */
public class ConcreteCommand implements Command {
	private Receiver receiver;
	public ConcreteCommand(Receiver receiver) {
		this.receiver = receiver;
	}
	//执行方法
	public void execute() {
		this.receiver.action();
	}

}
