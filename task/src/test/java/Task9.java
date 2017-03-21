import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Task9 extends TestBase{
	
	@Test
	public void sortingCountry() {
		
		driver.navigate().to("http://localhost/litecart/public_html/admin/?app=countries&doc=countries");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> tableCountry = driver.findElements(By.cssSelector("dataTable tr.row"));
		List<String> country = new ArrayList<String>();
		List<String> sortCountry = new ArrayList<String>();
		
		for (int i = 0; i < tableCountry.size(); i++) {
			String tempArray = tableCountry.get(i).getAttribute("textContent");
			country.add(tempArray);
			sortCountry.add(tempArray);
		}
		
		Collections.sort(sortCountry);
			
		for (int i = 0; i < tableCountry.size(); i++) {
			if (!country.get(i).equals(sortCountry.get(i))) {
				System.out.println("Страны не в алфавитном порядке:" + i + "ошибка");
			}
		}
	     System.out.println("something");      

     
}
}