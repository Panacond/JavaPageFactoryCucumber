package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//div[@class='article-wrapper internal-article wide-ml-content animate']")
    private WebElement elementNews;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getElementNews() {
        return elementNews;
    }

    public void isElementNewsVisible(){
        elementNews.isDisplayed();
    }

}
