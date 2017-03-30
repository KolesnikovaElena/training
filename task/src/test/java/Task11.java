import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;



public class Task11 extends TestBase {

	@Test
	public void registration() {
		driver.navigate().to("http://localhost/litecart/public_html/en/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("#box-account-login a")).click();
		
		//new user
		String email = "test" + System.currentTimeMillis() + "@gmail.com";
		driver.findElement(By.cssSelector("[name=firstname]")).sendKeys("Lena");
		driver.findElement(By.cssSelector("[name=lastname]")).sendKeys("Penka");
		driver.findElement(By.cssSelector("[name=address1]")).sendKeys("some address");
		driver.findElement(By.cssSelector("[name=postcode]")).sendKeys("12345");
		driver.findElement(By.cssSelector("[name=city]")).sendKeys("City");
		
		driver.findElement(By.cssSelector("[name=email]")).sendKeys(email);
		driver.findElement(By.cssSelector("[name=phone]")).sendKeys("+0123456789");
		driver.findElement(By.cssSelector("[name=password]")).sendKeys("pass");
		driver.findElement(By.cssSelector("[name=confirmed_password]")).sendKeys("pass");
		
	 	 
        driver.findElement(By.cssSelector("[id ^= select2-country_code]")).click();
	    driver.findElement(By.cssSelector(".select2-results__option[id $= US]")).click();
	  
	    driver.findElement(By.cssSelector("[name=create_account]")).click();
	      
	 //logout
	    
	   driver.findElement(By.linkText("Logout")).click(); 
	    
	   //login
	   driver.findElement(By.cssSelector("[name=email]")).sendKeys(email);
	   driver.findElement(By.cssSelector("[name=password]")).sendKeys("Penka");
	   
	       	}
}
