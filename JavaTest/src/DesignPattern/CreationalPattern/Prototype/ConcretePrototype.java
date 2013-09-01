package DesignPattern.CreationalPattern.Prototype;
/**
 * ԭ��ģʽ
 * @author Raolilin 2013-04-28
 *
 */
public class ConcretePrototype implements Prototype {

	@Override
	public Prototype clone()  {
		try {
			return (Prototype) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
