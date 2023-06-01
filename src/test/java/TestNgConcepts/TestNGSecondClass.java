package TestNgConcepts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGSecondClass {

	@BeforeTest
	public void BeforeTest()
	{
		System.out.println("Before Test");
	}
	
	@Test
	public void Testcase3()
	{
		System.out.println("Third TEst case in second class");
	}
	
	@Test
	public void Testcase4()
	{
		System.out.println("Fourth TEst case in second class");
	}
}
