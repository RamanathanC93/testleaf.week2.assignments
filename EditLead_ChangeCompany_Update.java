package week2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead_ChangeCompany_Update {

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
		driver.findElement(By.xpath("(//label[text()='First name:'])[3]/following::input[@name='firstName']")).sendKeys("Ramanathan");
		driver.findElement(By.xpath("//em/button[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Agilysys");
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
		String checkCompany = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (checkCompany == "Agilysys")
			System.out.println("Company Name Updated Successfully");

	}

}
