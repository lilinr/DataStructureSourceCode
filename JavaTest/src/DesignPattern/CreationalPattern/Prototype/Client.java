package DesignPattern.CreationalPattern.Prototype;
/**
 * 原型模式
 * @author Raolilin 2013-04-28
 *
 */
public class Client {
	public void operation(Prototype example) {
		Prototype p = example.clone();
	}
}
