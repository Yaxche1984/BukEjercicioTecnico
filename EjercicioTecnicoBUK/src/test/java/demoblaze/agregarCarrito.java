package demoblaze;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class agregarCarrito {

	public static WebDriver driver;
	public static int tiempoespera = 10;
	public static String msjeAlerta;
	localizadores l = new localizadores();
 
	@Before
	public void setUp() {
    	System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/index.html");
     }
	
	@Test
	public void addCart() {
		driver.findElement(By.id(l.ingreso("login"))).click();
		driver.manage().timeouts().implicitlyWait(tiempoespera,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath(l.ingreso("ing_usu"))).sendKeys("prueba0001");
		driver.manage().timeouts().implicitlyWait(tiempoespera,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath(l.ingreso("ing_pass"))).sendKeys("prueba0001*");
		driver.findElement(By.xpath(l.ingreso("ing_btn"))).click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		try {
		WebElement catLaptops = driver.findElement(By.linkText("Laptops"));
		catLaptops .click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			WebElement catLaptops  = driver.findElement(By.linkText("Laptops"));
			catLaptops .click();
		}
		WebElement Laptop1 = driver.findElement(By.linkText("Sony vaio i5"));
		Laptop1.click();
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).click();
		driver.findElement(By.xpath(l.mensaje("sign_msj6")));
		//Alerta aceptar
		Alert alert = driver.switchTo().alert();
		alert.accept();	
		WebElement cart = driver.findElement(By.linkText(l.carrito("cart")));
		cart.click();
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]"));
	}
	
	 @After
	 public void close() {
	 driver.close();
    }
	
}
