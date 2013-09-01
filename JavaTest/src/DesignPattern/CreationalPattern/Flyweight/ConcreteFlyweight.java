package DesignPattern.CreationalPattern.Flyweight;
/**
 * ��Ԫģʽ
 * @author Raolilin-2013.5.1
 *
 */
public class ConcreteFlyweight implements Flyweight {
	private String intrinsicState;//�ڲ�״̬
	
	public ConcreteFlyweight(String intrinsicState) {
		this.intrinsicState = intrinsicState;
	}
	
	public void operation(String extrinsicState) {
		System.out.println("�ڲ�״̬��" + intrinsicState + "�ⲿ״̬��" + extrinsicState);
	}

}
