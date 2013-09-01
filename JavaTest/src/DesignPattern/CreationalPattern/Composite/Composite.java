package DesignPattern.CreationalPattern.Composite;

import java.util.ArrayList;

/**
 * 组合模式
 * @author Raolilin-2013.5.1
 *
 */
//定义树枝构件
public class Composite implements Component {
	//构件容器
	private ArrayList<Component> componentList = new ArrayList<Component> ();
	//添加构件
	public void add(Component component) {
		this.componentList.add(component);
	}
	//删除构件
	public void remove(Component component) {
		this.componentList.remove(component);
	}
	//获取子构件
	public ArrayList<Component> getChild() {
		return this.componentList;
	}
	
	public void operation() {
		//业务逻辑代码
	}

}