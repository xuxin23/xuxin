package xuxin.j2se.data;

/*
 * 二分法查找数组
 * 注意：必须是有序数组
 * */
public class twoFind {
	public static void find(int[] arr, int value) {
		int low = 0;	// 低位
		int high = arr.length - 1;	// 高位
		int mid;	// 中间位
		int count = 0;	// 查找次数
		int index = 0;	// 目标位置
		boolean isFound = false;	// 是否找到
		boolean flag = true;	// 循环标识
		
		while (flag) {
			count++;
			mid = (low + high) / 2;
			if (arr[mid] < value) {
				low = mid;
			}else if (arr[mid] > value) {
				high = mid;
			}else if (arr[mid] == value) {
				index = mid;
				isFound = true;
				flag = false;
			}
			if (high - low <= 1) {
				if (arr[high] == value) {
					index = high;
					isFound = true;
				}
				else if (arr[low] == value) {
					index = low;
					isFound = true;
				}
				flag = false;
			}
		}
		
		if (isFound) {
			System.out.println("用了" + count + "次在数组的第" + index + "位找到目的数字" + value);
		} else {
			System.out.println("未找到目的数字" + value);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,14,15,23,25,29,46,65,67,76,88,89,92,97,102,104,105,203,245,265,289,306,307,345,678};
		find(arr, 1);
		find(arr, 14);
		find(arr, 88);
		find(arr, 678);
		find(arr, 33);
	}
}
