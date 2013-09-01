package DesignPattern.CreationalPattern.Visitor;
/**
 * 访问者模式
 * @author Raolilin-2013.5.6
 *
 */
//结构对象角色
import java.util.*;
public class ObjectStructure {
	private Vector<Element> elements;
	public ObjectStructure() {
		this.elements = new Vector<Element> ();
	}
	//执行访问操作
	public void action(Visitor vi) {
		for(Element e : elements) {
			e.accept(vi);
		}
	}
	//添加新元素
	public void add(Element e) {
		elements.add(e);
	}
	//元素生成器，工厂方法
	public void createElements() {
		Random rand = new Random();
		for(int i=0; i<10; i++) {
			if(rand.nextInt(100) > 50) {
				this.add(new ConcreteElement1());
			} else {
				this.add(new ConcreteElement2());
			}
		}
	}
	
}
