package testcase;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FormularioContacto extends Base {
	
	@BeforeTest
	public void openBrowser() {
		navegador.get("https://winstoncastillo.com/robot-selenium/index.php?route=information/contact");
		
	}
	
	@AfterTest
	public void closeBrowser() {
		navegador.close();
	}
	
	@Test
	public void aplicarDataForm() throws IOException {
		ArrayList<String> datos = datosLeidos.getData();
		int number = datos.size();
		System.out.println(number);
		
		for(int i=1;i<number;i++) {
			String[] lineaDatos = datos.get(i).split(";");//corte en cada ;
			repositorioContacto.fieldNameElement().sendKeys(lineaDatos[1]);
			repositorioContacto.fieldEmailElement().sendKeys(lineaDatos[2]);
			repositorioContacto.fieldDescriptionElement().sendKeys(lineaDatos[3]);
			repositorioContacto.submitButtonElement().click();
			//esperar el boton de continue
			WebElement botonContinuar = espera.until(ExpectedConditions.visibilityOf(repositorioContacto.continueButtonElement()));
			//volvemos atras
			navegador.get("https://winstoncastillo.com/robot-selenium/index.php?route=information/contact");
			
		}
	}
	
	
	
}
