package DesignPattern.CreationalPattern.TemplateMethod;
/**
 * ģ�巽��ģʽ
 * @author Raolilin-2013.5.2
 *
 */
public abstract class AbstractClass {
	//��������
	protected abstract void operation();
	//ģ�淽��
	public void templateMethod() {
		//���û��������������ص�ҵ���߼�
		this.operation();
	}
}
