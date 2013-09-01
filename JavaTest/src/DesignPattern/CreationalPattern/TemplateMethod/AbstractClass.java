package DesignPattern.CreationalPattern.TemplateMethod;
/**
 * 模板方法模式
 * @author Raolilin-2013.5.2
 *
 */
public abstract class AbstractClass {
	//基本方法
	protected abstract void operation();
	//模版方法
	public void templateMethod() {
		//调用基本方法，完成相关的业务逻辑
		this.operation();
	}
}
