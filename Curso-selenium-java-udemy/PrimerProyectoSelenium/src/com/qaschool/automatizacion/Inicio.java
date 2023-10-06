package com.qaschool.automatizacion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Inicio {
	public static void main(String[] args) {
		
		//Mi primer codigo con Selenium
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Florencia Oviedo\\Selenium\\chromedriverfile\\chromedriver-win64\\chromedriver.exe");
		
		//iniciar e instanciar el navegador
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		//maximizamos la ventana
		driver.manage().window().maximize();
	}
}
