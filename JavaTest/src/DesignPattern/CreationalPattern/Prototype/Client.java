package DesignPattern.CreationalPattern.Prototype;
/**
 * ԭ��ģʽ
 * @author Raolilin 2013-04-28
 *
 */
public class Client {
	public void operation(Prototype example) {
		Prototype p = example.clone();
	}
}
