import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task13 extends TestBase{

    @Test
    public void cart() throws InterruptedException {
    driver.get("http://localhost/litecart/public_html/en/");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     for (int i = 0; i <3; i++) {
     List<WebElement> products = driver.findElements(By.className("product"));
     products.get(i).click();
     Integer quantity = Integer.parseInt(driver.findElement(By.cssSelector("#cart .quantity")).getText());
     driver.findElement(By.cssSelector("[name=add_cart_product]")).click();
     wait.until((WebDriver d) -> quantity != Integer.parseInt(driver.findElement(By.cssSelector("#cart .quantity")).getText()));
     driver.findElement(By.id("logotype-wrapper"));
    }
  
    }
   
    }
    


