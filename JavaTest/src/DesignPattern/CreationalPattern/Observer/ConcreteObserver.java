package DesignPattern.CreationalPattern.Observer;
/**
 * 观察者模式
 * @author Raolilin-2013.5.5
 *
 */
public class ConcreteObserver implements Observer {

	public void update() {
		System.out.println("收到通知，并进行处理");
	}

}
