package xuxin.j2se.base;

import org.junit.Test;

public class EnumTest {
	@Test
	public void testA() {
	    Color black = Color.Black;
	    System.out.println(black + ":\t" + black.getValue());
	    
	    Color yellow = Enum.valueOf(Color.class, "Yellow");
	    System.out.println(yellow + ":\t" + yellow.getValue());
	}
	
}

enum Color {
	White("my color is white"),Black("my color is black"),
	Yellow("my color is yellow");
	
	private String value;
	
	private Color(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
