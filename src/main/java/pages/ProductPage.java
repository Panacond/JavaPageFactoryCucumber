package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//span[text()='Add to Watchlist']")
    private WebElement buttonAddToWatchlist;

    @FindBy(xpath = "//input[@class='qtyInput']")
    private WebElement fieldNumberProduct;

    @FindBy(xpath = "//div[@id='w1-13-_errMsg']")
    private WebElement errorNumberMessage;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void pressButtonAddToWatchlist() {
        buttonAddToWatchlist.click();
    }

    public void inputFieldNumberProduct(int number){
        fieldNumberProduct.sendKeys(String.valueOf(number));
    }

    public void clickFieldNumberProduct(){
        fieldNumberProduct.click();
    }

    public void isErrorNumberMessage(){
        errorNumberMessage.isDisplayed();
    }


}
