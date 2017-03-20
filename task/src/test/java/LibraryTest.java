/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.After;
import org.junit.Before;

public class LibraryTest {
	private WebDriver driver;
   

    @Before
    public void start() {
        driver = new ChromeDriver();
    
    }

    @Test
    public void firstTest () {
        driver.get("http://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnG")).click();
      

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
   
}
