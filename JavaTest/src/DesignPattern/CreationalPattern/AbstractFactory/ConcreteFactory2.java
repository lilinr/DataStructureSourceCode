package DesignPattern.CreationalPattern.AbstractFactory;
/**
 * ���󹤳�ģʽ
 * @author RaoLilin 2013-04-25
 *
 */
public class ConcreteFactory2 implements AbstractFactory {

	@Override
	public ProductA factoryA() {
		// TODO Auto-generated method stub
		//�����ȼ�Ϊ2�Ĳ�ƷA
		return new ProductA2();
	}

	@Override
	public ProductB factoryB() {
		// TODO Auto-generated method stub
		//�����ȼ�Ϊ2�Ĳ�ƷB
		return new ProductB2();
	}

}
