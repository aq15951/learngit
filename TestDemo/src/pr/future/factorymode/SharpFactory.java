package pr.future.factorymode;

//定义一个形状工厂
public class SharpFactory {
	/**
	 * @param sharptype  类名
	 * @return 返回真实的类
	 */
	public Sharp getsharp(String sharptype) {
		if (null == sharptype) {
			return null;
		}
		if (sharptype.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		} else if (sharptype.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		} else {
			return null;
		}

	}
}
