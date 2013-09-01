package DesignPattern.CreationalPattern.Singleton;
/**
 * ʵ�ְ��贴��ʵ��:
 * ֻ���ڵ�һ��ʹ��ʱ�ű�������
 * @author Raolilin 2013-8-25
 *
 */
public final class GoodSingleton {
	public static int data = 0;
	//���췽��˽�л������಻�ܱ��̳У����ܱ����ֱ��ʵ����
	private GoodSingleton() {
		System.out.println("GoodSingleton is used!");
	}	
	private static class GoodSingletonHolder {
		private static final GoodSingleton instance = new GoodSingleton();
		static {
			System.out.println("GoodSingletonHolder is used!");
		}
	}
	
	//ͨ���÷������ʵ������
	public static GoodSingleton getInstance() {
		return GoodSingletonHolder.instance;
	}
}
