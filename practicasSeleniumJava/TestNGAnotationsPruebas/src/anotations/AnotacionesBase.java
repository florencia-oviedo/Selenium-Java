package anotations;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnotacionesBase {
	
	@BeforeClass //se corre antes de cada clase
	public void codigoAntesClase() {
		System.out.println("Este codigo se ejecuta antes de la clase");
	}
	
	@AfterClass
	public void codigoDespuesClase() {
		System.out.println("Este codigo se ejecuta despues de la clase");
	}
	
	@Test
	public void PruebaUno() {
		//rutina de codigo para correr la prueba
		System.out.println("Esta es la prueba uno");
	}
	
	@Test
	public void PruebaDos() {
		//rutina de codigo para correr la prueba
		System.out.println("Este es la prueba dos");
	}
	
}
