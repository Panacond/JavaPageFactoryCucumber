package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountPage extends BasePage{

    @FindBy(xpath = "//input[@type='email']")
    private WebElement fieldMail;

    @FindBy(xpath = "//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']")
    private WebElement buttonNext;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement fieldPassword;

    @FindBy(xpath = "//div[@class='OyEIQ uSvLId']")
    private WebElement errorMassage;

    public AccountPage(WebDriver driver) {

        super(driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1)));
     }


    public void inputFieldMail(String mail ){
        fieldMail.sendKeys(mail);
    }

    public void pressButtonNext(){
        buttonNext.click();
    }

    public void inputFieldPassword(String mail ){
        fieldPassword.sendKeys(mail);
    }

    public void isErrorMassageVisible(){
        errorMassage.isDisplayed();
    }
}
