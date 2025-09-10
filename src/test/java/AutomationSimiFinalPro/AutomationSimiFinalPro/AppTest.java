package AutomationSimiFinalPro.AutomationSimiFinalPro;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest 
{
	WebDriver driver=new ChromeDriver();
	Random rand=new Random();
	String webSite="https://codenboxautomationlab.com/practice/";
	@BeforeTest
	public void mySetUp () {
		driver.manage().window().maximize();
		driver.get(webSite);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));//هاي معناها انه لما ما يلاقي اي عنصر ضمنيا يستنى ماكسمم 3 ثواني لحتى يلاقيه بس بحال لاقاه ب اول ربع ثانية خلص بينقل اما الثريد مشكلته بده يستنى الوقت الي انحطله سواء لاقاه او لا و الثريد برضه منضطر نستخدمه لما يكون الاشي دخله بالانترنت يعني لو كان النت كتير طي او سريع منضطر نستخدم الثريد
		
	}
	
	@Test(priority=1 , enabled=false)
	public void autoCompleteTest () throws InterruptedException {
		WebElement autoCompleteInputField=driver.findElement(By.cssSelector(".inputs.ui-autocomplete-input"));
		//autoCompleteInputField.sendKeys("hello");
		String []countries= {"jo" ,"sy" ,"ja","ye"};
		int randomIndex=rand.nextInt(countries.length);
		autoCompleteInputField.sendKeys(countries[randomIndex]);
		Thread.sleep(1000);
		autoCompleteInputField.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));
		//		WebElement inputPassword=driver.findElement(By.id("password"));
//		inputPassword.sendKeys(password);
//		Thread.sleep(2000);
//		driver.findElement(By.id("login-button")).click();;
	}
	@Test(priority=2,enabled= false)
	public void selectOption () throws InterruptedException {
		WebElement theSelector=driver.findElement(By.id("dropdown-class-example"));
		Select select=new Select(theSelector);
		//select.selectByVisibleText("Appium");
		//select.selectByIndex(2);
		select.selectByValue("option3");
		System.out.println(theSelector.findElements(By.tagName("option")).size());
		
	}
	@Test(priority=3 , enabled=false)
	public void selectCheckBox () throws InterruptedException {
//		WebElement theSelector=driver.findElement(By.id("checkbox-example"));
//		Select select=new Select(theSelector);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,200)");
		WebElement theCheckBox=driver.findElement(By.id("checkbox-example")); 
		List<WebElement> allCheckBoxes=theCheckBox.findElements(By.tagName("input"));
		int random=rand.nextInt(allCheckBoxes.size());
		allCheckBoxes.get(random).click();
//		for(int i=0 ; i<allCheckBoxes.size();i++) {
//			allCheckBoxes.get(i).click();
//		}
		//select.selectByVisibleText("Appium");
		//select.selectByIndex(2);
//		select.selectByValue("option3");
//		System.out.println(theSelector.findElements(By.tagName("option")).size());
		
	}
	@Test (priority=4, enabled=false)
	public void window_example() throws InterruptedException {
		WebElement switchWindowExample=driver.findElement(By.id("openwindow"));
		switchWindowExample.click();
		Set <String> handles=driver.getWindowHandles();
		List <String> windowList=new ArrayList<>(handles);//list same arraylist
		driver.switchTo().window(windowList.get(1));
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
//		Thread.sleep(4000);
		//driver.findElement(By.xpath("//*[@id=\"menu-item-9660\"]/a/span[1]")).click();
		driver.switchTo().window(windowList.get(0));
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
	}
	
	@Test (priority=5 ,enabled=false)
	public void switch_tab_example() throws InterruptedException {
		WebElement switchTabExample=driver.findElement(By.id("opentab"));
		switchTabExample.click();
		Set <String> handles=driver.getWindowHandles();
		List <String> TabList=new ArrayList<>(handles);//list same arraylist
		driver.switchTo().window(TabList.get(1));
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.switchTo().window(TabList.get(0));
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
	}
	@Test(priority=6 , enabled=false)
	public void alert() throws InterruptedException {
		Thread.sleep(2000);// سه احنا صحيح اعملنا فوق امبلست ويت بس اضطرينا نحط هون ثريد لانه الويب سايت لسا بيعمل لودنغ مع انه الدرايفر شاف كل العناصر بس مش قادر يعمل اشي لانه طول ما الوبسايت عم يعمل تحميل ف مستحيل الدرايفر يقدر يعمل اي اكشن ف بدنا نجبره انه يستنى عن طريق ثريد 
		WebElement inputFeildForTheName=driver.findElement(By.id("name"));
		inputFeildForTheName.sendKeys("dema");
		WebElement alertButton=driver.findElement(By.id("alertbtn"));
		alertButton.click();
		Thread.sleep(2000); // هون اضطرينا نحطها بس عشانا احنا حابين  نشوف الاسم و هو بينكتب وقت التست لانه لو ما حطيناها التست رح يصير سريع سريع عشان النت و ما لاح نشوف انه الاسم انكتب
		driver.switchTo().alert().accept();
//		WebElement alertconfirmButton=driver.findElement(By.id("confirmtbtn"));
//		alertconfirmButton.click();
//		driver.switchTo().alert().accept();
//		driver.switchTo().alert().dismiss();

	}
	@Test (priority=7 , enabled =false)
	public void Table() {
		// to print all rows 
		WebElement theTable=driver.findElement(By.id("product"));
		List <WebElement> allRows=theTable.findElements(By.tagName("tr"));//و ممكن نحط نطبع بس الهيد ف منحط th
		List <WebElement> allData=theTable.findElements(By.tagName("td"));

		
		//to print random row 
//		int randomRow=rand.nextInt(allRows.size());
//		System.out.println(allRows.get(randomRow).getText());
		
		//to print all rows 
//		for(int i=0 ;i<allRows.size();i++) {
//			System.out.println(allRows.get(i).getText());
//		}
		
		//to print just data body without data head
		for(int i=0 ;i<allData.size();i++) {
			System.out.println(allData.get(i).getText());
		}
		
		
		//driver.findElement(By.id("name")).sendKeys(allData.get(0).getText());
		
		//to print just names of instructers
//		for(int i=0 ;i<allData.size();i=i+3) {
//			System.out.println(allData.get(i).getText());
//		}
		
		//to print just names of courses
//		for(int i=1 ;i<allData.size();i=i+3) {
//			System.out.println(allData.get(i).getText());
//		})
	}
	
	@Test(priority=8 ,enabled=false)
	public void hideAndShow() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1900)");
		Thread.sleep(2000);
