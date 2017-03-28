import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Task14 extends TestBase{
	
	@Test
	  public void logs() {
	driver.navigate().to("http://localhost/litecart/public_html/admin/?app=countries&doc=countries");
	driver.findElement(By.name("username")).sendKeys("admin");
	driver.findElement(By.name("password")).sendKeys("admin");
	driver.findElement(By.name("login")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.className("fa-pencil")).click();
	
	List<WebElement> newWindows = driver.findElements(By.className("fa-external-link"));
	
	  for (int i = 0; i < newWindows.size(); i++) {
	    	List<WebElement> list = driver.findElements(By.className("fa-external-link"));
	    	String homeWindow = driver.getWindowHandle();
	    	Set<String> existingWindows = driver.getWindowHandles();
	    	list.get(i).click();
	    	String newWindow = wait.until(thereIsWindowOtherThan(existingWindows));
	    	driver.switchTo().window(newWindow);
	    	
	    	driver.close();
	    	driver.switchTo().window(homeWindow);
	        
	     }

	}
}
