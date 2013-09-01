package DesignPattern.CreationalPattern.Observer;
/**
 * �۲���ģʽ
 * @author Raolilin-2013.5.5
 *
 */
import java.util.*;
public class ConcreteSubject implements Subject {
	private Vector<Observer> obsVector = new Vector<Observer>();
	//�Ǽ�һ���µĹ۲���
	public void attach(Observer obs) {
		obsVector.add(obs);
	}
	//ɾ��һ���Ǽǹ��Ĺ۲���
	public void detach(Observer obs) {
		obsVector.remove(obs);
	}
	//֪ͨ���еǼǹ��Ĺ۲��߶���
	public void notifyObserver() {
		for(Observer obs : obsVector) {
			obs.update();
		}
	}
	//���ع۲��߼��ϵ�Enumeration����
	public Enumeration<Observer> observers() {
		return obsVector.elements();
	}
	//ҵ�񷽷���״̬�ı�
	public void change() {
		this.notifyObserver();
	}
}
