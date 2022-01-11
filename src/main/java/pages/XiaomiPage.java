package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class XiaomiPage extends BasePage{

    @FindBy(xpath = "//img[@src='https://i.ebayimg.com/thumbs/images/g/URIAAOSwN4BeQSNF/s-l225.webp']")
    private WebElement buttonVacuumCleaners;

    public XiaomiPage(WebDriver driver) {
        super(driver);
    }

    public void pressButtonVacuumCleaners(){
        buttonVacuumCleaners.click();
    }
}
