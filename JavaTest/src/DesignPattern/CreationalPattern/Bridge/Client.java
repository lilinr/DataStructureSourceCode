package DesignPattern.CreationalPattern.Bridge;
/**
 * ����ģʽ
 * @author Raolilin-2013.5.1
 *
 */
public class Client {
	public static void main(String[] args) {
		//����һ��ʵ������ɫ
		Implementor imp = new ConcreteImplementor();
		//����һ�����󻯽�ɫ
		Abstraction abs = new RefinedAbstraction(imp);
		//ִ��
		abs.operation();
	}

}
