package DesignPattern.CreationalPattern.Memento;
/**
 * ����¼ģʽ
 * @author Raolilin-2013.5.6
 *
 */
//�����˽�ɫ
public class Caretaker {
	//����¼����
	private Memento memento;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
}
