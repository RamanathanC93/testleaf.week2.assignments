package week2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckTitle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.linkText("Log Out")).click();
		driver.close();
	}

}
