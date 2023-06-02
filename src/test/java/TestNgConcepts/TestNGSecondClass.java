package TestNgConcepts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGSecondClass {

	@BeforeTest
	public void BeforeTest()
	{
		System.out.println("Before Test");
	}
	
	@Test(groups="Sanity")
	public void Testcase3()
	{
		System.out.println("Third TEst case in second class");
	}
	
	@Test(groups="Sanity")
	public void Testcase4()
	{
		System.out.println("Fourth TEst case in second class");
	}
}
