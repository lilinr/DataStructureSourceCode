package DesignPattern.CreationalPattern.Memento;
/**
 * ����¼ģʽ
 * @author Raolilin-2013.5.6
 *
 */
//�����˽�ɫ
public class Originator {
	//�ڲ�״̬
	private String state = "";

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	//��������¼
	public Memento createMemento() {
		return new Memento(this.state);
	}
	
	//�ָ�һ������¼
	public void restoreMemento(Memento memento) {
		this.setState(memento.getState());
	}
}

