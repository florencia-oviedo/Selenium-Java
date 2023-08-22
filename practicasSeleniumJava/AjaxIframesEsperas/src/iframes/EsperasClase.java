package iframes;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EsperasClase {
	WebDriver navegador = new ChromeDriver();
	
	@Test
	public void esperaImplicitaExplicita() {
		
		//Esta es una espera implicita
		navegador.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//Este es el codigo de espera explicita
		WebDriverWait espera = new WebDriverWait(navegador, Duration.ofSeconds(10));
		
		navegador.get("http://www.automationpractice.pl/index.php");
		navegador.manage().window().maximize();
		navegador.findElement(By.xpath("//*[@id=\"home-page-tabs\"]/li[2]/a")).click();
		Actions mouseActions  = new Actions(navegador);
		WebElement elementoProducto = navegador.findElement(By.xpath("//*[@id=\"blockbestsellers\"]/li[1]/div/div[1]/div/a[1]/img"));
		mouseActions.moveToElement(elementoProducto).perform();
		navegador.findElement(By.xpath("//*[@id=\"blockbestsellers\"]/li[1]/div/div[2]/div[2]/a[1]")).click();
		
		//Hasta que no este visible la ventana no continues con el codigo para q lo lea correctamente
		WebElement ventanaProducto = espera.until(ExpectedConditions.visibilityOf(navegador.findElement(By.xpath("//*[@id=\"index\"]/div[2]/div/div/div/div/p"))));
		
		System.out.println("Texto header: "+navegador.findElement(By.xpath("//*[@id=\"index\"]/div[2]/div/div/div/div/p")).getText());
		navegador.close();
	
	}
}
