package DesignPattern.CreationalPattern.Builder;
/**
 * 建造者模式
 * @author Raolilin 2013-04-26
 *
 */
public class ConcreteBuilder1 extends Builder {
	private Product1 product = new Product1();
	@Override
	public Product1 builderProduct() {
		// 建造一个产品
		return product;
	}

	@Override
	public void setPart1() {
		// 为product安装部件1

	}

	@Override
	public void setPart2() {
		// 为product安装部件2

	}

	@Override
	public void setPart3() {
		// 为product安装部件2

	}

}
