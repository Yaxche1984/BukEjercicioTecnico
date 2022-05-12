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
 
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/index.html");
		
    }
	
	@Test
	public void registrocliente() {
		driver.findElement(By.id("signin2")).click();
		driver.manage().timeouts().implicitlyWait(tiempoespera,TimeUnit.SECONDS) ;
		driver.findElement(By.id("sign-username")).clear();
		driver.findElement(By.id("sign-username")).sendKeys("prueba0199");
		driver.findElement(By.id("sign-password")).clear();
		driver.findElement(By.id("sign-password")).sendKeys("prueba99*");
		driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")).click();
		//Mensaje presentado en alerta
		driver.findElement(By.xpath("//*[text()='Sign up successful.']"));
		driver.manage().timeouts().implicitlyWait(tiempoespera,TimeUnit.SECONDS) ;
        Alert alert = driver.switchTo().alert();
        String print = alert.getText();
        String esperado = "Sign up successful." ;
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