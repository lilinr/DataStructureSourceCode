package DesignPattern.CreationalPattern.Proxy;
/**
 * 代理类模式
 * @author Raolilin-2013.4.30
 *
 */
public class ProxySubject implements Subject {
	private Subject subject;
	
	public ProxySubject(Subject subject) {
		this.subject = subject;
	}

	//实现请求方法
	public void request() {
		// TODO Auto-generated method stub
		this.beforeRequest();
		subject.request();
		this.afterRequest();
	}
	//请求前的操作
	private void beforeRequest() {
		//预处理
	}
	//请求后的操作
	private void afterRequest() {
		//善后处理
	}
}
