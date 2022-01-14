package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    /**
     * documentation/LoginPage.png
     */

    @FindBy(xpath = "//input[@autocomplete='username']")
    private WebElement fieldUserName;

    @FindBy(xpath = "//button[@id='signin-continue-btn']")
    private WebElement buttonContinue;

    @FindBy(xpath = "//p[@id='errormsg']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void isErrorMessageVisible() {
        errorMessage.isDisplayed();
    }

    public void inputFieldUserName(String Name) {
        fieldUserName.sendKeys(Name);
    }

    public WebElement getFieldUserName(){
        return fieldUserName;
    }

    public void clickButtonContinue(){
        buttonContinue.click();
    }
}
