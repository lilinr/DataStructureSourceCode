package DesignPattern.CreationalPattern.Decorator;
/**
 * 装饰模式
 * @author Raolilin-2013.4.30
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Component component = new ConcreteComponent();
		//进行装饰
		component = new ConcreteDecorator(component);
		component.operation();
	}

}
