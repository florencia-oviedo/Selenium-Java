package testcase;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import repository.ContactFormRepository;

import reader.CsvFileReader;

public class Base {
	
	//de la clase creada
	CsvFileReader datosLeidos = new CsvFileReader();
	WebDriver navegador  = new ChromeDriver();
	WebDriverWait espera = new WebDriverWait(navegador,Duration.ofSeconds(20));
	
	ContactFormRepository repositorioContacto = new ContactFormRepository(navegador);
	
	
	
	
}
