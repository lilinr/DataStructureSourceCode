package DesignPattern.CreationalPattern.Adapter;
/**
 * ������ģʽ
 * @author Raolilin-2013.5.1
 *
 */
public class Client {
	public static void main(String[] args) {
		//������ģʽӦ��
		Target target = new Adapter();
		target.request();
	}
}
