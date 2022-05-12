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

public class validacionContrasena {
	public static WebDriver driver;
	public static int tiempoespera = 5;
	
	@Before
	public void setUp() {
    	System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/index.html");
     }
	
	@Test
	public void ingresoUsuario() {
		driver.findElement(By.id("login2")).click();
		driver.manage().timeouts().implicitlyWait(tiempoespera,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("prueba021");
		driver.manage().timeouts().implicitlyWait(tiempoespera,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("prueba021*");
		driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
		driver.findElement(By.xpath("//*[text()='Wrong password.']"));
		driver.manage().timeouts().implicitlyWait(tiempoespera,TimeUnit.SECONDS) ;
        Alert alert = driver.switchTo().alert();
        String print = alert.getText();
        String esperado = "Wrong password." ;
        Assert.assertEquals (esperado, print);
        alert.accept();
	 }
	 @After
	 public void close() {
	 driver.close(); 
	 }


}
