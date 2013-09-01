package DesignPattern.CreationalPattern.Decorator;
/**
 * װ��ģʽ
 * @author Raolilin-2013.4.30
 *
 */
public class ConcreteDecorator extends Decorator {
	public ConcreteDecorator(Component component) {
		super(component);
	}
	//�����Լ��ķ���
	private void method() {
		System.out.println("����");
	}
	//��дoperation����
	public void operation() {
		this.method();
		super.operation();
	}
}
