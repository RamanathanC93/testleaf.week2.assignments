package week2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='_6ltg']/a[contains(@class,'_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//div[@class='_5dbb']/input")).sendKeys("Jason");
		driver.findElement(By.xpath("//div[text()='Surname']/following-sibling::input")).sendKeys("Gillespie");
		driver.findElement(By.xpath("//div[contains(text(),'Mobile number')]/following-sibling::input")).sendKeys("kidnapsingh@yahoo.com");
		driver.findElement(By.xpath("//div[contains(text(),'Re-enter email')]/following-sibling::input")).sendKeys("kidnapsingh@yahoo.com");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("ABC@123abc");
		WebElement dayElement = driver.findElement(By.xpath("//select[@id='day']"));
		Select dd = new Select(dayElement);
		dd.selectByValue("1");
		WebElement monthElement = driver.findElement(By.xpath("//select[@id='month']"));
		Select dd1= new Select(monthElement);
		dd1.selectByIndex(1);
		WebElement yearElement = driver.findElement(By.xpath("//select[@id='year']"));
		Select dd2 = new Select (yearElement);
		dd2.selectByVisibleText("1993");
		driver.findElement(By.xpath("//label[text()='Male']/following-sibling::input")).click();
		
		
	}

}
