package DesignPattern.CreationalPattern.Adapter;
/**
 * 适配器模式
 * @author Raolilin-2013.5.1
 *
 */
public class Adapter extends Adaptee implements Target {
	//进行适配
	public void request() {
		super.specificRequest();
	}

}
