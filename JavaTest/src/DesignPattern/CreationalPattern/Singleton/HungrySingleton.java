package DesignPattern.CreationalPattern.Singleton;

/**
 * 饿汉式单例类
 * 优缺点：响应时间上较快，但是内存利用率低。
 * @author Raolilin 2013-04-24
 */
public final class HungrySingleton {
	private static HungrySingleton instance = new HungrySingleton();
	//构造方法私有化，该类不能被继承，不能被外界直接实例化
	private HungrySingleton() {

	}
	//通过该方法获得实例对象
	public static HungrySingleton getInstance() {
		return instance;
	}
}
