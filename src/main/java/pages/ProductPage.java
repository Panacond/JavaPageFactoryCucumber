package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//span[text()='Add to Watchlist']")
    private WebElement buttonAddToWatchlist;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void pressButtonAddToWatchlist() {
        buttonAddToWatchlist.click();
    }
}
