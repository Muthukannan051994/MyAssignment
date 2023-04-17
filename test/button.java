package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;


public class button {

	public static void main(String[] args) throws InterruptedException, IOException {
//property setup
			System.setProperty("webdriver.chrome.driver","./src/drivers/chromedriver.exe");
			WebDriver driver= new ChromeDriver();
//Java wait
			WebDriverWait wait=new WebDriverWait(driver, 10);
//to call the application
			driver.get("https://console.tevi.co/login");
//maximized the chrome driver			
			driver.manage().window().maximize();
			Thread.sleep(3000);
			
//convert to java scrpit
			JavascriptExecutor js = (JavascriptExecutor) driver;
// scroll down command	*ennanu  +350 -350 " " therila 		
			js.executeScript("window.scrollBy(0,350)", "");
//enter the email name
			driver.findElement(By.name("email")).sendKeys("tevicouser@gmail.com");
//enter the password
			driver.findElement(By.name("password")).sendKeys("@10724e2eF");
			Thread.sleep(3000);
// Click the "Sign in" button and wait for the dashboard to load
			WebElement e=driver.findElement(By.xpath("//button[contains(text(),'Sign in')] "));
			e.click();
			Thread.sleep(5000);
//clcik the side bar button 
			driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/div/div[1]/div/div[7]")).click();
			Thread.sleep(3000);
//for clciking  the user button
			driver.findElement(By.xpath("//*[@id=\"main\"]/ng-component/div[1]/div/div/div/a")).click();
			Thread.sleep(3000);			
// for clicking invite user button			
			driver.findElement(By.xpath("/html/body/modal-container/div[2]/div/ng-component/div[2]/form/div[1]/label")).click();
			Thread.sleep(3000);
//for enter email id //id are dynamically changed so i take full xpath in this contion
			driver.findElement(By.xpath("/html/body/modal-container/div[2]/div/ng-component/div[2]/form/div[1]/input")).sendKeys("test@gmail.com");
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
// for clicking drop down //id are dynamically changed so i take full xpath in this contion
			driver.findElement(By.xpath("/html/body/modal-container/div[2]/div/ng-component/div[2]/form/div[2]/ng-select")).click();
//for clelecting Read-only-admin
			//driver.findElement(By.xpath("/html/body/modal-container/div[2]/div/ng-component/div[2]/form/div[2]/ng-select"));
			//Read only admin clicking
			driver.findElement(By.xpath("/html/body/modal-container/div[2]/div/ng-component/div[2]/form/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div[2]")).click();
//click to save button
			driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
			Thread.sleep(9000);
//click the pop-up *user has been INVITED pop-up will be dispalyed try to get on the pop-up text
			WebElement inpop=driver.findElement(By.id("toast-container"));
			System.out.println(inpop.getText());
//clicking three dot button			
			driver.findElement(By.xpath("/html/body/app-root/app-default-layout/div/div/main/ng-component/div[2]/div/div/div/app-table/div/table/tbody/tr[2]/td[7]/div/div/div/button")).click();	
//clciking deleted button * try 1st way used child elements 
			driver.findElement(By.cssSelector("ul.dropdown-menu>li:nth-of-type(3)")).click();
//click delete button
			driver.findElement(By.className("btn-danger")).click();
			Thread.sleep(9000);
//click the pop-up	
			WebElement delpop=driver.findElement(By.id("toast-container"));
			System.out.println(delpop.getText());
//click top right corner profile for log out * !st rty using class name and click 
			driver.findElement(By.className("text-start")).click();
			Thread.sleep(3000);
//log out clcik using class name 			
			driver.findElement(By.className("bbi")).click();
			Thread.sleep(9000);
//scroll down
			js.executeScript("window.scrollBy(0,350)","");
			Thread.sleep(3000);
//clicking forgot password 
			driver.findElement(By.className("mb-0")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("signinSrEmail")).sendKeys("tevicouser@gmail.com");
//click submit button using attribute value
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(3000);
			WebElement pop=driver.findElement(By.id("toast-container"));
			System.out.println(pop.getText());
			Thread.sleep(4000);
//navigate to sig in page
			driver.navigate().back();
			//enter the email name
			driver.findElement(By.name("email")).sendKeys("tevicouser@gmail.com");
//enter the password
			driver.findElement(By.name("password")).sendKeys("@10724e2eF");
			Thread.sleep(3000);
// Click the "Sign in" button and wait for the dashboard to load
			WebElement e1=driver.findElement(By.xpath("//button[contains(text(),'Sign in')] "));
			e1.click();
			Thread.sleep(5000);	
			//home page switching 60261read only account clicking  buttonused child elements 
			driver.findElement(By.cssSelector("ul.list-unstyled>li:nth-of-type(2)")).click();
			Thread.sleep(8000);
//verify account changed 
			WebElement home=driver.findElement(By.className("text-black"));
			System.out.println(home.getText());
//for clciking  the security button
			driver.findElement(By.className("bi-shield-shaded")).click();
			Thread.sleep(3000);
//for select drop down in after security click
			driver.findElement(By.className("ng-has-value")).click();
//for selecting us-west(orgeion)
			driver.findElement(By.xpath("//small[contains(text(),'us-west-2')] ")).click();
			//for screen shot taking
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destination=new File(System.getProperty("user.dir")+"./Screenshot/"+System.currentTimeMillis()+".png");
			FileHandler.copy(scrFile,destination );
			
	}								

}
