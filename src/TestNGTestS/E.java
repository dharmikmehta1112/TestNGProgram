package TestNGTestS;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class E {

//	@BeforeTest
	@BeforeMethod
	public void me3() {
		System.out.println("Before Test of E");
	}

	@BeforeClass
	public void me2() {
		System.out.println("Before Class of E");
	}
/*	
	@Test
	public void me1() {
		System.out.println("I am m1 of E");
	}
*/
}