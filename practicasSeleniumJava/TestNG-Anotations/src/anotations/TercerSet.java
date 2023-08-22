package anotations;

import org.testng.annotations.Test;

public class TercerSet {
	
	@Test
	public void tercerSetPruebaUno() {
		System.out.println("Primera prueba tercer set");
	}
	
	@Test(groups= {"smoke"})
	public void tercerSetPruebaDos() {
		System.out.println("Segunda prueba tercer set y smoke");
	}
	
	@Test(groups= {"functional","smoke"})
	public void tercerSetPruebaTres() {
		System.out.println("Tercera prueba tercer set functional y smoke");
	}
	
	@Test
	public void tercerSetPruebaCuarta() {
		System.out.println("Cuarta prueba tercer set");
	}
}
