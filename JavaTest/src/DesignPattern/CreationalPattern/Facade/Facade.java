package DesignPattern.CreationalPattern.Facade;
/**
 * ���ģʽ
 * @author Raolilin-2013.5.1
 *
 */
public class Facade {
	//��ί�ж���
	private ClassA a = new ClassA();
	private ClassB b = new ClassB();
	private ClassC c = new ClassC();
	//�ṩ���ķ���
	public void methodA() {
		a.methodA();
	}
	public void methodB() {
		b.methodB();
	}
	public void methodC() {
		c.methodC();
	}
}
