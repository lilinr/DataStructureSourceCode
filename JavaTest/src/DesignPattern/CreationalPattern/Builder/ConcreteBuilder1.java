package DesignPattern.CreationalPattern.Builder;
/**
 * ������ģʽ
 * @author Raolilin 2013-04-26
 *
 */
public class ConcreteBuilder1 extends Builder {
	private Product1 product = new Product1();
	@Override
	public Product1 builderProduct() {
		// ����һ����Ʒ
		return product;
	}

	@Override
	public void setPart1() {
		// Ϊproduct��װ����1

	}

	@Override
	public void setPart2() {
		// Ϊproduct��װ����2

	}

	@Override
	public void setPart3() {
		// Ϊproduct��װ����2

	}

}
