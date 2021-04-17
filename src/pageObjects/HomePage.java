package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	
	By request = By.xpath("//span[text()='Request a Callback']");
	By name = By.cssSelector("input[name='name']");
	By email = By.cssSelector("input[type='email']");
	By phoneNumber = By.cssSelector("input[type='number']");
	By city = By.cssSelector("input[name='city']");
	By amount = By.cssSelector("input[name='amount']");
	By currencyDropDown = By.id("mui-component-select-currency");
	By currencyList = By.cssSelector("li[class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button']");
	By reason = By.id("outlined-multiline-static");
	By submit = By.xpath("//span[contains(text(),'Submit')]");
	By successMsg = By.cssSelector("div[class='MuiAlert-message']");
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getRequest(){
		return driver.findElement(request);
	}
	
	public WebElement getName(){
		return driver.findElement(name);
	}
	
	public WebElement getEmail(){
		return driver.findElement(email);
	}
	
	public void getPhoneNumber(String num){
		//return driver.findElement(phoneNumber);
		
//		WebElement phoneNumber = driver.findElement(By.cssSelector("input[type='number']"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].setAttribute('value','1234567899')", phoneNumber);
//		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		phoneNumber = wait.until(ExpectedConditions.elementToBeClickable(phoneNumber));
//		phoneNumber.click();
//		phoneNumber.sendKeys("1234646556");
		
		Actions a = new Actions(driver);
		a.sendKeys(Keys.TAB).perform();
		a.sendKeys(num).build().perform();
	}
	
	public WebElement getCity(){
		return driver.findElement(city);
	}
	
	public WebElement getAmount(){
		return driver.findElement(amount);
	}
	
	public WebElement getCurrencyDropDown(){
		return driver.findElement(currencyDropDown);
	}
	
	public List<WebElement> getCurrencyList(){
		return driver.findElements(currencyList);
	}
	
	public WebElement getReason(){
		return driver.findElement(reason);
	}
	
	public WebElement getSubmit(){
		return driver.findElement(submit);
	}
	
	public WebElement getSuccesMsg(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement el ;
		el = wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
		return el;
	}
	
}
