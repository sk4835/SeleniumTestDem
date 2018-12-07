package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import config.PropertiesFile;

public class redditSubTest {

	public static String browser;
	static WebDriver driver;

	//Main method
	public static void main(String[] args) throws Exception {
		
		PropertiesFile.readPropertiesFile();
		PropertiesFile.writePropertiesFile();
		setBrowserConfig();
		verifyLogin();
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
	
	public static void verifyLogin() throws InterruptedException {
		
		//navigate to reddit.com
		driver.navigate().to("https://www.reddit.com/");
		System.out.println("Launched reddit website");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/header/div/div[2]/div[2]/div[1]/a[2]")).click();
		System.out.println("Clicked 'sign up'");
		
		String verifyPopup = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/div[1]/h1")).getText();
		System.out.println("Text from element on sign up pop up: " + verifyPopup);
		
		if (verifyPopup.contains("Join the worldwide conversation")) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test Failed");
		}
		
		Thread.sleep(10000);
		driver.close();
		
	}
}
