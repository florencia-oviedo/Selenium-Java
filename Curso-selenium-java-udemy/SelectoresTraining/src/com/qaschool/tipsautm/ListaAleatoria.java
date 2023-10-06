package com.qaschool.tipsautm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
public class ListaAleatoria {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions notificaciones = new ChromeOptions();
		notificaciones.addArguments("--disable-notifications");//desactivar notificaciones de la pag
		notificaciones.addArguments("--disable-extensions");
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Florencia Oviedo\\DriverNavegadores\\chromedriver.exe");
		
		//Iniciamos el navegador
		WebDriver navegador = new ChromeDriver(notificaciones);
		
		navegador.get("http://www.amazon.com");
		
		//escribir laptop en el buscador en amazon
		navegador.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
		//bajar la velocidad
		Thread.sleep(3000);
		//buscar el elemento aleatorio que quiero
		//creamos un array
		List<WebElement> opciones = navegador.findElements(By.id("nav-flyout-searchAjax"));
		//con control +shift + c para atrapar el id de la lista de opciones q me aparece cuando
		//escribo laptop
		
		for(WebElement opcion: opciones) {
			System.out.println(opcion.getText());
			if(opcion.getText().contains("laptop stand for desk")) {
				opcion.click();
				break;
			}
		}
		
		//TestNG una herramienta sirve para hacer validaciones
		//los asserts es comprobar si se va a la ventana de lo que quiero
		//comprobar si realmente fue a donde queria ir o donde estoy
		//en este caso si esta en la pag d inicio de amazon
		Assert.assertEquals(navegador.getTitle(), "Amazon.com");//actual,expectativa
		//lista dependiente que depende de otra lista
		
	}

}