package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {
    @FindBy(xpath = "//h3[@class='s-item__title']")
    private List<WebElement> resultTitleSearch;

    @FindBy(xpath = "//h3[text()='No exact matches found']")
    private WebElement negativeResult;

    @FindBy(xpath = "//input[@aria-label='Minimum Value in $']")
    private WebElement fieldPrice;

    @FindBy(xpath = "//div[@class='x-price__error']")
    private List<WebElement> resultFind;

    @FindBy(xpath = "//span[text()='Tomato']")
    private WebElement commonName;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getResultTitleSearch() {
        return resultTitleSearch;
    }

    public void isNegativeResultVisible() {
        negativeResult.isDisplayed();
    }

    public void inputFieldPrice(String text) {
        fieldPrice.sendKeys(text, Keys.ENTER);
    }

    public boolean ErrorInputPriceValue() {
        boolean expected = true;
        if (resultFind.size() == 1) expected = false;
        return expected;
    }

    public void setCommonName() {
        commonName.click();
    }
}
