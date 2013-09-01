package DesignPattern.CreationalPattern.FactoryMethod;
/**
 * ��������ģʽ
 * @author RaoLilin 2013-04-25
 *
 */
public interface Creator {
	/**
	 * ��������
	 * ����һ����Ʒ����������������Ϳ�����������
	 */
	public <T extends Product> T factory(Class<T> c);
}
