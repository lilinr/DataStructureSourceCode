package DesignPattern.CreationalPattern.Builder;
/**
 * ������ģʽ
 * @author Raolilin 2013-04-26
 *
 */
public abstract class Builder {
	//���ò�Ʒ�Ĳ�ͬ�ɷ֣��Ի�ò�ͬ�Ĳ�Ʒ
	public abstract void setPart1();
	public abstract void setPart2();
	public abstract void setPart3();
	//����
	
	//�����Ʒ
	public abstract Product builderProduct();
}
