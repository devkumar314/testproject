package tests.LambdaTest;
import java.util.*;

import org.testng.annotations.Test;

class Square {
	
	int sideLength;
	
	public Square(int sideLength) {
		this.sideLength = sideLength;
	}
	
	public int calculationArea() {
		return sideLength * sideLength;
	}

}

@FunctionalInterface
interface Shapes {
	
	public abstract int getArea(Square person);
	
}


public class LambdaTest {

	@Test
	public void myMethod() {


		Square s = new Square(4);
		
		Shapes shapes = (Square square) -> {
			return square.calculationArea();
		};

		System.out.println("Area : "+ shapes.getArea(s));
		
	}
	
	@Test
	public void MothodReferenceTest() {


		Square s = new Square(4);
		
		Shapes shapes = Square::calculationArea;

		System.out.println("Area : "+ shapes.getArea(s));
		
	}
	
	
	
}
