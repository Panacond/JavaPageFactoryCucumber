package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignPage extends BasePage {

    @FindBy(xpath = "//input[@autocomplete='username']")
    private WebElement fieldUserName;

    public SignPage(WebDriver driver) {
        super(driver);
    }

    public void isFieldUserNameVisible() {
        fieldUserName.isDisplayed();
    }
}
