package pr.fd.future;

import java.util.Scanner;

public class Dicotomy {

	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int arr[] = new int[10000];
		for (int i = 0; i < 10000; i++) {
			arr[i] = i+1;
		}
		int start = 0;
		int end = arr.length - 1;

		System.out.println("输入要查找的数:");
		int findvalue = input.nextInt();
		
	 	int value = dicotomy(arr, start, end, findvalue);

		 System.out.println(arr[value]+" "+count);
		 input.close();
	}

	/**
	 * @param arr
	 *            传入的有序的数组
	 * @param start
	 *            开始的索引
	 * @param end
	 *            结束的索引
	 * @param findvalue
	 *            需要查找的值
	 * @return 返回查找的数 的索引
	 */
	public static int dicotomy(int[] arr, int start, int end, int findvalue) {
		if (arr == null) {
			return -1;
		}
		count++;
		if (start <= end) {
			int mid = ( start+end) / 2;
			if (findvalue == arr[mid]) {
				return mid;
			}
			// 如果查找的值大于中间的值，说明要查找的 值在后半段
			else if (findvalue >= arr[mid]) {
				return dicotomy(arr, mid + 1, end, findvalue);
			} else  {
				return dicotomy(arr, start, mid - 1, findvalue);
			}
		} else {
			return -1;
		}
	}

}
