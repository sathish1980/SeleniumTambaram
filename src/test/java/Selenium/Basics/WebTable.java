package Selenium.Basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTable {

	WebDriver driver;
	String indentify = "notdone";

	public void tableconcept(String expectedcountry) throws InterruptedException {

		// System.setProperty("webdriver.chrome.driver",
		// System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get("https://leafground.com/table.xhtml");

		// pagination
		List<WebElement> allpages = driver.findElements(By.xpath("//*[@class='ui-paginator-pages']//a"));
		for (int i = 1; i <= allpages.size(); i++) {
			// System.out.println("Page is : " + i);
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			driver.findElement(By.xpath("//*[@class='ui-paginator-pages']//a[" + i + "]")).click();
			Thread.sleep(1000);
			List<WebElement> allRows = driver
					.findElements(By.xpath("//*[@class='ui-datatable-scrollable-body']//table//tbody//tr"));
			for (WebElement eachRow : allRows) {
				// System.out.println(eachRow.getAttribute("data-ri"));
				String Country = eachRow.findElement(By.cssSelector("td[role='gridcell']>span:nth-of-type(3)"))
						.getText();
				if (expectedcountry.equalsIgnoreCase(Country)) {
					// System.out.println(Country);
					String Representative = eachRow.findElement(By.cssSelector("td:nth-of-type(3)>span:nth-of-type(2)"))
							.getText();
					String joiningDate = eachRow.findElement(By.cssSelector("td:nth-of-type(4)")).getText();
					String Status = eachRow.findElement(By.cssSelector("td:nth-of-type(5)>span:nth-of-type(2)"))
							.getText();
					String color = eachRow.findElement(By.cssSelector("td:nth-of-type(5)>span:nth-of-type(2)")).getCssValue("background");
					System.out.println(color);
					// System.out.println(Representative);
					// System.out.println(joiningDate);
					// System.out.println(Status);
				}
			}

		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebTable W = new WebTable();
		W.tableconcept("Brazil");
	}

}
