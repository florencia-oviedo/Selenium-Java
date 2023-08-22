package com.seleniumfirefox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InicioFirefox {

	public static void main(String[] args) {
		// Selenium con Firefox
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Florencia Oviedo\\Firefox\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//Iniciar el navegador
		driver.get("https://www.mozilla.org/es-AR/");//puede ser cualquiera www.google.com
		
		
		//maximizamos la ventana
		driver.manage().window().maximize();
		driver.close();
		
		
	}

}
