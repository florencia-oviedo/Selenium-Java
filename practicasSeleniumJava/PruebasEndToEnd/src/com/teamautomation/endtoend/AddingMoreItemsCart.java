package com.teamautomation.endtoend;

import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AddingMoreItemsCart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Florencia Oviedo\\DriverNavegadores\\chromedriver.exe");
		
		//Iniciamos el navegador
		WebDriver navegador = new ChromeDriver();
		
		navegador.get("https://www.winstoncastillo.com/robot-selenium/");
		navegador.manage().window().maximize();
		
		List<WebElement> objetoComparar = navegador.findElements(By.cssSelector("#common-home > div.alert.alert-success.alert-dismissible"));
		//si esta lista esta vacia, no te debe pedir loguearte sin apretar nada
		Assert.assertTrue(objetoComparar.isEmpty());
		
		navegador.findElement(By.cssSelector("#content > div.row > div:nth-child(1) > div > div.button-group > button:nth-child(2)")).click();
		
		Thread.sleep(2000);
		
		String textoLogueoHome = navegador.findElement(By.cssSelector("#common-home > div.alert.alert-success.alert-dismissible")).getText();
		
		
		
		
		//agregar mas cosas al carrito con un for, apretar add cart
		List<String> nombresProducto = new ArrayList<String>();
		
		for(int i=1;i< 4;i++) {
			navegador.findElement(By.cssSelector("#content > div.row > div:nth-child("+i+") > div > div.button-group > button:nth-child(1)")).click();
			nombresProducto.add(navegador.findElement(By.cssSelector("#content > div.row > div:nth-child("+i+") > div > div.button-group > button:nth-child(1)")).getText());
			Thread.sleep(3000); //cuando sale error de loading...se usa sleep
		}
		System.out.println(nombresProducto);
		//comparar si se añadio 1 item en el carrito
		//Assert.assertEquals(navegador.findElement(By.cssSelector("#cart > button")).getText().replaceAll("\\s+", ""), precio.replaceAll("\\s+", ""));
		
		String textoCompletoCarrito = navegador.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/p[2]")).getText();
		String [] precios= textoCompletoCarrito.split("- ",2);
		Thread.sleep(3000);
		//click a view cart
		navegador.findElement(By.cssSelector("dsa")).click();
		Thread.sleep(3000);
		
		String verificacion="";
		for(int i=1;i<4;i++) {
			
			if(nombresProducto.contains(navegador.findElement(By.cssSelector("fijarse donde poner el "+i)).getText())) {
				if(verificacion != "No encontrado") {
			
					verificacion="Encontrado";
				}
				
			}else {
				verificacion="No encontrado";
			}
		}
		Assert.assertEquals( verificacion,"Encontrado");
		
		//comparamos el nombre del producto q aparece en la lista q tenemos
		
		String precioTotalCarrito = navegador.findElement(By.cssSelector("das")).getText();
		Assert.assertEquals(precios[1].replaceAll("\\s +",""),precioTotalCarrito.replaceAll("\\s +","") );
				
		
		
		
	}

}
