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

		System.out.println("����Ҫ���ҵ���:");
		int findvalue = input.nextInt();
		
	 	int value = dicotomy(arr, start, end, findvalue);

		 System.out.println(arr[value]+" "+count);
		 input.close();
	}

	/**
	 * @param arr
	 *            ��������������
	 * @param start
	 *            ��ʼ������
	 * @param end
	 *            ����������
	 * @param findvalue
	 *            ��Ҫ���ҵ�ֵ
	 * @return ���ز��ҵ��� ������
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
			// ������ҵ�ֵ�����м��ֵ��˵��Ҫ���ҵ� ֵ�ں���
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
