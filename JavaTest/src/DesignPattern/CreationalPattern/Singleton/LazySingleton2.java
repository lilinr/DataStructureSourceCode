package DesignPattern.CreationalPattern.Singleton;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 懒汉式单例类
 * 优缺点：内存利用率较高，但是反应时间较慢（加同步锁在判断instanche是否为空和创建实例，效率低）
 * @author Raolilin 2013-8-25
 *
 */
public final class LazySingleton2 {
	private static LazySingleton2 instance;
	private final static ReentrantLock lock = new ReentrantLock();
	//构造方法私有化，该类不能被继承，不能被外界直接实例化
	private LazySingleton2() {

	}
	//通过该方法获得实例对象
	public static synchronized LazySingleton2 getInstance() {
		lock.lock();
		try {
			if (instance == null) {
				instance = new LazySingleton2();
			}
		} finally {
			lock.unlock();
		}
		/*another method
		synchronized(LazySingleton2.class) {
			if (instance == null) {
				instance = new LazySingleton2();
			}
		}
		*/
		return instance;
	}
}
