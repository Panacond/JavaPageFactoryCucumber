package manager;

import org.openqa.selenium.WebDriver;

import pages.*;


public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public NewsPage getNewsPage() {
        return new NewsPage(driver);
    }

    public SearchPage getSearchPage() {
        return new SearchPage(driver);
    }

    public XiaomiPage getXiaomiPage() {
        return new XiaomiPage(driver);
    }

    public XiaomiVacuumCleanersPage getXiaomiVacuumCleanersPage() {
        return new XiaomiVacuumCleanersPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    public AccountPage getAccountPage() {
        return new AccountPage(driver);
    }
}
