package Base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import Application_utility.Application_utility;
import property_utility.propertyutility;
import screenshotutility.Screenshotutility;
import wait_utility.Waitutility;

public class BaseTest  implements propertyutility,Waitutility, Application_utility, Screenshotutility{
	public static  WebDriver driver;
	  String Configpath= "/home/ravi/eclipse-workspace/SwagLabs/ConfigFile/Config";
	public void Launchurl(String url) {

		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));   
		
	}

	@Override
	public String getreaddata(String key) {
		
		String value= "";
		try {
			FileInputStream fis =new FileInputStream(Configpath);
			Properties prop =new Properties();
			prop.load(fis);
			value=prop.getProperty(key);
			
			return value;
		
		} 
		catch (Exception e) {
			System.out.println("Issue in Get read data property File +"+e);
		}
		return value;
		
	}

	@Override
	public void elementtobeselected(WebElement ele) {
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeSelected(ele));
		
	}

	@Override
	public void elementtobeclickable(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
	}

	@Override
	public void visibleofelement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}

	@Override
	public void clickme(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
	}

	@Override
	public void doubleclick(WebElement ele) {
		Actions act= new Actions(driver);
		act.doubleClick(ele).perform();
		
	}

	@Override
	public void rightclick(WebElement ele) {
		Actions act= new Actions(driver);
		act.contextClick(ele).perform();
		
	}

	@Override
	public void selectbyvalue(WebElement ele, String value) {
		Select sel = new Select(ele);
		sel.selectByValue(value);
		
	}

	@Override
	public void mousehover(WebElement ele, String target) {
		Actions act= new Actions(driver);
		act.moveToElement(ele).build().perform();
		driver.findElement(By.xpath(target)).click();
		
	}
	

	@Override
	public void getScreenshot(String foldername, String filename) {
		String loc = System.getProperty("user.dir");
//	String path= loc+ "\\screenshots+\\"+foldername+"\\"+filename+".png";
		String path="/home/ravi/eclipse-workspace/SwagLabs/screenshots"+"\\"+foldername+"\\"+filename+".png";
//		String path = "/home/ravi/eclipse-workspace/SwagLabs/Screenshots+"\\+foldername+\\"+filename+".png";
		
	
		
		try {
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(path));
			
		} catch (Exception e) {
			System.out.println("Issue in get Screenshot Method"+e);
		}
	}
	@AfterMethod
	public void getanalysis(ITestResult result)
	{
		String Filename = result.getMethod().getMethodName();
		try {
			
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			getScreenshot("passed", Filename);
		}
		else if (result.getStatus()==ITestResult.FAILURE)
		{
			getScreenshot("failed", Filename);
		}
			
		} catch (Exception e) {
			System.out.println("Issue in get analysis method"+e);
		}
	}
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}
	}
