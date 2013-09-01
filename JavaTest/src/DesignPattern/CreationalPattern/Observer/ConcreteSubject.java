package DesignPattern.CreationalPattern.Observer;
/**
 * 观察者模式
 * @author Raolilin-2013.5.5
 *
 */
import java.util.*;
public class ConcreteSubject implements Subject {
	private Vector<Observer> obsVector = new Vector<Observer>();
	//登记一个新的观察者
	public void attach(Observer obs) {
		obsVector.add(obs);
	}
	//删除一个登记过的观察者
	public void detach(Observer obs) {
		obsVector.remove(obs);
	}
	//通知所有登记过的观察者对象
	public void notifyObserver() {
		for(Observer obs : obsVector) {
			obs.update();
		}
	}
	//返回观察者集合的Enumeration对象
	public Enumeration<Observer> observers() {
		return obsVector.elements();
	}
	//业务方法，状态改变
	public void change() {
		this.notifyObserver();
	}
}
