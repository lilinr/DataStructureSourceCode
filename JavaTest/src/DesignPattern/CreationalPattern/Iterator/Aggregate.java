package DesignPattern.CreationalPattern.Iterator;
/**
 * ������ģʽ
 * @author Raolilin-2013.5.4
 *
 */
public interface Aggregate {
	public void add(Object obj);
	public Iterator createIterator();
}
