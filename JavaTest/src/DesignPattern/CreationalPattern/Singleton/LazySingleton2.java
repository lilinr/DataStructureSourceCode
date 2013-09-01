package DesignPattern.CreationalPattern.Singleton;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ����ʽ������
 * ��ȱ�㣺�ڴ������ʽϸߣ����Ƿ�Ӧʱ���������ͬ�������ж�instanche�Ƿ�Ϊ�պʹ���ʵ����Ч�ʵͣ�
 * @author Raolilin 2013-8-25
 *
 */
public final class LazySingleton2 {
	private static LazySingleton2 instance;
	private final static ReentrantLock lock = new ReentrantLock();
	//���췽��˽�л������಻�ܱ��̳У����ܱ����ֱ��ʵ����
	private LazySingleton2() {

	}
	//ͨ���÷������ʵ������
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
