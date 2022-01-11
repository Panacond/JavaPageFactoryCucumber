package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@href='https://www.ebayinc.com/stories/news/']")
    private WebElement newsPage;

    @FindBy(xpath = "//input[@placeholder='Search for anything']")
    private WebElement fieldSearch;

    @FindBy(xpath = "//input[@id='gh-btn']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//img[@src='https://i.ebayimg.com/images/g/pq0AAOSwOFFeJrV0/s-l200.webp']")
    private WebElement buttonXiaomi;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void goNewsPage() {
        newsPage.click();
    }

    public void inputFieldSearch(String text){
        fieldSearch.sendKeys(text);
    }

    public void pressButtonSearch(){
        buttonSearch.click();
    }

    public void pressButtonXiaomi(){
        buttonXiaomi.click();
    }


}
