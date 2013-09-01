package DesignPattern.CreationalPattern.AbstractFactory;
/**
 * 抽象工厂模式
 * @author RaoLilin 2013-04-25
 *
 */
public class ConcreteFactory2 implements AbstractFactory {

	@Override
	public ProductA factoryA() {
		// TODO Auto-generated method stub
		//创建等级为2的产品A
		return new ProductA2();
	}

	@Override
	public ProductB factoryB() {
		// TODO Auto-generated method stub
		//创建等级为2的产品B
		return new ProductB2();
	}

}
