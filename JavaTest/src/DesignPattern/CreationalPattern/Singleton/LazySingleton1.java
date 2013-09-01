package DesignPattern.CreationalPattern.Singleton;

/**
 * ����ʽ������
 * ��ȱ�㣺�ڴ������ʽϸߣ����Ƿ�Ӧʱ�����������getInstance������ͬ��������Ч�ʵͣ�
 * @author Raolilin 2013-04-24
 */
public final class LazySingleton1 {
	private static LazySingleton1 instance;
	//���췽��˽�л������಻�ܱ��̳У����ܱ����ֱ��ʵ����
	private LazySingleton1() {

	}
	//ͨ���÷������ʵ������
	public static synchronized LazySingleton1 getInstance() {
		if (instance == null) {
			instance = new LazySingleton1();
		}
		return instance;
	}
}
