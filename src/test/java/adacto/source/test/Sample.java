package adacto.source.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {


	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver ();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://adactinhotelapp.com/");
		WebElement ele1 = driver.findElement(By.xpath("//input[@id='username']"));
		ele1.sendKeys(BaseClass.ExceTestData(1,0));//Passing email using ExcelData
		WebElement ele2 = driver.findElement(By.xpath("//input[@id='password']"));
		ele2.sendKeys(BaseClass.ExceTestData(1,1));//Passing password using ExcelData
		WebElement click = driver.findElement(By.xpath("//input[@id='login']"));
		click.click();

		driver.navigate().to("http://adactinhotelapp.com/SelectHotel.php");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement siz = driver.findElement(By.xpath("//input[@id='rooms_1']"));
		String e  = siz.getText();
		System.out.println(e);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		String text=(String) js.executeScript("return arguments[0].getAttribute('value')",siz);
		System.out.println(text);

		String e1 = siz.getAttribute("value");
		System.out.println(e1 + "dadad");

		//			for (WebElement webElement : siz) {
		//				System.out.println(webElement.getText());
		//			}
		//
		//			for (int i = 2; i <10; i++) {
		//				WebElement ele = driver.findElement(By.xpath("//*[@id=\"select_form\"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td["+i+"]"));
		//				String e = ele.getAttribute("value");
		//				System.out.println(e);
		//			}
	}
}


