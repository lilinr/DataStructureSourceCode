package DesignPattern.CreationalPattern.Decorator;
/**
 * װ��ģʽ
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
		//����װ��
		component = new ConcreteDecorator(component);
		component.operation();
	}

}
