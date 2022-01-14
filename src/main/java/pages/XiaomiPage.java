package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class XiaomiPage extends BasePage{

    /**
     * documentation/XiaomiPage.png
     */

    @FindBy(xpath = "//div[contains(text(),'Cleaners')]")
    private WebElement buttonVacuumCleaners;

    public XiaomiPage(WebDriver driver) {
        super(driver);
    }

    public void pressButtonVacuumCleaners(){
        buttonVacuumCleaners.click();
    }
}
