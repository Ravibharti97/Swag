package SwagLabs_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.BaseTest;

public class Swag_LoginPage  extends BaseTest{
	
	
	public Swag_LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='user-name']")
	private WebElement Username;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement Password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement Loginbtn;

	@FindBy(xpath="//div[text()='Sauce Labs Backpack']")
	private WebElement Saucebackpack;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	private WebElement Add_backpack;
	
	@FindBy(xpath="//div[text()='Sauce Labs Bike Light']")
	private WebElement Saucebikelite;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']")
	private WebElement Addbikelight;
	
	@FindBy(xpath="//div[text()='Sauce Labs Bolt T-Shirt']")
	private WebElement Sauce_t_shirt;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
	private WebElement Addtshirt;
	
	@FindBy(xpath="//button[@id='back-to-products']")
	private WebElement Backtoproduct;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	private WebElement Cartbtn;
	
	@FindBy(xpath="//button[@id='checkout']")
	private WebElement Checkoutbtn;
	
	@FindBy(xpath="//input[@name='firstName']")
	private WebElement Firstname;
	
	@FindBy(xpath="//input[@name='lastName']")
	private WebElement Lastname;
	
	@FindBy(xpath="//input[@id='postal-code']")
	private WebElement Postalcode;
	
	@FindBy(xpath="//input[@name='continue']")
	private WebElement Continuebtn;
	
	@FindBy(xpath="//button[text()='Finish']")
	private WebElement Finishbtn;
	
	@FindBy(xpath="//h2[@class='complete-header']")
	private WebElement Confirmatiommessage;
	
	@FindBy(xpath="//button[text()='Back Home']")
	private WebElement Backbtn;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	private WebElement Verify;
	
	public void Login()
	{
		Username.sendKeys(getreaddata("username"));
		Password.sendKeys(getreaddata("password"));
		Loginbtn.click();
		
	}
	public void Verifytitle() {
		
		String Actualtitle=driver.getTitle();
		String expected ="Swag Labs";
		System.out.println(Actualtitle);
		Assert.assertEquals(Actualtitle, expected);
		System.out.println("Title is Successfully Verified");
		
	}
	public void AddToCart() {
		Saucebackpack.click();
		Add_backpack.click();
		Backtoproduct.click();
	//	elementtobeclickable(Saucebackpack);
	//	elementtobeclickable(Add_backpack);
	//	elementtobeclickable(Backtoproduct);
		
		
		Saucebikelite.click();
		Addbikelight.click();
		Backtoproduct.click();
	
		
		
		Sauce_t_shirt.click();
		Addtshirt.click();
		Backtoproduct.click();
		
	String value= Verify.getText();
	System.out.println("Total number of Items You Added"+" "+value);
		Cartbtn.click();

		Checkoutbtn.click();

		Firstname.sendKeys(getreaddata("firstn"));
		Lastname.sendKeys(getreaddata("lastn"));
		Postalcode.sendKeys(getreaddata("postalcode"));
		
		Continuebtn.click();
		Finishbtn.click();
//		elementtobeclickable(Continuebtn);
//		elementtobeclickable(Finishbtn);
		
		String Messsge = Confirmatiommessage.getText();
		System.out.println(Messsge);
		
		
		
	}
	
	
	
	
	
}
