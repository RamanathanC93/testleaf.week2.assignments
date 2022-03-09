package week2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//p[contains(@class,'top')]/input")).sendKeys("Demosalesmanager"); //Parent to Child
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//form[@id='login']//input)[2]")).sendKeys("crmsfa");  //Grandparent to GrandChild using Collection index
		driver.findElement(By.xpath("//form[@id='login']//input[@class='decorativeSubmit']")).click(); //Grandparent to GrandChild
		driver.findElement(By.xpath("//div[@id='label']/a[contains(text(),'CRM/SFA')]")).click();   //Parent to Child Using Partial Text based
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText("Email")).click();
		driver.findElement(By.xpath("//label[text()='Email Address:']/following::input[@name='emailAddress']")).sendKeys("kidnapsingh");		
		driver.findElement(By.xpath("//em/button[text()='Find Leads']")).click();
		driver.findElement(By.xpath("(//tr/td/div/a[@class='linktext'])[1]")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		String heading = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		if (heading == "Duplicate Lead")
			System.out.println("Page Title is verified and is correct");
		else
			System.out.println("Page Title is not correct");
		driver.findElement(By.linkText("Create Lead")).click();
				
	}

}
