package DesignPattern.CreationalPattern.Iterator;
/**
 * 迭代器模式
 * @author Raolilin-2013.5.4
 *
 */
public class ConcreteIterator implements Iterator {
	private ConcreteAggregate agg;
	private int index = 0;
	private int size = 0;
	public ConcreteIterator(ConcreteAggregate agg) {
		this.agg = agg;
		size = agg.size();
		index = 0;
	}
	//是否有下一个元素
	public boolean hasNext() {
		return index < size;
	}
	//返回下一个元素
	public Object next() {
		if(index < size) {
			return agg.getElement(index++);
		} else {
			return null;
		}
	}
}
