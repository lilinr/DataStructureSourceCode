package DesignPattern.CreationalPattern.Decorator;
/**
 * 装饰模式
 * @author Raolilin-2013.4.30
 *
 */
public class ConcreteDecorator extends Decorator {
	public ConcreteDecorator(Component component) {
		super(component);
	}
	//定义自己的方法
	private void method() {
		System.out.println("修饰");
	}
	//重写operation方法
	public void operation() {
		this.method();
		super.operation();
	}
}
