import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Task8 {
	private WebDriver driver;
	
	
	   @Before
	    public void start() {
	        driver = new ChromeDriver();
	      	    }
	
    @Test
    public void stickers() {
    	driver.get("http://localhost/litecart/public_html/en/");
        List<WebElement> products = driver.findElements(By.cssSelector("a.link[title*=Duck]"));
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).findElements(By.cssSelector("[class^=sticker]")).size() == 1) 
            {
            System.out.println(products.get(i).getAttribute("href") + "everything is ok ");
            } 
            else  System.out.println(products.get(i).getAttribute("href") + "product has more than 1 stikers");
            }
        }
    
    
    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}



