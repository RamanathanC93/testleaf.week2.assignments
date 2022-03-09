package week2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RetrieveMutipleDropdownOptions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
		driver.findElement(By.xpath("//input[contains(@id,'createLeadForm_companyName')]")).sendKeys("Softura");
		driver.findElement(By.xpath("//input[contains(@id,'createLeadForm_firstName')]")).sendKeys("Ramanathan");
		driver.findElement(By.xpath("//input[contains(@id,'createLeadForm_lastName')]")).sendKeys("C");
		driver.findElement(By.xpath("//input[contains(@id,'createLeadForm_firstNameLocal')]")).sendKeys("Ramu");
		driver.findElement(By.xpath("//input[contains(@id,'createLeadForm_departmentName')]")).sendKeys("Quality Assurance");
		//driver.findElement(By.xpath("//input[contains(@id,'createLeadForm_description')]")).sendKeys("Ramu has a total of 15 years experience with strong knowledge in Manual and Automation Testings");
		
		driver.findElement(By.xpath("//input[contains(@id,'createLeadForm_primaryEmail')]")).sendKeys("Kidnapsingh@Yahoo.com");
		WebElement dropOptions = driver.findElement(By.xpath("//select[@id='createLeadForm_dataSourceId']"));
		Select dd = new Select(dropOptions);
		List<WebElement> options = dd.getOptions();
		for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());
			
		}
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();

	}

}
