package DesignPattern.CreationalPattern.Strategy;
/**
 * 策略模式
 * @author Raolilin-2013.5.4
 *
 */
//环境角色
public class Context {
	private Strategy strategy = null;
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}
	//调用策略方法
	public void contextInterface() {
		this.strategy.strategyInterface();
	}
}