//		js.executeScript("alert('hi soso ')");
//		Thread.sleep(2000);
//		driver.switchTo().alert().accept();
		WebElement HideButton=driver.findElement(By.id("hide-textbox"));
		HideButton.click();
		Thread.sleep(2000); // مش مضطرة احطها بس انه الهدف عشان نشوف سوا 
		WebElement ShowButton=driver.findElement(By.id("show-textbox"));
        ShowButton.click();
	}
	
	@Test(priority=9 ,enabled=false)
	public void EnabledDisabled() throws InterruptedException {
		WebElement DisabledButton=driver.findElement(By.id("disabled-button"));
		DisabledButton.click();
		Thread.sleep(2000); // مش مضطرة احطها بس انه الهدف عشان نشوف سوا 
		WebElement inputField=driver.findElement(By.id("enabled-example-input"));
		WebElement EnabledButton=driver.findElement(By.id("enabled-button"));
        EnabledButton.click();
        inputField.sendKeys("soso");
	}
	
	@Test(priority=10 , enabled=false)
	public void mouseHover() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1800)");
		Thread.sleep(2000);
		WebElement theElementNeddToMoveTo=driver.findElement(By.id("mousehover"));
		Actions action=new Actions (driver);// اوبجكت بتتحكم بالتنقلات
		action.moveToElement(theElementNeddToMoveTo).click().perform();
		Thread.sleep(2000); // مش مضطرة احطها بس انه الهدف عشان نشوف سوا 
		WebElement partialTop=driver.findElement(By.partialLinkText("To"));
        partialTop.click();
		WebElement Top=driver.findElement(By.linkText("Top"));
		Top.click();
//		WebElement reload=driver.findElement(By.linkText("Reload"));
//		Reload.click();
		//driver.navigate().refresh();
        //partiallinktext and link text ما بيشتغلو غير على تاغات ال a
		
	}
	@Test(priority=11, enabled=false)
	public void calendar () throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1800)");
		Thread.sleep(2000);
		WebElement TabCalendar=driver.findElement(By.linkText("Booking Calendar"));
		TabCalendar.click();
		Thread.sleep(2000);
		Set <String> handles=driver.getWindowHandles();
		List <String> TabList=new ArrayList<>(handles);//list same arraylist
		driver.switchTo().window(TabList.get(1));
		WebElement TheTable=driver.findElement(By.cssSelector(".datepick.wpbc_calendar"));
		List <WebElement> tds=TheTable.findElements(By.tagName("td"));
		for(int i=0 ; i<tds.size();i++) {
			System.out.println(tds.get(i).getText());
		}

	}
	@Test(priority=12,enabled=false)//محاضرة رقم 11
	public void iFrame () throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,2200)");
		Thread.sleep(1000);
		//دايما اي فريم جوا ويب سايت منعامله زي ك انه صفحة html inside html 
		//بالتالي ما بيقدر يشوف اي عنصر داخل هاي الفريم الا لما نعمل سويتش عليها 
		driver.switchTo().frame("iframe-name");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ct-mobile-meta-item.btn-nav-mobile.open-menu")).click();
		Thread.sleep(2000);
		Set <String> handles=driver.getWindowHandles();
		List <String> TabList=new ArrayList<>(handles);
		driver.switchTo().window(TabList.get(0));
		Thread.sleep(2000);
		WebElement TabCalendar=driver.findElement(By.linkText("Booking Calendar"));
		TabCalendar.click();
		Set <String> handles2=driver.getWindowHandles();
		List <String> TabList2=new ArrayList<>(handles2);
        driver.switchTo().window(TabList2.get(1));
        System.out.println(driver.getTitle());
	}
	@Test(priority=13)
			public void download () {
		WebElement downloadFile=driver.findElement(By.linkText("Download Apk files"));
        downloadFile.click();
        }
		
}
