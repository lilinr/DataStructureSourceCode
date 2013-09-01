package DesignPattern.CreationalPattern.Command;
/**
 * 命令模式
 * @author Raolilin-2013.5.3
 *
 */
public class Invoker {
	private Command command;
	//接受命令
	public void setCommand(Command command) {
		this.command = command;
	}
	//执行命令
	public void action() {
		this.command.execute();
	}
}
