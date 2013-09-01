package DesignPattern.CreationalPattern.Command;
/**
 * ����ģʽ
 * @author Raolilin-2013.5.3
 *
 */
public class Invoker {
	private Command command;
	//��������
	public void setCommand(Command command) {
		this.command = command;
	}
	//ִ������
	public void action() {
		this.command.execute();
	}
}
