package DesignPattern.CreationalPattern.Bridge;
/**
 * ����ģʽ
 * @author Raolilin-2013.5.1
 *
 */
//���󻯽�ɫ
public abstract class Abstraction {
	//�����ʵ������ɫ������
	private Implementor imp;
	public Abstraction(Implementor imp) {
		this.imp = imp;
	}
	//ҵ�񷽷�
	public void operation() {
		this.imp.operationImp();
	}
}
