package pr.future.factorymode;

public class TestSharp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//简单工厂模式
		SharpFactory sf = new SharpFactory();

		Sharp c = sf.getsharp("Circle");
		Sharp rtl = sf.getsharp("Rectangle");

		c.draw();
		rtl.draw();

	}

}
