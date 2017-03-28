import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Task17 extends TestBase {
	

	@Test
	  public void logs() {
	driver.navigate().to("http://localhost/litecart/public_html/admin/?app=catalog&doc=catalog&category_id=1");
	driver.findElement(By.name("username")).sendKeys("admin");
	driver.findElement(By.name("password")).sendKeys("admin");
	driver.findElement(By.name("login")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	 List<WebElement> products = driver.findElements(By.partialLinkText("Duck"));
	 
     for (int i = 0; i < products.size(); i++) {
    	List<WebElement> list = driver.findElements(By.partialLinkText("Duck"));
    	list.get(i).click();
    	
        driver.manage().logs().get("performance").forEach(l -> System.out.println(l));
        
     }

}



}