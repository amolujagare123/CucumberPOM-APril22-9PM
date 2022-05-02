package pages;

import org.openqa.selenium.By;

public class DarkskyAPI extends Base{

    By lnkLogin = By.xpath("//a[@class='button']");

    public void clickLogin()
    {
        clickOn(lnkLogin);
    }
}
