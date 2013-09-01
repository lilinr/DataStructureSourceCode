package DesignPattern.CreationalPattern.Observer;
/**
 * �۲���ģʽ
 * @author Raolilin-2013.5.5
 *
 */
public interface Subject {
	//�Ǽ�һ���µĹ۲���
	public void attach(Observer obs);
	//ɾ��һ���Ǽǹ��Ĺ۲���
	public void detach(Observer obs);
	//֪ͨ���еǼǹ��Ĺ۲��߶���
	public void notifyObserver();
}
