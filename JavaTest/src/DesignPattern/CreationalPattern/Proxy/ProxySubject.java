package DesignPattern.CreationalPattern.Proxy;
/**
 * ������ģʽ
 * @author Raolilin-2013.4.30
 *
 */
public class ProxySubject implements Subject {
	private Subject subject;
	
	public ProxySubject(Subject subject) {
		this.subject = subject;
	}

	//ʵ�����󷽷�
	public void request() {
		// TODO Auto-generated method stub
		this.beforeRequest();
		subject.request();
		this.afterRequest();
	}
	//����ǰ�Ĳ���
	private void beforeRequest() {
		//Ԥ����
	}
	//�����Ĳ���
	private void afterRequest() {
		//�ƺ���
	}
}
