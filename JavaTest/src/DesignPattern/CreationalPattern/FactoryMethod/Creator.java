package DesignPattern.CreationalPattern.FactoryMethod;
/**
 * 工厂方法模式
 * @author RaoLilin 2013-04-25
 *
 */
public interface Creator {
	/**
	 * 工厂方法
	 * 创建一个产品对象，其输入参数类型可以自行设置
	 */
	public <T extends Product> T factory(Class<T> c);
}
