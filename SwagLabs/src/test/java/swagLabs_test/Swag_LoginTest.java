package swagLabs_test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.BaseTest;
import SwagLabs_pages.Swag_LoginPage;

public class Swag_LoginTest  extends BaseTest{
	
	Swag_LoginPage swagpage;
	
	
	@BeforeTest
	public void Launchurl() {
		Launchurl("https://www.saucedemo.com/");
		swagpage = new Swag_LoginPage();
		
	}
	@Test(priority=1)
	public void ClickOnLogin() {
		
		swagpage.Login();
		getScreenshot("passed", "Login");
	}
	
	@Test(priority=2)
	public void Verifytitle() {
		
		swagpage.Verifytitle();
	}

	@Test(priority =3)
	public void ClickOnAddToCart()
	{
		swagpage.AddToCart();
	}
}
