import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
public class Task13 extends TestBase{

	@Test
	public void cart()  {
		driver.get("http://localhost/litecart/public_html/en/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		for (int i = 0; i <3; i++) {
			List<WebElement> products = driver.findElements(By.className("product"));
			products.get(i).click();
			Integer quantity = Integer.parseInt(driver.findElement(By.cssSelector("#cart .quantity")).getText());
			if(areElementsPresent(driver, By.cssSelector("td.options select"))) {
				Select options = new Select(driver.findElement(By.cssSelector("select[name*=options]")));
				options.selectByIndex(1);

			}
			driver.findElement(By.cssSelector("[name=add_cart_product]")).click();
			wait.until((WebDriver d) -> quantity != Integer.parseInt(driver.findElement(By.cssSelector("#cart .quantity")).getText()));
		}
		driver.findElement(By.id("logotype-wrapper")).click();


		driver.findElement(By.partialLinkText("Checkout »")).click();
		wait.until(titleIs("Checkout | My Store"));
		for(int product = 0; product < 3; product++) {
			WebElement table = driver.findElement(By.cssSelector("table.dataTable.rounded-corners")) ;
			driver.findElement(By.cssSelector("button[name=remove_cart_item]")).click();
			wait.until(ExpectedConditions.stalenessOf(table));
		}
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div#content em"),
				"There are no items in your cart."));
	}

}  



