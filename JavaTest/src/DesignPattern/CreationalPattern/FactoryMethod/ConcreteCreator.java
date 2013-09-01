package DesignPattern.CreationalPattern.FactoryMethod;
/**
 * ��������ģʽ
 * @author RaoLilin 2013-04-25
 *
 */
public class ConcreteCreator implements Creator {

	@Override
	public <T extends Product> T factory(Class<T> c) {
		// TODO Auto-generated method stub
		Product product = null;
		try {
			product = (Product) Class.forName(c.getName()).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (T) product;
	}

}
