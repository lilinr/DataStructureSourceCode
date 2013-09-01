package DesignPattern.CreationalPattern.TemplateMethod;
/**
 * 模板方法模式
 * @author Raolilin-2013.5.2
 *
 */
public class Client {
	public static void main(String[] args) {
		AbstractClass ac = new ConcreteClass();
		//调用模板方法
		ac.templateMethod();
	}

}
