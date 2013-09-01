package DesignPattern.CreationalPattern.Iterator;
/**
 * ������ģʽ
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
	//�Ƿ�����һ��Ԫ��
	public boolean hasNext() {
		return index < size;
	}
	//������һ��Ԫ��
	public Object next() {
		if(index < size) {
			return agg.getElement(index++);
		} else {
			return null;
		}
	}
}
