package DesignPattern.CreationalPattern.Strategy;
/**
 * ����ģʽ
 * @author Raolilin-2013.5.4
 *
 */
//������ɫ
public class Context {
	private Strategy strategy = null;
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}
	//���ò��Է���
	public void contextInterface() {
		this.strategy.strategyInterface();
	}
}
