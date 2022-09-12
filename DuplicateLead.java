package selenium_pgm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	/* Week2_day1 Assignment */

	public static void main(String[] args) throws InterruptedException {

		// Setup browser driver
		WebDriverManager.chromedriver().setup();

		// Launch the browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("http://leaftaps.com/opentaps/control/main");

		// maximize the browser window
		driver.manage().window().maximize();

		// Enter the Username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

		// Enter the Password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on Login button
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on CRM/SFA hypelink
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click on Leads
		driver.findElement(By.linkText("Leads")).click();

		// Click on Create Leads
		driver.findElement(By.linkText("Create Lead")).click();

		// Fill the information to create new lead
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Oneplus");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Ganesh");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("More");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Ganu");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Shared Services");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Permanent Employee");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("ganesh1999@gmail.com");

		// Select State/Province as New York Using Visible Text from dropDown
		WebElement stateValue = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dd = new Select(stateValue);
		dd.selectByVisibleText("New York");

		Thread.sleep(8000);

		// Click create lead
		driver.findElement(By.className("smallSubmit")).click();

		// Get title of resulting page
		System.out.println("Title of resulting page is : " + driver.getTitle());

		Thread.sleep(5000);

		// Duplicate Lead : Click on Duplicate Lead Button
		driver.findElement(By.linkText("Duplicate Lead")).click();

		// Clear the CompanyName Field using .clear() And Enter new CompanyName
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");

		// Clear the FirstName Field using .clear() And Enter new FirstName
		WebElement ele1 = driver.findElement(By.id("createLeadForm_firstName"));
		ele1.clear();
		ele1.sendKeys("Suchit");

		Thread.sleep(8000);

		// Click create lead
		driver.findElement(By.className("smallSubmit")).click();

		// Get title of resulting page
		System.out.println("Title of resulting page, after updating information is: " + driver.getTitle());

		// Close the browser
		driver.close();

	}

}
