import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;

public class Hop {

	public static WebDriver driver;
	@BeforeTest
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "chromedriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.moneyhop.co/send/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void Test() {
		HomePage hp = new HomePage(driver);
		
		System.err.println("Execution starting...");
		System.out.println("clicking on Request a Callback button");
		hp.getRequest().click();
		
		System.out.println("entering name");
		hp.getName().sendKeys("Test engineer assignment");

		System.out.println("entering email");
		hp.getEmail().sendKeys("test@test.com");
			
		System.out.println("entering phone number");		
		hp.getPhoneNumber("1234567899");

		System.out.println("entering city");
		hp.getCity().sendKeys("Mysore");
		
		System.out.println("entering amount");
		hp.getAmount().sendKeys("500");

		System.out.println("clicking on currency dropdown");
		hp.getCurrencyDropDown().click();
		
		System.out.println("selecting the currency");
		for(WebElement ele : hp.getCurrencyList()){
			if(ele.getText().trim().contentEquals("AUD")){
				ele.click();
				break;
			}
		}
		
		System.out.println("entering reason");
		hp.getReason().sendKeys("reason");
		
		System.out.println("clicking on submit button");
		hp.getSubmit().click();
		
		System.out.println("Validating the success message");
		String text = hp.getSuccesMsg().getText();
		Assert.assertEquals(text, "Your request has been received");
		System.err.println("Execution ended");
		
	}
	
	@AfterTest
	public void tearDown(){
		System.out.println("closing the browser");
		driver.quit();
	}

}
