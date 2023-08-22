package iframes;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitClase {
WebDriver navegador = new ChromeDriver();
	
	@Test
	public void fluentWaitMetodo() {
		
		//Esta es la espera fluentWait
		Wait<WebDriver> espera = new FluentWait<WebDriver>(navegador)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(5))//cada 5 seg vas a hacer el mismo proceso	
				.ignoring(NoSuchElementException.class);//esa clase quiero ignorar para que no me falle la prueba	
		
		navegador.get("http://www.automationpractice.pl/index.php");
		navegador.manage().window().maximize();
		navegador.findElement(By.xpath("//*[@id=\"home-page-tabs\"]/li[2]/a")).click();
		Actions mouseActions  = new Actions(navegador);
		WebElement elementoProducto = navegador.findElement(By.xpath("//*[@id=\"blockbestsellers\"]/li[1]/div/div[1]/div/a[1]/img"));
		mouseActions.moveToElement(elementoProducto).perform();
		navegador.findElement(By.xpath("//*[@id=\"blockbestsellers\"]/li[1]/div/div[2]/div[2]/a[1]")).click();
		
		//Hasta que no este visible la ventana no continues con el codigo para q lo lea correctamente
		WebElement ventanaProducto = espera.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver navegador) {//identificar el elemento que quiero encontrar
															//hasta que el me encuentre ese elemento este codigo se va a repetir
				
				return navegador.findElement(By.xpath("//*[@id=\"index\"]/div[2]/div/div/div/div/p"));//ventana abierta
				}
			}
				);
		
		System.out.println("Texto header: "+navegador.findElement(By.xpath("//*[@id=\"index\"]/div[2]/div/div/div/div/p")).getText());
		navegador.close();
	
	}
}
