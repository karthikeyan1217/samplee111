package adacto.source.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Timeout;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdectoLogin extends BaseClass {

	static WebDriver driver = null;
	static Select obj ;
	BaseClass base ;

	void login ()  {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://adactinhotelapp.com/");
		WebElement ele1 = driver.findElement(By.xpath("//input[@id='username']"));
		ele1.sendKeys(BaseClass.ExceTestData(1,0));//Passing email using ExcelData
		WebElement ele2 = driver.findElement(By.xpath("//input[@id='password']"));
		ele2.sendKeys(BaseClass.ExceTestData(1,1));//Passing password using ExcelData
		WebElement click = driver.findElement(By.xpath("//input[@id='login']"));
		click.click();
	}

	void DropowCountry() {
		WebElement o =driver.findElement(By.id("location"));
		Select obsj = new Select(o);
		List <WebElement> nmm = obsj.getOptions();
		for (WebElement webElement : nmm) {	
			String b = BaseClass.ExceTestData(2, 1);
			if(webElement.getText().equals(b)) ;
			obsj.selectByVisibleText(b);
System.out.println("sample");
		}
	}

	void selectHotel () {
		WebElement ele = driver.findElement(By.xpath("//select[@id='hotels']"));
		obj = new Select (ele);
		String x = BaseClass.ExceTestData(3, 1);

		obj.selectByVisibleText(x);
	}

	void SelectRoom () {
		WebElement ele = driver.findElement(By.id("room_type"));
		obj = new Select (ele);
		List<WebElement> lis = obj.getOptions();
		for (WebElement webElement : lis) {
			if(webElement.getText().equals(BaseClass.ExceTestData(4, 1))){
				webElement.click();
			}
		}
	}

	void numberOfRoom () {
		WebElement ele = driver.findElement(By.xpath("//select[@id='room_nos']"));
		obj = new Select (ele);
		List<WebElement> lis = obj.getOptions();
		for (WebElement webElement : lis) {
			String e = BaseClass.ExceTestData(5, 1);
			int p = Integer.parseInt(e);
			obj.selectByIndex(p);	
		}
	}


	void SelectCheckinDate ()  {
		WebElement Ele = driver.findElement(By.xpath("//*[@id = 'datepick_in']"));
		Ele.clear();
		Ele.sendKeys("1/3/2023");
	}

	void SelectCheckoutDate()  {
		WebElement Ele = driver.findElement(By.xpath("//input[@id='datepick_out']"));
		Ele.clear();
		Ele.sendKeys("1/3/2023");
	}

	void adultspeRoom ()  {
		WebElement Ele = driver.findElement(By.xpath("//select[@id='adult_room']"));
		obj = new Select (Ele);
		String e= BaseClass.ExceTestData(8, 1);
		int i = Integer.parseInt(e);
		obj.selectByIndex(i);
	}

	void ChildrenperRoom ()  {
		WebElement Ele = driver.findElement(By.xpath("//select[@id='child_room']"));
		obj = new Select (Ele);
		String e= BaseClass.ExceTestData(9, 1);
		int i = Integer.parseInt(e);
		obj.selectByIndex(i);
		//moved to another page
		WebElement Ele2 = driver.findElement(By.xpath("//input[@id='Submit']"));
		Ele2.click();
	}

	void hotelCheck ()  { //handlingWbeTable
		List <WebElement> siz = driver.findElements(By.xpath("((//table)[5]/tbody/tr)[2]/td"));
		int si = siz.size();

		for (int i = 2; i <=si; i++) {
			WebElement ele = driver.findElement(By.xpath("((//table)[5]/tbody/tr)[2]/td["+i+"]"));
			String t = ele.getText();
			System.out.println(t+"kkk" + "dadad");
		}



		//		
		//		WebElement Searach = driver.findElement(By.xpath("//input[@id='continue']"));
		//		Searach.click();


	}

	void name ()  { //handlingWbeTable
		WebElement firstname = driver.findElement(By.xpath("//input[@id='first_name']"));
		firstname.sendKeys(BaseClass.ExceTestData(11, 1));

		WebElement lastname = driver.findElement(By.xpath("//input[@id='last_name']"));
		lastname.sendKeys(BaseClass.ExceTestData(12, 1));

		WebElement Billingadress = driver.findElement(By.xpath("//textarea[@id='address']"));
		Billingadress.sendKeys(BaseClass.ExceTestData(13, 1));

		WebElement Cardno = driver.findElement(By.xpath("//input[@id='cc_num']"));
		Cardno.sendKeys(BaseClass.ExceTestData(14, 1));

	}

	void CardSelection (){
		WebElement Billingadress = driver.findElement(By.id("cc_type"));
		obj = new Select (Billingadress);
		obj.selectByVisibleText(BaseClass.ExceTestData(15, 1));

	}

	void cardExpiryDate (){
		WebElement cardExpiryDate = driver.findElement(By.id("cc_exp_month"));
		obj = new Select (cardExpiryDate);
		obj.selectByValue(BaseClass.ExceTestData(16, 1));

	}

	void Expirationyear (){
		WebElement Expirationyear = driver.findElement(By.id("cc_exp_year"));
		obj = new Select (Expirationyear);
		obj.selectByVisibleText((BaseClass.ExceTestData(17, 1)));

	}

	void cvv (){
		WebElement cvv = driver.findElement(By.id("cc_cvv"));
		cvv.sendKeys(BaseClass.ExceTestData(18, 1));

	}

	void Submit (){
		WebElement cvv = driver.findElement(By.id("book_now"));
		cvv.submit();
	}


	public void  printErrorBooking() {

		String name = "Adeco.test";
		WebElement ele = driver.findElement(By.xpath("//input[@id='order_no']"));
		String setval = ele.getAttribute("value"); //booking id
		FileWritting.ExcelWritting(name, 0, 0, setval);
		FileWritting.ExcelWritting(name, 0, 1, "kka");
		

	}

	public static void main(String[] args)	   {
		AdectoLogin adectoLogin = new AdectoLogin();
		adectoLogin.login();
		adectoLogin.DropowCountry();
		adectoLogin.selectHotel();
		adectoLogin.SelectRoom ();
		adectoLogin.numberOfRoom();
		adectoLogin.SelectCheckinDate();
		adectoLogin.SelectCheckoutDate();
		adectoLogin.adultspeRoom();
		adectoLogin.ChildrenperRoom();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adectoLogin.hotelCheck();
		//		adectoLogin.name();
		//		adectoLogin.CardSelection();
		//		adectoLogin.cardExpiryDate();
		//		adectoLogin.Expirationyear();
		//		adectoLogin.cvv();
		//		adectoLogin.Submit();
		//		adectoLogin.printErrorBooking();

	}

}


