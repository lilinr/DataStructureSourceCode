package DesignPattern.CreationalPattern.Memento;
/**
 * ����¼ģʽ
 * @author Raolilin-2013.5.6
 *
 */
//����¼��ɫ
public class Memento {
	//�����˵��ڲ�״̬
	private String state;
	public Memento(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
