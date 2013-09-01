package DesignPattern.CreationalPattern.Memento;
/**
 * ����¼ģʽ
 * @author Raolilin-2013.5.6
 *
 */
public class Client {

	public static void main(String[] args) {
		Originator org = new Originator();
		Caretaker car = new Caretaker();
		car.setMemento(org.createMemento());
		org.restoreMemento(car.getMemento());
	}

}
