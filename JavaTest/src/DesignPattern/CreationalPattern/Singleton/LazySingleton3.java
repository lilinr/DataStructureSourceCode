package DesignPattern.CreationalPattern.Singleton;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ����ʽ������
 * ��ȱ�㣺�ڴ������ʽϸߣ�
 * ��Ӧʱ��Ϻ�һЩ����ͬ����ǰ�������ж�ʵ���Ƿ���ڣ�
 * ����ֻ����ʵ����û�д���֮ǰ�����������Ա�ֻ֤��һ���̴߳�����ʵ����
 * ����ʵ���Ѿ�����֮�������Ѿ�����Ҫ�������������ˣ�
 * ����ʵ�ֽ�Ϊ���ӡ�
 * @author Raolilin 2013-8-25
 *
 */
public final class LazySingleton3 {
	private static LazySingleton3 instance;
	private final static ReentrantLock lock = new ReentrantLock();
	//���췽��˽�л������಻�ܱ��̳У����ܱ����ֱ��ʵ����
	private LazySingleton3() {

	}
	//ͨ���÷������ʵ������
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
