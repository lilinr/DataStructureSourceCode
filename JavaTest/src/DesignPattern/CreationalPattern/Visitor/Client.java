package DesignPattern.CreationalPattern.Visitor;
/**
 * ������ģʽ
 * @author Raolilin-2013.5.6
 *
 */
public class Client {

	public static void main(String[] args) {
		ObjectStructure os = new ObjectStructure();
		os.createElements();
		Visitor vi = new ConcreteVisitor();
		os.action(vi);
	}

}
