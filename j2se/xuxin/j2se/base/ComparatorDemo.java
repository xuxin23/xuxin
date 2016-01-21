package xuxin.j2se.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;
/**
 * 这里介绍Comparator<T>接口的使用
 * 首先说下，Collections.sort(List list,Comaprator c)中通过传入比较器来让
 * Collection.sort来排序，这样可以通过传入不同的比较器对同一类对象从
 * 多个不同的角度来进行比较排序
 * @author Administrator
 *
 */
public class ComparatorDemo{
    
    @Test
    public void test() {
        ArrayList<Product2> list = new ArrayList<Product2>();
        list.add(new Product2("A",150,4,2200));
        list.add(new Product2("B",160,5,1800));
        list.add(new Product2("C",170,3,1900));
        
        ArrayList<Comparator<Product2>> comparatorList = new ArrayList<Comparator<Product2>>();
        comparatorList.add(new PriceComparator());
        comparatorList.add(new WeightComparator());
        comparatorList.add(new SpeedComparator());
        
        for (Comparator<Product2> c: comparatorList) {
            Collections.sort(list, c);
            for (Product2 p:list) {
                System.out.println(p);
            }
            System.out.println("---------------------------");
        }
    }
	
}

//一个用于比较的对象(调用不同的比较器从多方面进行比较)
class Product2 {
    private String name;
	private int price;
	private int weight;
	private int speed;
	
	public Product2(String name, int price, int weight, int speed) {
	    this.name = name;
	    this.price = price;
	    this.weight = weight;
	    this.speed =  speed;
	}
	
	public String toString() {
	    return "{name=" + name + ", price=" + price + ", weight=" + weight + ", speed=" + speed + "}";
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
	
	
}

//价格比较器
class PriceComparator implements Comparator<Product2>{

	public int compare(Product2 p1, Product2 p2) {
		if (p1 instanceof Product2) {
			return p1.getPrice() - p2.getPrice();
		}
		return 0;
	}
}

//重量比较器
class WeightComparator implements Comparator<Product2> {

	public int compare(Product2 p1, Product2 p2) {
		if (p1 instanceof Product2) {
			return p1.getWeight() - p2.getWeight();
		}
		return 0;
	}
}

//速度比较器
class SpeedComparator implements Comparator<Product2> {
	
	public int compare(Product2 p1, Product2 p2) {
		if (p1 instanceof Product2) {
			return p1.getSpeed() - p2.getSpeed();
		}
		return 0;
	}
}