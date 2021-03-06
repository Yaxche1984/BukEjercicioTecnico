package demoblaze;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;

public class usuarioExistente {
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
	   
	   //Usuario
			@Test
			public void userExist() {
				driver.findElement(By.id(l.registro("sign_in"))).click();
				driver.manage().timeouts().implicitlyWait(tiempoespera,TimeUnit.SECONDS) ;
				driver.findElement(By.id(l.registro("sign_user"))).clear();
				driver.findElement(By.id(l.registro("sign_user"))).sendKeys("prueba0430");
				driver.findElement(By.id(l.registro("sign_pass"))).clear();
				driver.findElement(By.id(l.registro("sign_pass"))).sendKeys("prueba58*");
				driver.findElement(By.xpath(l.registro("sign_btn"))).click();
				driver.findElement(By.xpath(l.mensaje("sign_msj2"))); 
				//driver.findElement(By.xpath("//*[@id='content']/button")).click();
				driver.manage().timeouts().implicitlyWait(tiempoespera,TimeUnit.SECONDS) ;
		        Alert alert = driver.switchTo().alert();
		        String print = alert.getText();
		        String esperado = l.mensaje("sign_msj3") ;
		        Assert.assertEquals (esperado, print);
		        alert.accept();
			}
			
			 @After
			  public void close() {
			  driver.close();
		    }

}
