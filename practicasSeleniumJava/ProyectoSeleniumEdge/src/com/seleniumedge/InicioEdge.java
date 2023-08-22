package com.seleniumedge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class InicioEdge {
	
	public static void main(String[] args) {
		// Selenium con Edge
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Florencia Oviedo\\Edge\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		//Iniciar el navegador
		driver.get("https://www.google.com/");//puede ser cualquiera www.google.com
		
		
		//maximizamos la ventana
		driver.manage().window().maximize();
		//driver.close();
		
		
	}
}
