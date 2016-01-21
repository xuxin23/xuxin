package xuxin.j2se.data;

/*
 * 单词逆序---用数组实现栈
 * 原理：数组为私有，只能通过public方法操作数组。
 * top指向数组的位置随着方法的调用而移动。
 * 一句话就是，让你不能直接访问数组，而只能调用
 * public方法移动top指向数组的位置来获取值。
 * */
public class CharStack {
	
	private int maxSize;
	private char[] arr;
	//top是关键，好好体会。
	private int top;
	
	public CharStack(int maxSize) {
		this.maxSize = maxSize;
		arr = new char[maxSize];
		top = -1;
	}
	
	//压栈
	public void push(char c) {
		arr[++top] = c;
	}
	
	//出栈
	public char pop() {
		return arr[top--];
	}
	
	//查看栈顶元素
	public char peek() {
		return arr[top];
	}
	
	//判断栈是否为空
	public boolean isEmpty() {
		return top == -1;
	}
	
	//判断栈是否已满
	public boolean isFull() {
		return top == maxSize-1;
	}
	
	//测试，将字符数组反向输出
	public static void main(String[] args) {
		CharStack stack = new CharStack(20);
		String str = "aBcdeFGHiJkLmNopqrst";
		char[] c = str.toCharArray();
		
		for (int i=0; i<c.length; i++) {
			if (!stack.isFull()) {
				stack.push(c[i]);
			}else {
				break;
			}
		}
		
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}
