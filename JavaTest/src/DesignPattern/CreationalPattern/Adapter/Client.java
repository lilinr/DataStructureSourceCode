package DesignPattern.CreationalPattern.Adapter;
/**
 * 适配器模式
 * @author Raolilin-2013.5.1
 *
 */
public class Client {
	public static void main(String[] args) {
		//适配器模式应用
		Target target = new Adapter();
		target.request();
	}
}
