package DesignPattern.CreationalPattern.TemplateMethod;
/**
 * ģ�巽��ģʽ
 * @author Raolilin-2013.5.2
 *
 */
public class Client {
	public static void main(String[] args) {
		AbstractClass ac = new ConcreteClass();
		//����ģ�巽��
		ac.templateMethod();
	}

}
