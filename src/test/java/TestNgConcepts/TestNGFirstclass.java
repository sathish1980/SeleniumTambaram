package TestNgConcepts;

import org.testng.annotations.*;

public class TestNGFirstclass 
{

	@Test(priority=0,dependsOnMethods="Testcase1")
	public void Testcase2()
	{
		System.out.println("Second TEst case");
	}  
	
	@BeforeSuite
	public void BeforeSuite()
	{
		System.out.println("Before Suite");
	}
	
	
	@BeforeClass
	public void BeforeClass()
	{
		System.out.println("Before Class");
	}
	
	@BeforeMethod
	public void BeforeMethod()
	{
		System.out.println("Before Method");
	}
	
	@Test(priority=2)
	public void Testcase1()
	{
		System.out.println("First TEst case");
	}
	
	
	
	@Test(priority=3)
	public void Testcase3()
	{
		System.out.println("Third TEst case");
	} 
	
	@Test(priority=1,description ="login")
	public void Testcase4()
	{
		System.out.println("Fouth TEst case");
	} 
	
	@AfterMethod
	public void AfterMethod()
	{
		System.out.println("After Method");
	}
	
	
	
	@AfterSuite
	public void AfterSuite()
	{
		System.out.println("After Suite");
	}
	
	@AfterClass
	public void AfterClass()
	{
		System.out.println("After Class");
	}
	
	@AfterTest
	public void AfterTest()
	{
		System.out.println("After Test");
	}
	
	public static void main(String[] args)
	{
		
	}
	
	
}
