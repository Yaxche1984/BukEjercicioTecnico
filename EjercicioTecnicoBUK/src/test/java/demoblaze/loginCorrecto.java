package demoblaze;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginCorrecto {
	public static WebDriver driver;
	public static int tiempoespera = 30;
	localizadores l = new localizadores();
	
	@Before
	public void setUp() {
    	System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/index.html");
     }
	
	//Login 
	@Test
	public void ingresoUsuario() {
		driver.findElement(By.id(l.ingreso("login"))).click();
		driver.manage().timeouts().implicitlyWait(tiempoespera,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath(l.ingreso("ing_usu"))).sendKeys("prueba021");
		driver.manage().timeouts().implicitlyWait(tiempoespera,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath(l.ingreso("ing_pass"))).sendKeys("prueba021*");
		driver.findElement(By.xpath(l.ingreso("ing_btn"))).click();
	    try {
			driver.findElement(By.xpath(l.ingreso("log_out"))).click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			driver.findElement(By.xpath(l.ingreso("log_out"))).click();
		}
		
	 }
	 @After
	 public void close() {
	 driver.close(); 
	 }

}
