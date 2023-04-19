package ppp.ada;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Class {
	
	TargetLocator ll ;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-left");
		WebElement ele = driver.findElement(By.xpath("//body[contains(text(), 'LEFT')]"));
		System.out.println(ele.getText());
		driver.switchTo().defaultContent();
		//middle
		driver.switchTo().frame(0);
		WebElement middle = driver.findElement(By.xpath("//*[@name = 'frame-middle']"));
		driver.switchTo().frame(middle);
		WebElement middletxt = driver.findElement(By.xpath("//div[contains(text(), 'MIDDLE')]"));
		System.out.println(middletxt.getText());
		driver.switchTo().parentFrame();
		
		WebElement right = driver.findElement(By.xpath("//*[@name = 'frame-right']"));
		driver.switchTo().frame(right);
		WebElement righttxt = driver.findElement(By.xpath("//body[contains(text(), 'RIGHT')]"));
		System.out.println(righttxt.getText());
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
				
		
		WebElement bottom = driver.findElement(By.xpath("//*[@name = 'frame-bottom']"));
		driver.switchTo().frame(1);
		WebElement bottomtxt = driver.findElement(By.xpath("//body[contains(text(), 'BOTTOM')]"));
		System.out.println(bottomtxt.getText());
		
Thread.sleep(2000);

driver.close();
	}
}
