package DesignPattern.CreationalPattern.Visitor;
/**
 * ������ģʽ
 * @author Raolilin-2013.5.6
 *
 */
//�ṹ�����ɫ
import java.util.*;
public class ObjectStructure {
	private Vector<Element> elements;
	public ObjectStructure() {
		this.elements = new Vector<Element> ();
	}
	//ִ�з��ʲ���
	public void action(Visitor vi) {
		for(Element e : elements) {
			e.accept(vi);
		}
	}
	//�����Ԫ��
	public void add(Element e) {
		elements.add(e);
	}
	//Ԫ������������������
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
