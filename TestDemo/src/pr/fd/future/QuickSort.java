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

	// 快速排序算法
	public static void quicksort(int[] a, int low, int high) {
		int start = low;
		int end = high;
		int key = a[low];// 选取的基准值
		while (end > start) {
			// 从后往前比较
			// 12, 20, 5, 16, 15, 1, 30, 45, 23, 9
			while (end > start && a[end] >= key) {
				// 如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
				end--;
			}
			if (a[end] <= key) {
				int temp = a[end];
				a[end] = a[start];
				a[start] = temp;
			}
			// 从前往后比较
			while (end > start && a[start] <= key) {
				// 如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
				start++;
			}
			if (a[start] >= key) {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
			}
			// 此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
		}
		// 递归
		if (start > low)
			quicksort(a, low, start - 1);// 左边序列。第一个索引位置到关键值索引-1
		if (end < high)
			quicksort(a, end + 1, high);// 右边序列。从关键值索引+1到最后一个
	}

	/*
	 * 排序的核心算法
	 * 
	 * @param array 待排序数组
	 * 
	 * @param startIndex 开始位置
	 * 
	 * @param endIndex 结束位置
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
	 * 交换并返回分界点
	 * 
	 * @param array 待排序数组
	 * 
	 * @param startIndex 开始位置
	 * 
	 * @param endIndex 结束位置
	 * 
	 * @return 分界点
	 */
	private static int boundary(int[] array, int startIndex, int endIndex) {
		int standard = array[startIndex]; // 定义标准
		int leftIndex = startIndex; // 左指针
		int rightIndex = endIndex; // 右指针

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
