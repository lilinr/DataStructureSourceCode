package DesignPattern.CreationalPattern.Singleton;
/**
 * 实现按需创建实例:
 * 只有在第一次使用时才被创建。
 * @author Raolilin 2013-8-25
 *
 */
public final class GoodSingleton {
	public static int data = 0;
	//构造方法私有化，该类不能被继承，不能被外界直接实例化
	private GoodSingleton() {
		System.out.println("GoodSingleton is used!");
	}	
	private static class GoodSingletonHolder {
		private static final GoodSingleton instance = new GoodSingleton();
		static {
			System.out.println("GoodSingletonHolder is used!");
		}
	}
	
	//通过该方法获得实例对象
	public static GoodSingleton getInstance() {
		return GoodSingletonHolder.instance;
	}
}
