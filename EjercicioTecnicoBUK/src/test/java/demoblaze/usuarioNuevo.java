package demoblaze;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class usuarioNuevo {
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
	public void registrocliente() {
		driver.findElement(By.id(l.registro("sign_in"))).click();
		driver.manage().timeouts().implicitlyWait(tiempoespera,TimeUnit.SECONDS) ;
		driver.findElement(By.id(l.registro("sign_user"))).clear();
		driver.findElement(By.id(l.registro("sign_user"))).sendKeys("prueba000122");
		driver.findElement(By.id(l.registro("sign_pass"))).clear();
		driver.findElement(By.id(l.registro("sign_pass"))).sendKeys("prueba000122*");
		driver.findElement(By.xpath(l.registro("sign_btn"))).click();
		//Mensaje presentado en alerta
		driver.findElement(By.xpath(l.mensaje("sign_msj")));
		driver.manage().timeouts().implicitlyWait(tiempoespera,TimeUnit.SECONDS) ;
        Alert alert = driver.switchTo().alert();
        String print = alert.getText();
        String esperado = l.mensaje("sign_msj1") ;
        Assert.assertEquals (esperado, print);
        alert.accept();
		//Alerta aceptar
		//Alert alert = driver.switchTo().alert();
		//alert.accept();	
		
	}
	
	 @After
	 public void close() {
	 driver.close();
	}

}
