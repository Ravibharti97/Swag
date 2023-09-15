package Application_utility;

import org.openqa.selenium.WebElement;

public interface Application_utility {
	
	
	public void doubleclick(WebElement ele);
	public void rightclick(WebElement ele);
	public void selectbyvalue(WebElement ele, String value);
	public void mousehover(WebElement ele, String target);
	public void clickme(WebElement ele);

}
