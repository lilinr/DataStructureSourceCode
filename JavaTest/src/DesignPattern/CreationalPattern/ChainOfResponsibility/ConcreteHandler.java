package DesignPattern.CreationalPattern.ChainOfResponsibility;
/**
 * ������ģʽ
 * @author Raolilin-2013.5.4
 *
 */
public class ConcreteHandler extends Handler {
	//��������
	public void handleRequest() {
		if(getSuccessor() != null) {
			System.out.println("���󴫵ݸ�" + getSuccessor());
			getSuccessor().handleRequest();
		} else {
			System.out.println("��������");
		}
	}

}
