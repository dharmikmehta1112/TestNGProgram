package TestNGTestS;

import org.testng.annotations.Test;

/**
 * @author Dharmik Mehta
 */
public class TestArgsOrParams {
	@Test(groups = {"regression"}, dependsOnMethods = {"m4", "m3"})
	public void m1() {
		System.out.println("method m1");
	}
	@Test
	public void m2() {
		System.out.println("method m2");
	}
	@Test
	public void m3() {
		System.out.println("method m3");
	}
	@Test
	public void m4() {
		System.out.println("method m4");
	}
	@Test
	public void m5() {
		System.out.println("method m5");
	}
}
