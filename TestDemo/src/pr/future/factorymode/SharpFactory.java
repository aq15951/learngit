package pr.future.factorymode;

//����һ����״����
public class SharpFactory {
	/**
	 * @param sharptype  ����
	 * @return ������ʵ����
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
