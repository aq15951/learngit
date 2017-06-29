package pr.fd.future;

public class QuickSort {

	public static void main(String[] args) {

		int[] a = { 9, 20, 5, 16, 15, 1, 30, 45, 23, 12 };
		int start = 0;
		int end = a.length - 1;
		quicksort(a, start, end);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		sortCore(a, start, end);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	// ���������㷨
	public static void quicksort(int[] a, int low, int high) {
		int start = low;
		int end = high;
		int key = a[low];// ѡȡ�Ļ�׼ֵ
		while (end > start) {
			// �Ӻ���ǰ�Ƚ�
			// 12, 20, 5, 16, 15, 1, 30, 45, 23, 9
			while (end > start && a[end] >= key) {
				// ���û�бȹؼ�ֵС�ģ��Ƚ���һ����ֱ���бȹؼ�ֵС�Ľ���λ�ã�Ȼ���ִ�ǰ����Ƚ�
				end--;
			}
			if (a[end] <= key) {
				int temp = a[end];
				a[end] = a[start];
				a[start] = temp;
			}
			// ��ǰ����Ƚ�
			while (end > start && a[start] <= key) {
				// ���û�бȹؼ�ֵ��ģ��Ƚ���һ����ֱ���бȹؼ�ֵ��Ľ���λ��
				start++;
			}
			if (a[start] >= key) {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
			}
			// ��ʱ��һ��ѭ���ȽϽ������ؼ�ֵ��λ���Ѿ�ȷ���ˡ���ߵ�ֵ���ȹؼ�ֵС���ұߵ�ֵ���ȹؼ�ֵ�󣬵������ߵ�˳���п����ǲ�һ���ģ���������ĵݹ����
		}
		// �ݹ�
		if (start > low)
			quicksort(a, low, start - 1);// ������С���һ������λ�õ��ؼ�ֵ����-1
		if (end < high)
			quicksort(a, end + 1, high);// �ұ����С��ӹؼ�ֵ����+1�����һ��
	}

	/*
	 * ����ĺ����㷨
	 * 
	 * @param array ����������
	 * 
	 * @param startIndex ��ʼλ��
	 * 
	 * @param endIndex ����λ��
	 */
	public static void sortCore(int[] array, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}

		int boundary = boundary(array, startIndex, endIndex);

		sortCore(array, startIndex, boundary - 1);
		sortCore(array, boundary + 1, endIndex);
	}

	/*
	 * ���������طֽ��
	 * 
	 * @param array ����������
	 * 
	 * @param startIndex ��ʼλ��
	 * 
	 * @param endIndex ����λ��
	 * 
	 * @return �ֽ��
	 */
	private static int boundary(int[] array, int startIndex, int endIndex) {
		int standard = array[startIndex]; // �����׼
		int leftIndex = startIndex; // ��ָ��
		int rightIndex = endIndex; // ��ָ��

		while (leftIndex < rightIndex) {
			while (leftIndex < rightIndex && array[rightIndex] >= standard) {
				rightIndex--;
			}
			array[leftIndex] = array[rightIndex];

			while (leftIndex < rightIndex && array[leftIndex] <= standard) {
				leftIndex++;
			}
			array[rightIndex] = array[leftIndex];
		}

		array[leftIndex] = standard;
		return leftIndex;
	}
	
	

}
