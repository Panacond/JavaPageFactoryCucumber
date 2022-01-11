package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class XiaomiVacuumCleanersPage extends BasePage {

    @FindBy(xpath = "//span[text()='Price']")
    private WebElement buttonPrice;

    @FindBy(xpath = "//span[text()='$150.00 to $350.00']")
    private WebElement selectPriceRange150_350;

    @FindBy(xpath = "//span[@class='s-item__price']")
    private List<WebElement> checkPrise;

    @FindBy(xpath = "//button[@aria-label='Gallery View']")
    private WebElement buttonView;

    @FindBy(xpath = "//span[text()='List View']")
    private WebElement buttonViewList;

    @FindBy(xpath = "//ul[@class='b-list__items_nofooter']")
    private WebElement elementViewList;

    @FindBy(xpath = "//div[@class='s-item__wrapper clearfix']")
    private WebElement firstElementList;

    @FindBy(xpath = "//input[@aria-label='Search for anything']")
    private WebElement searchField;

    @FindBy(xpath = "//h3[@class='s-item__title']")
    private List<WebElement> listResultTitle;

    public XiaomiVacuumCleanersPage(WebDriver driver) {
        super(driver);
    }

    public void pressButtonPrice() {
        buttonPrice.click();
    }

    public void pressSelectPriceRange150_350() {
        selectPriceRange150_350.click();
    }

    public List<WebElement> getCheckPrise() {
        return checkPrise;
    }

    public void pressButtonView() {
        buttonView.click();
    }

    public void pressButtonViewList() {
        buttonViewList.click();
    }

    public void isElementViewListVisible() {
        elementViewList.isDisplayed();
    }

    public void clickFirstElementList() {
        firstElementList.click();
    }

    public void inputSearchField(String text) {
        searchField.sendKeys(text, Keys.ENTER);
    }

    public List<WebElement> getListResultTitle() {
        return listResultTitle;
    }


}
