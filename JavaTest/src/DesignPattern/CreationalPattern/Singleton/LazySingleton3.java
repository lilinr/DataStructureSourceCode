package DesignPattern.CreationalPattern.Singleton;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 懒汉式单例类
 * 优缺点：内存利用率较高，
 * 反应时间较好一些（加同步锁前后两次判断实例是否存在：
 * 我们只是在实例还没有创建之前加锁操作，以保证只有一个线程创建出实例；
 * 而当实例已经创建之后，我们已经不需要再做加锁操作了）
 * 代码实现较为复杂。
 * @author Raolilin 2013-8-25
 *
 */
public final class LazySingleton3 {
	private static LazySingleton3 instance;
	private final static ReentrantLock lock = new ReentrantLock();
	//构造方法私有化，该类不能被继承，不能被外界直接实例化
	private LazySingleton3() {

	}
	//通过该方法获得实例对象
	public static synchronized LazySingleton3 getInstance() {
		if (instance == null) {
			lock.lock();
			try {
				if (instance == null) {
					instance = new LazySingleton3();
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
		}
		return instance;
	}
}
