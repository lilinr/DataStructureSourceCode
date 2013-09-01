package DesignPattern.CreationalPattern.Flyweight;
/**
 * 享元模式
 * @author Raolilin-2013.5.1
 *
 */
public class ConcreteFlyweight implements Flyweight {
	private String intrinsicState;//内部状态
	
	public ConcreteFlyweight(String intrinsicState) {
		this.intrinsicState = intrinsicState;
	}
	
	public void operation(String extrinsicState) {
		System.out.println("内部状态：" + intrinsicState + "外部状态：" + extrinsicState);
	}

}
