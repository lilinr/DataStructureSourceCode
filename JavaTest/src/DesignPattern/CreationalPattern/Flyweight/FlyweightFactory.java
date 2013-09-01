package DesignPattern.CreationalPattern.Flyweight;
/**
 * ÏíÔªÄ£Ê½
 * @author Raolilin-2013.5.1
 *
 */
import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
	private static Map<String, Flyweight> pool = new HashMap<String, Flyweight>();
	private FlyweightFactory() {
		
	}
	
	public static Flyweight getFlyweight(String intrinsicState) {
		Flyweight flyweight = pool.get(intrinsicState);
		if(flyweight == null) {
			flyweight = new ConcreteFlyweight(intrinsicState);
			pool.put(intrinsicState, flyweight);
		}
		return flyweight;
	}
}
