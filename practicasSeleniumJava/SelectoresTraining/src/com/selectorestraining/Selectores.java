package com.selectorestraining;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Selectores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote--allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Florencia Oviedo\\DriverNavegadores\\chromedriver.exe");
		
		WebDriver navegador = new ChromeDriver();
		//get para abrir una pagina
		navegador.get("https://www.winstoncastillo.com/robot-selenium/");
		//buscar el MyAccount y hacer click y Estar en la parte de Login
		//Buscar en inspeccionar y click derecho copy y copias el xpath o lo q necesites
		navegador.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a")).click();
		navegador.findElement(By.linkText("Login")).click();
		System.out.println(navegador.getTitle());
		
		//poner email y contra y input login
		navegador.findElement(By.name("email")).sendKeys("florov@gmail.com");
		navegador.findElement(By.name("password")).sendKeys("1234");
		navegador.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input")).click();
		//css selector lo encontras en el inspeccionar y copy paste
	}

}
