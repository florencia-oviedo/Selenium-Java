package anotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnotationesBase {

	@BeforeClass //se corre antes de cada clase
	public void codigoAntesClase() {
		System.out.println("Este codigo se ejecuta antes de la clase");
	}
	
	@AfterClass
	public void codigoDespuesClase() {
		System.out.println("Este codigo se ejecuta despues de la clase");
	}
	
	@BeforeSuite
	public void codigoAntesSuite() {
		System.out.println("Este codigo se ejecuta antes de toda la suite");
	}
	
	@AfterSuite
	public void codigoDespuesSuite() {
		System.out.println("Este codigo se ejecuta despues de toda la suite");
	}
	
	@BeforeMethod()
	public void antesDeCadaMetodo() {
		System.out.println("Este codigo se ejecuta antes de cada test");
	}
	
	@AfterMethod()
	public void despuesDeCadaMetodo() {
		System.out.println("Este codigo se ejecuta despues de cada test");
	}
	
	@BeforeTest
	public void antesSetTest() {
		System.out.println("Se ejecuta antes de todos archivo incluido el set de pruebas");
	}
	
	@AfterTest
	public void despuesSetTest() {
		System.out.println("Se ejecuta despues de todos los archivo incluido el set de pruebas");
	}
	
	@Test(groups= {"functional"})
	public void pruebaUno() {
		//rutina de codigo para correr la prueba
		System.out.println("Este es la prueba uno y funcional");
	}
	
	@Test(dependsOnMethods= {"pruebaUno"})
	public void pruebaDos() {
		//rutina de codigo para correr la prueba
		System.out.println("Este es la prueba dos");
	}
	
}
