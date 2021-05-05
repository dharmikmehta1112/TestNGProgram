package TestNGTestS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestQ {
	
	@BeforeMethod
	private void m1() {
		System.out.println("Inside Before Method");
	}
	
	@BeforeTest
	private void m2() {
		System.out.println("Inside Before Test");
	}

	@Test
	private void m3() {
		System.out.println("Inside Test m3");
	}

	@Test
	private void m4() {
		System.out.println("Inside Test m4");
	}

}