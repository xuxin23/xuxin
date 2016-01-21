package xuxin.j2se.data;

/**
 * @author xuxin
 * @version 1.1 xuxin 2013-8-23 update
 */
public class ArraySort {
	
	// 冒泡排序
	public static int[] bubbleSort(int[] arr) {
		for (int i=0; i<arr.length-1; i++) {
			for (int j=0; j<arr.length-1-i; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	} 
	
	// 选择排序
	public static int[] selectedSort(int[] arr) {
		for (int i=0; i<arr.length-1;i++) {
			int mark = i;
			for (int j=i+1; j<arr.length; j++) {
				if (arr[mark] > arr[j]) {
					mark = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[mark];
			arr[mark] = temp;
		}
		return arr;
	}
	
	// 插入排序
	public static int[] insertSort(int[] arr) {
		for (int i=1; i<arr.length; i++) {
			int mark = i;
			for (int j=i-1; j>=0; j--) {
				if (arr[mark] < arr[j]) {
					int temp = arr[mark];
					arr[mark] = arr[j];
					arr[j] = temp;
					mark = j;
				} else {
					break;
				}
			}
		}
		return arr;
	}
}
