import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Task12 extends TestBase{
	
	@Test
	public void newProduct() {
		//login 
		driver.navigate().to("http://localhost/litecart/public_html/admin/?app=catalog&doc=catalog");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// add new product
		driver.findElement(By.linkText("Add New Product")).click();
		System.out.println("Button Add new product click");
		
		//general 
	     driver.findElement(By.cssSelector("[href='#tab-general']")).click();
	     wait.until(presenceOfElementLocated(By.cssSelector("[name=status]")));
	      
		driver.findElement(By.cssSelector("[name=status][value='1']")).click();
		driver.findElement(By.cssSelector("[name='name[en]']")).sendKeys("Duck" + System.currentTimeMillis());
		driver.findElement(By.cssSelector("[name=code]")).sendKeys("rd" + System.currentTimeMillis());
		if(driver.findElement(By.cssSelector("[data-name=Root]")).isSelected())   
        driver.findElement(By.cssSelector("[data-name=Root]")).click();
        driver.findElement(By.cssSelector("[data-name='Rubber Ducks']")).click();
		driver.findElement(By.cssSelector("[name=quantity]")).sendKeys("10");
	//	attachFile(driver, By.cssSelector("[name='new_images[]']"), "K:\\eclipse\\task\\resourse\\minion.png");
			
		//information
		 driver.findElement(By.cssSelector("[href='#tab-information']")).click();
	     wait.until(presenceOfElementLocated(By.cssSelector("[name=manufacturer_id]")));
		   
	     new Select(driver.findElement(By.cssSelector("[name=manufacturer_id]"))).selectByIndex(1);  
	     driver.findElement(By.cssSelector("[name='short_description[en]']")).sendKeys("Short Description");
	     driver.findElement(By.className("trumbowyg-editor")).sendKeys("Description");
	   	     
	     //prices
	     driver.findElement(By.cssSelector("[href='#tab-prices']")).click();
	     wait.until(presenceOfElementLocated(By.cssSelector("[name=purchase_price]")));

	     driver.findElement(By.cssSelector("[name=purchase_price]")).clear();
	     driver.findElement(By.cssSelector("[name=purchase_price]")).sendKeys("5");
         driver.findElement(By.cssSelector("[name='prices[USD]']")).sendKeys("5");
     
         //save
         driver.findElement(By.cssSelector("[name=save]")).click();
   
         //check new product
         driver.navigate().to("http://localhost/litecart/public_html/admin/?app=catalog&doc=catalog");
         driver.findElement(By.linkText("Rubber Ducks")).click();
         driver.findElement(By.linkText("Duck" + System.currentTimeMillis())).click();
         
         
	}
}
