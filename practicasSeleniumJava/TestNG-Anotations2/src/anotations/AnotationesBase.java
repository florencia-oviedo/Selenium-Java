package anotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AnotationesBase {

	@BeforeClass
	public void codigoAntesClase() {
		System.out.println("Este codigo se ejecuta antes de la clase");
	}
	
	@AfterClass
	public void codigoDespuesClase() {
		System.out.println("Este codigo se ejecuta despues de la clase");
	}
	
}
