package DesignPattern.CreationalPattern.Builder;
/**
 * 建造者模式
 * @author Raolilin 2013-04-26
 *
 */
public abstract class Builder {
	//设置产品的不同成分，以获得不同的产品
	public abstract void setPart1();
	public abstract void setPart2();
	public abstract void setPart3();
	//……
	
	//建造产品
	public abstract Product builderProduct();
}
