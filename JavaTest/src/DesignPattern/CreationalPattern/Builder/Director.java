package DesignPattern.CreationalPattern.Builder;
/**
 * 建造者模式
 * @author Raolilin 2013-04-26
 *
 */
public class Director {
	private Builder builder = new ConcreteBuilder1();
	
	//构造产品1，负责调用各个零件建造方法
	public Product1 buildProduct1() {
		builder.setPart1();
		builder.setPart2();
		builder.setPart3();
		
		return (Product1) builder.builderProduct();
	}
	//构造产品2，负责调用各个零件建造方法
	public Product2 buildProduct2() {
		builder.setPart1();
		builder.setPart2();
		builder.setPart3();
		
		return (Product2) builder.builderProduct();
	}
}
