package DesignPattern.CreationalPattern.Facade;
/**
 * 外观模式
 * @author Raolilin-2013.5.1
 *
 */
public class Facade {
	//被委托对象
	private ClassA a = new ClassA();
	private ClassB b = new ClassB();
	private ClassC c = new ClassC();
	//提供外界的方法
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
