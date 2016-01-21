package xuxin.j2se.data;
/*
 * 栈的应用：分隔符匹配
 * */
public class SeperateCheck {
	
	private CharStack stack;
	
	public SeperateCheck() {
		stack = new CharStack(50);
	}
	
	//核对数组中的每一个字符
	public void check(char[] c) throws Exception {
		for (int i=0; i<c.length; i++) {
			this.wrap(c[i]);
		}
	}
	
	//左括号的压栈，右括号的与栈顶的元素比较，其它不作为。
	private void wrap(char e) throws Exception {
		switch (e) {
		case '{':stack.push(e);break;
		case '}':this.compare(e, stack.pop());break;
		case '[':stack.push(e);break;
		case ']':this.compare(e, stack.pop());break;
		case '(':stack.push(e);break;
		case ')':this.compare(e, stack.pop());break;
		default:break;
		}
	}
	
	//比较右括号与栈顶的元素是否匹配，不匹配则抛出异常。
	private void compare(char a,char b) throws Exception{
		boolean flag = false;
		if (a == ')' && b == '(') {
			flag = true;
		}
		if (a == ']' && b == '[') {
			flag = true;
		}
		if (a == '}' && b == '{') {
			flag = true;
		}
		if (flag == false) throw new Exception("分隔符不匹配!");
	}
}
