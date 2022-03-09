package week2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Ramanathan");
		driver.findElement(By.id("lastNameField")).sendKeys("C");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Mahendra Singh");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Dhoni");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Quality Assurance");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Good in Handling the Team");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("kidnapsingh@yahoo.com");
		WebElement stateElement = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dd = new Select(stateElement);
		dd.selectByVisibleText("Ohio");
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[text()='Edit']")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Good in Handling the Team");
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
		String pageTitleName = driver.getTitle();
		System.out.println(pageTitleName);
	}
}