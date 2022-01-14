package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    /**
     * documentation/SearchPage.png
     */

    @FindBy(xpath = "//h3[@class='s-item__title']")
    private List<WebElement> resultTitleSearch;

    @FindBy(xpath = "//h3[text()='No exact matches found']")
    private WebElement noExactMatchesMessage;

    @FindBy(xpath = "//input[@aria-label='Minimum Value in $']")
    private WebElement fieldMinPrice;

    @FindBy(xpath = "//div[@class='x-price__error']")
    private List<WebElement> resultErrorPriceFind;

    @FindBy(xpath = "//span[@class='cbx x-refine__multi-select-cbx']")
    private List<WebElement> relatedSearch;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSearchResultTitle() {
        return resultTitleSearch;
    }

    public void isNoExactMatchesMessageVisible() {
        noExactMatchesMessage.isDisplayed();
    }

    public void setMinimumPrice(String price) {
        fieldMinPrice.sendKeys(price, Keys.ENTER);
    }

    public boolean ErrorInputPriceValue() {
        boolean expected = true;
        if (resultErrorPriceFind.size() == 1) expected = false;
        return expected;
    }

    public void setRelatedSearch(String text) {
        String elementText;
        for (WebElement element : relatedSearch ) {
            try {
                elementText = element.getText();
            } catch (Exception ex) {
                elementText ="";
            }
            System.out.println(elementText);
            if (elementText.contains(text)){
                element.click();
                continue;
            }
        }
    }
}
