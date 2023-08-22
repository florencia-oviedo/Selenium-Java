package anotations;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SegundoSet {
	
	@Test
	public void pruebaTres() {
		System.out.println("Esta es la prueba tres del segundo set");
	}
	
	@Test(dependsOnMethods= {"pruebaTres"})
	public void pruebaCuatro() {
		System.out.println("Esta es la prueba cuatro del segundo set");
	}
	
	@Test(enabled=true)
	public void pruebaCinco() {
		System.out.println("Esta es la prueba cinco del segundo set");
	}
	
	@Test
	public void clickAlHome() {
		System.out.println("click al home");
	}
	
	@Test(groups= {"functional"},dataProvider="getData")
	public void clickAlCarrito(String producto,String precio) {
		System.out.println("Click al carrito y functional con el producto: "+
	producto+", precio: "+ precio);
	}
	
	@Parameters({"username","password"})
	@Test
	public void clickAlUsuario(String methodusername, String methodpassword) {
		System.out.println("Click al usuario con nombre:"+methodusername+
				" password: "+ methodpassword);
	}
	
	@DataProvider
	public Object[][] getData() {
		Object [][] productos = new Object[3][2];//3 productos
		
		//Primer articulo
		productos[0][0] = "Camisa";
		productos[0][1] = "$10,00";
		
		//2do articulo
		productos[1][0] = "Pantalon";
		productos[1][1] = "$14,00";
		
		//Tercer articulo
		productos[2][0] = "Remera";
		productos[2][1] = "$5,00";
		
		return productos;
	}
}
