package DesignPattern.CreationalPattern.Singleton;

/**
 * 懒汉式单例类
 * 优缺点：内存利用率较高，但是反应时间较慢（整个getInstance方法是同步方法，效率低）
 * @author Raolilin 2013-04-24
 */
public final class LazySingleton1 {
	private static LazySingleton1 instance;
	//构造方法私有化，该类不能被继承，不能被外界直接实例化
	private LazySingleton1() {

	}
	//通过该方法获得实例对象
	public static synchronized LazySingleton1 getInstance() {
		if (instance == null) {
			instance = new LazySingleton1();
		}
		return instance;
	}
}
