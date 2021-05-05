package TestNGTestS;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class B {

	@BeforeSuite
	public void mb4() {
		System.out.println("Before Suite of B");
	}
	
	@BeforeTest
	public void mb5() {
		System.out.println("Before Test of B");
	}

	@Test
	public void mb1() {
		System.out.println("I am m1 of B");
	}

	@Test
	public void mb2() {
		System.out.println("I am m1 of B");
	}

	@Test
	public void mb3() {
		System.out.println("I am m1 of B");
	}
}