package DesignPattern.CreationalPattern.Adapter;
/**
 * ������ģʽ
 * @author Raolilin-2013.5.1
 *
 */
public class Adapter extends Adaptee implements Target {
	//��������
	public void request() {
		super.specificRequest();
	}

}
