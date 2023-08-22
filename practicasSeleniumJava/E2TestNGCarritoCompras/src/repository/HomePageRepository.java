package repository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
public class HomePageRepository {
	
	
	 WebDriver driver;
	 String modifiedXPath;

	public String getModifiedXPath() {
		return modifiedXPath;
	}

	public void setModifiedXPath(String number) {
		String xPath = String.format("//*[@id=\"blockbestsellers\"]/li[%s]/div/div[2]/div[1]/span", number);
		this.modifiedXPath = xPath;
	}

	public HomePageRepository(WebDriver navegador) {
		this.driver = navegador;
		PageFactory.initElements(driver, this);
		
	}
	
	By brandLogo = By.xpath("//*[@id=\"header_logo\"]/a/img");
	By searchBox = By.id("search_query_top");
	
	@FindBy(id="blockbestsellers")
	WebElement homeFeacture;
	
	@FindBys({@FindBy(tagName= "li")})
	List<WebElement> listaElementos;
	//By listaElementos = By.tagName("li");
	
	@FindBy(xpath="//*[@id=\\\"index\\\"]/div[2]/div/div/div/div/p")
	WebElement ventanaPopUp;
	
	@FindBy(linkText="Add to cart")
	WebElement addToCartButton ;
	
	//producto aleatorio
	public WebElement productoAleatorioElement(String xPath) {
		By producto = By.xpath(xPath);
		return driver.findElement(producto);
	}
	
	public WebElement addToCartElement(WebElement productoLista) {
		PageFactory.initElements(new DefaultElementLocatorFactory(productoLista), this);
		return addToCartButton;
	}
	
	public WebElement brandLogoElement() {
		return driver.findElement(brandLogo);
	}
	
	//Si quieres buscar una palabra en el buscador
	public void searchBoxQuery(String wordtoSearch) {
		driver.findElement(searchBox).sendKeys(wordtoSearch);
	}
	//no se suele colocar metodos con acciones en el repository como este void
	
	public WebElement homeFeacture() {
		return homeFeacture;
	}
	
	//cuando tienes lista de elementos no se usa findElement es un set
	public List<WebElement> listaElementos() {
		PageFactory.initElements(new DefaultElementLocatorFactory(this.homeFeacture()), this);
		return listaElementos;
	}
	
	public WebElement ventanaPopUpElement() {
		return ventanaPopUp;
	}
	
	
}
