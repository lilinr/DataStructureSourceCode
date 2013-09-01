package DesignPattern.CreationalPattern.Observer;


/**
 * �۲���ģʽ
 * @author Raolilin-2013.5.5
 *
 */
public class Client {
	
	public static void main(String[] args) {
		ConcreteSubject subject = new ConcreteSubject();
		Observer obs = new ConcreteObserver();
		subject.attach(obs);
		subject.change();
		
	}

}