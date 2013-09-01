package DesignPattern.CreationalPattern.Visitor;
/**
 * 访问者模式
 * @author Raolilin-2013.5.6
 *
 */
//抽象元素角色
public abstract class Element {
	//接受操作
	public abstract void accept(Visitor vi);
}
