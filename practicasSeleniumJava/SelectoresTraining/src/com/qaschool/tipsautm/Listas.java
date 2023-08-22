package com.qaschool.tipsautm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Listas {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Crear el arranque del navegador
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Florencia Oviedo\\DriverNavegadores\\chromedriver.exe");
				
		//Iniciamos el navegador
		WebDriver navegador = new ChromeDriver();
		
		navegador.get("http://www.automationpractice.pl/index.php?controller=contact");
		//crear el select estatico o lista estatica de un menu desplegable
		
		WebElement listaEstatica = navegador.findElement(By.id("id_contact"));
		
		//Creamos el elemento select
		Select listaSeleccionada = new Select(listaEstatica);
		
		//indices son las opcionse empieza desde 0, si tenemos 3 opciones
		//seria 0,1 y 2
		//selecciona la opcion 3 con indice 2
		listaSeleccionada.selectByIndex(2);
		
		System.out.println(listaSeleccionada.getFirstSelectedOption().getText());
		
		Thread.sleep(3000);
		//que me seleccione por valor o texto que dice en el desplegable
		listaSeleccionada.selectByVisibleText("Customer service");
		System.out.println(listaSeleccionada.getFirstSelectedOption().getText());
		
		Thread.sleep(3000);
		//Seleccionar por by option q aparece en el html con value 0,1,2
		listaSeleccionada.selectByValue("0");
		System.out.println(listaSeleccionada.getFirstSelectedOption().getText());
		
		Thread.sleep(3000);
		
		
	}

}
