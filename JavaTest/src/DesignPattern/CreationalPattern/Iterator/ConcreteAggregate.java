package DesignPattern.CreationalPattern.Iterator;



/**
 * µü´úÆ÷Ä£Ê½
 * @author Raolilin-2013.5.4
 *
 */

import java.util.Vector;
public class ConcreteAggregate implements Aggregate {
	private Vector vector = new Vector();
	
	public void add(Object obj) {
		this.vector.add(obj);
	}
	
	public Object getElement(int index) {
		if(index < vector.size()) {
			return vector.get(index);
		} else {
			return null;
		}
	}
	
	public int size() {
		return this.vector.size();
	}

	public Iterator createIterator() {
		return new ConcreteIterator(this);
	}
}
