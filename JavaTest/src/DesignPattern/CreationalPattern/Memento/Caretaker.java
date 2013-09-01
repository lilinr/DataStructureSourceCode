package DesignPattern.CreationalPattern.Memento;
/**
 * 备忘录模式
 * @author Raolilin-2013.5.6
 *
 */
//负责人角色
public class Caretaker {
	//备忘录对象
	private Memento memento;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
}
