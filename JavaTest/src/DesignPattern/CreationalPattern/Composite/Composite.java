package DesignPattern.CreationalPattern.Composite;

import java.util.ArrayList;

/**
 * ���ģʽ
 * @author Raolilin-2013.5.1
 *
 */
//������֦����
public class Composite implements Component {
	//��������
	private ArrayList<Component> componentList = new ArrayList<Component> ();
	//��ӹ���
	public void add(Component component) {
		this.componentList.add(component);
	}
	//ɾ������
	public void remove(Component component) {
		this.componentList.remove(component);
	}
	//��ȡ�ӹ���
	public ArrayList<Component> getChild() {
		return this.componentList;
	}
	
	public void operation() {
		//ҵ���߼�����
	}

}