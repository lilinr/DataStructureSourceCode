package DesignPattern.CreationalPattern.Builder;
/**
 * ������ģʽ
 * @author Raolilin 2013-04-26
 *
 */
public class Director {
	private Builder builder = new ConcreteBuilder1();
	
	//�����Ʒ1��������ø���������췽��
	public Product1 buildProduct1() {
		builder.setPart1();
		builder.setPart2();
		builder.setPart3();
		
		return (Product1) builder.builderProduct();
	}
	//�����Ʒ2��������ø���������췽��
	public Product2 buildProduct2() {
		builder.setPart1();
		builder.setPart2();
		builder.setPart3();
		
		return (Product2) builder.builderProduct();
	}
}
