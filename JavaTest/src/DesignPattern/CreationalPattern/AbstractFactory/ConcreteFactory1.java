package DesignPattern.CreationalPattern.AbstractFactory;
/**
 * ���󹤳�ģʽ
 * @author RaoLilin 2013-04-25
 *
 */
public class ConcreteFactory1 implements AbstractFactory {

	@Override
	public ProductA factoryA() {
		// TODO Auto-generated method stub
		//�����ȼ�Ϊ1�Ĳ�ƷA
		return new ProductA1();
	}

	@Override
	public ProductB factoryB() {
		// TODO Auto-generated method stub
		//�����ȼ�Ϊ1�Ĳ�ƷB
		return new ProductB1();
	}

}
