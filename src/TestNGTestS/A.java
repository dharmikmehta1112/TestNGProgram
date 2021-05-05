package TestNGTestS;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class A {

	@BeforeSuite
	public void ma4() {
		System.out.println("Before Suite of A");
	}

	@BeforeTest
	public void ma5() {
		System.out.println("Before Test of A");
	}

	@Test
	public void ma1() {
		System.out.println("I am m1 of A");
	}

	@Test
	public void ma2() {
		System.out.println("I am m1 of A");
	}

	@Test
	public void ma3() {
		System.out.println("I am m1 of A");
	}
}