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
		 
			@Before
			public void setUp() {
		    	System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.demoblaze.com/index.html");
		     }
		
			
			@Test
			public void userExist() {
				driver.findElement(By.id("signin2")).click();
				driver.manage().timeouts().implicitlyWait(tiempoespera,TimeUnit.SECONDS) ;
				driver.findElement(By.id("sign-username")).clear();
				driver.findElement(By.id("sign-username")).sendKeys("prueba0430");
				driver.findElement(By.id("sign-password")).clear();
				driver.findElement(By.id("sign-password")).sendKeys("prueba58*");
				driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")).click();
				driver.findElement(By.xpath("//*[text()='This user already exist.']")); 
				//driver.findElement(By.xpath("//*[@id='content']/button")).click();
				driver.manage().timeouts().implicitlyWait(tiempoespera,TimeUnit.SECONDS) ;
		        Alert alert = driver.switchTo().alert();
		        String print = alert.getText();
		        String esperado = "This user already exist." ;
		        Assert.assertEquals (esperado, print);
		        alert.accept();
			}
			
			 @After
			  public void close() {
			  driver.close();
		    }

}
