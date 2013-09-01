package DesignPattern.CreationalPattern.Decorator;
/**
 * в╟йндёй╫
 * @author Raolilin-2013.4.30
 *
 */
public abstract class Decorator implements Component {
	private Component componemt = null;
	public Decorator(Component component) {
		this.componemt = component;
	}
	public void operation() {
		this.componemt.operation();
	}

}
