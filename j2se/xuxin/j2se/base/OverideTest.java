package xuxin.j2se.base;

public class OverideTest {
	
}

class A {
	public float getNum() {
		return 0.1f;
	}
}

class B extends A {
	@Override
	public float getNum() {
		return 0.2f;
	}
	
	//参数不同
	public float getNum(float f) {
		return f;
	}
	
	//参数不同，以及返回值类型不同
	public double getNum(double d) {
		return 0.1d;
	}
	
}