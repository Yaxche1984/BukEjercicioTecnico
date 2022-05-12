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

public class pagoProducto {
	public static WebDriver driver;
	public static int tiempoespera = 10;
	public static String msjeAlerta;
 
	@Before
	public void setUp() {
    	System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/index.html");
     }
	
	@Test
	public void addCart() {
		driver.findElement(By.id("login2")).click();
		driver.manage().timeouts().implicitlyWait(tiempoespera,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("prueba0111");
		driver.manage().timeouts().implicitlyWait(tiempoespera,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("prueba31*");
		driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
		JavascriptExecutor scrollLaptops = (JavascriptExecutor)driver;
		scrollLaptops.executeScript("window.scrollBy(0,250)", "");
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
		driver.findElement(By.xpath("//*[text()='Product added.']"));
		//Alerta aceptar
		Alert alert = driver.switchTo().alert();
		alert.accept();	
		WebElement cart = driver.findElement(By.linkText("Cart"));
		cart.click();
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]"));
		//Bot�n para Place Order
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"totalm\"]")).click();
		//Verificaci�n de monto a pagar
		try 
		{
			driver.findElement(By.xpath("//*[text()='Total: 790']"));
			//Nombre
	    	driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Elizabeth");
	    	//P�is
	    	driver.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys("El Salvador");
	    	//Ciudad
	    	driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("San Salvador");
	    	//Tarjeta de cr�dito
	    	driver.findElement(By.xpath("//*[@id=\"card\"]")).sendKeys("0077777777777");
	    	JavascriptExecutor scrollDatosPago = (JavascriptExecutor)driver;
	    	scrollDatosPago.executeScript("window.scrollBy(0,250)", "");
	    	//Mes
	    	driver.findElement(By.xpath("//*[@id=\"month\"]")).sendKeys("Enero");
	    	//A�o
	    	driver.findElement(By.xpath("//*[@id=\"year\"]")).sendKeys("2022");
	    	driver.manage().timeouts().implicitlyWait(tiempoespera,TimeUnit.SECONDS) ;
	    	//Purchace
	    	driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")).click();
	    	driver.manage().timeouts().implicitlyWait(tiempoespera,TimeUnit.SECONDS) ;
	    	driver.findElement(By.xpath("//*[text()='Thank you for your purchase!']"));
	    	driver.manage().timeouts().implicitlyWait(tiempoespera,TimeUnit.SECONDS) ;
	    	driver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button")).click();
	    	driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[1]")).click();
	    	driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a")).click();
			
		}
		catch (org.openqa.selenium.StaleElementReferenceException ex){
			/*JavascriptExecutor scrollClose = (JavascriptExecutor)driver;
	    	scrollClose.executeScript("window.scrollBy(0,450)", "");
	    	driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[1]")).click();*/
		}
	}
	
	 @After
	 public void close() {
	 driver.close();
    }

}
