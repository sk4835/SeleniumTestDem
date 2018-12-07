package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.PropertiesFile;

public class firstTest {

	public static String browser;
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PropertiesFile.readPropertiesFile();
		PropertiesFile.writePropertiesFile();
		setBrowserConfig();
		runTest();
	}

	public static void setBrowserConfig() {
		if (browser.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\shahid.khan\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser == "Firefox") {

			System.out.println("Download firefox and set properties in Config and firstTest");
		}

	}

	public static void runTest() throws InterruptedException {

		// puts an implicit wait for ten seconds before throwing exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// launches website 
		driver.navigate().to("http://www.calculator.net/");
		// maximizes window
		driver.manage().window().maximize();

		// find element using 'inspect' in chrome, copy xpath on link and paste
		driver.findElement(By.xpath("//*[@id=\"contentout\"]/table/tbody/tr/td[3]/div[2]/a")).click();
		// same as above, clicks persent calculator link
		driver.findElement(By.xpath("//*[@id=\"content\"]/table[2]/tbody/tr/td/div[3]/a")).click();

		// type '10' into % field and '50' into second field
		driver.findElement(By.xpath("//*[@id=\"cpar1\"]")).sendKeys("10"); // QUESTION - is there any reason to pick By.ID over By.xpath even though it still works?
		driver.findElement(By.xpath("//*[@id=\"cpar2\"]")).sendKeys("50");
		System.out.println("Value being calculated is 10 percent of 50.");

		// click calculate to see result
		driver.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr[2]/td/input[2]")).click();

		//put result text into string variable 'result'
		String result = driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]")).getText();
		
		//print result to console
		System.out.println("Text from elementt: " + result);

		// is result from xpath is present, pass the test. Veru
		if (result.contains("Result")) {

			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}





		Thread.sleep(10000);
		driver.close();

	}




}
