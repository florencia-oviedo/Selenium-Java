package com.selectorestraining.navegadores;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;

public class ControladorNavegador {

	public static void main(String[] args) {
		// Codigo para navegadores
		//Crear el arranque del navegador
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Florencia Oviedo\\DriverNavegadores\\chromedriver.exe");
		
		//Iniciamos el navegador
		WebDriver driver = new ChromeDriver();
		
		//abrimos una pag web
		driver.get("https://www.google.com/");
		//tambien se puede hacer con navigate abrir una pagina
		driver.navigate().to("https://www.winstoncastillo.com/robot-selenium/");
		
		
		//hacemos algunas cosas en la pag
		//Doc en Selenium de WebDriver
		//imprimimos la url de la pagina en ese momento
		System.out.println(driver.getCurrentUrl());
		//imprimir titulo de la ventana
		System.out.println(driver.getTitle());
		//click en la macbook y cambia de pagina
		driver.findElement(By.linkText("MacBook Pro")).click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		//vuelve hacia atras el navegador
		driver.navigate().back();
		//vuelve hacia adelante el navegador /pag
		driver.navigate().forward();
		//refresh /actualizar la pagina
		driver.navigate().refresh();
		driver.navigate().back();
		
		//MOUSE nos vemos hacia el elemento
		Actions accionRaton = new Actions(driver);
		WebElement opcionMenu = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/a"));
		accionRaton.moveToElement(opcionMenu).perform();
		
		//Iniciamos el 2do navegador(no pestaña)
		//WebDriver driver2 = new ChromeDriver();
		//driver2.get("https://www.google.com/");
		//driver2.quit();//lo saca
		
		//Crear una nueva pestaña
		//le indica el identificador de esta pestaña
		String primeraPestana = driver.getWindowHandle();
		Integer cantidadPestanas = driver.getWindowHandles().size();
		System.out.println(cantidadPestanas);//en este caso devuelve 1
		
		//Agregamos una pestaña
		JavascriptExecutor codigo = (JavascriptExecutor) driver;
		codigo.executeScript("window.open();");
		cantidadPestanas = driver.getWindowHandles().size();
		System.out.println(cantidadPestanas);
		
		//Como moverte entre las pestañas,creando un array
		ArrayList<String> pestanas  = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(pestanas.get(1));//moviendo a la pag q esta en 1
		driver.get("https://www.instagram.com");
		
		String segundaPestana = driver.getWindowHandle();
		//creamos dos pestañas
		codigo.executeScript("window.open();");
		codigo.executeScript("window.open();");
		
		//volver a crear un array? despues delos executejs
		pestanas  = new ArrayList<String>(driver.getWindowHandles());
		
		//moviendo en la pestaña 3 y 4
		driver.switchTo().window(pestanas.get(2));
		driver.get("https://www.google.com/");
		
		
		String terceraPestana = driver.getWindowHandle();
		driver.switchTo().window(pestanas.get(3));
		driver.get("https://www.facebook.com");
		
		String cuartaPestana = driver.getWindowHandle();
		cantidadPestanas = driver.getWindowHandles().size();
		System.out.println(cantidadPestanas);
		
		//cambio a primera pestaña y escribo en el busquedor
		driver.switchTo().window(primeraPestana);
		driver.findElement(By.name("search")).sendKeys("Buscar");
		
		//mover a la 2da pestaña instagram
		driver.switchTo().window(segundaPestana);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("yeolacosplay");
		
		//mover a tercera pestaña google
		driver.switchTo().window(terceraPestana);
		driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[2]/a")).click();
		
		
		
		//mover ala cuarta facebook
		driver.switchTo().window(cuartaPestana);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("hola@hotmail.com");
		
		//cerrar una pestaña
		driver.close();
		cantidadPestanas = driver.getWindowHandles().size();
		System.out.println("Las pestañas que quedan abiertas: "+cantidadPestanas);
		
		//cerrar todas las pestañas
		driver.quit();
		
	}

}
