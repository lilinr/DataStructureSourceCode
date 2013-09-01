package DesignPattern.CreationalPattern.Singleton;

/**
 * ����ʽ������
 * ��ȱ�㣺��Ӧʱ���ϽϿ죬�����ڴ������ʵ͡�
 * @author Raolilin 2013-04-24
 */
public final class HungrySingleton {
	private static HungrySingleton instance = new HungrySingleton();
	//���췽��˽�л������಻�ܱ��̳У����ܱ����ֱ��ʵ����
	private HungrySingleton() {

	}
	//ͨ���÷������ʵ������
	public static HungrySingleton getInstance() {
		return instance;
	}
}
