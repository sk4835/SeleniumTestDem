package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.firstTest;
import test.redditSubTest;




public class PropertiesFile {

	static Properties prop = new Properties();

	public static void main(String[] args) {

		readPropertiesFile();
		writePropertiesFile();

	}

	public static void readPropertiesFile() {

		try {
			InputStream input = new FileInputStream("C:\\Users\\shahid.khan\\eclipse-workspace\\SeleniumTestDem\\src\\config\\config.properties");
			prop.load(input);
			System.out.println(prop.getProperty("browser"));
			redditSubTest.browser = prop.getProperty("browser");
			firstTest.browser = prop.getProperty("browser");
			System.out.println(firstTest.browser);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void writePropertiesFile() {

		OutputStream output;
		try {
			output = new FileOutputStream("C:\\Users\\shahid.khan\\eclipse-workspace\\SeleniumTestDem\\src\\config\\config.properties");
			prop.setProperty("browser", "Chrome");
			prop.setProperty("result", "pass");
			prop.store(output, "saving set properties");


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
