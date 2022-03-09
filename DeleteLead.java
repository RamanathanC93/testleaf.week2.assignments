package week2.assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		driver.findElement(By.linkText("Phone")).click();
		driver.findElement(By.xpath("//div/input[@name='phoneNumber']")).sendKeys("9524080298");
		driver.findElement(By.xpath("//em/button[text()='Find Leads']")).click();
		String text = driver.findElement(By.xpath("(//tr/td/div/a[@class='linktext'])[1]")).getText();
		String numberString = text.replaceAll("[^0-9]", "");
		System.out.println(numberString);
		driver.findElement(By.xpath("(//tr/td/div/a[@class='linktext'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String text2 = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String replaceAll = text2.replaceAll("[^0-9]", "");
		System.out.println(replaceAll);		  
		driver.findElement(By.linkText("Delete")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//em/button[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//div/input[@name='id']")).sendKeys(replaceAll);
		driver.findElement(By.xpath("//em/button[text()='Find Leads']")).click();
		String text3 = driver.findElement(By.xpath("//div/div[text()='No records to display']")).getText();
		if (text3 == "No records to display")
			System.out.println("Lead is deleted");
		else
			System.out.println("Error");
		
		
		
		 
		
		
		
		
	}

}
