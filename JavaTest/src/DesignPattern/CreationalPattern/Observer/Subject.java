package DesignPattern.CreationalPattern.Observer;
/**
 * 观察者模式
 * @author Raolilin-2013.5.5
 *
 */
public interface Subject {
	//登记一个新的观察者
	public void attach(Observer obs);
	//删除一个登记过的观察者
	public void detach(Observer obs);
	//通知所有登记过的观察者对象
	public void notifyObserver();
}
