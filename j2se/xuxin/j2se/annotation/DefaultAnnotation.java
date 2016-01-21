package xuxin.j2se.annotation;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DefaultAnnotation {
	int getInt() default (6);
	String getString() default ("hello");
}
