package pages;

import org.openqa.selenium.By;

public class Login extends Base{

    By btnLogin = By.xpath("//button[@type='submit']");

    public void clickBtnLogin()
    {
        clickOn(btnLogin);
    }
}
