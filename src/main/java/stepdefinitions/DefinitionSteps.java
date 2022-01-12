package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.*;

import java.util.ArrayList;
import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 100;

    WebDriver driver;
    HomePage homePage;
    NewsPage newsPage;
    SearchPage searchPage;
    XiaomiPage xiaomiPage;
    XiaomiVacuumCleanersPage xiaomiVacuumCleanersPage;
    ProductPage productPage;
    LoginPage loginPage;
    AccountPage accountPage;

    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User goes to news page")
    public void goNewsPage() {
        homePage = pageFactoryManager.getHomePage();
        homePage.goNewsPage();
    }

    @Then("User sees news list items")
    public void userSeeNewsListItems() {
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        newsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,newsPage.getElementNews());
        newsPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT*2);
        newsPage.isElementNewsVisible();
    }

    @After
    public void tearDown() {
        for ( String element :new ArrayList<>(driver.getWindowHandles()) ) {
            driver.switchTo().window(element).close();
        }
//        driver.close();
    }

    @And("User enters into the search bar {string}")
    public void userEnterIntoTheSearchBarInput_text(String text) {
        homePage = pageFactoryManager.getHomePage();
        homePage.inputFieldSearch(text);

    }

    @And("User presses Search button")
    public void userPressButtonSearch() {
        homePage = pageFactoryManager.getHomePage();
        homePage.pressButtonSearch();
    }

    @Then("User sees at least one item in the list containing {string}")
    public void userSeesAtLeastOneItemInTheListContainingResult_search(String text) {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        List<WebElement>listTitle = searchPage.getSearchResultTitle();
        boolean excepted = false;
        for (WebElement element: listTitle ) {
            if (element.getText().contains(text))
                excepted = true;
                break;
        }
        Assert.assertTrue(excepted);
    }

    @And("User presses Xiaomi button")
    public void userPressButtonXiaomi() {
        homePage = pageFactoryManager.getHomePage();
        homePage.pressButtonXiaomi();
    }

    @And("User presses Vacuum cleaners button")
    public void userPressButtonVacuumCleaners() {
        xiaomiPage = pageFactoryManager.getXiaomiPage();
        xiaomiPage.pressButtonVacuumCleaners();
    }

    @And("User presses Price button")
    public void userPressButtonPrice() {
        xiaomiVacuumCleanersPage = pageFactoryManager.getXiaomiVacuumCleanersPage();
        xiaomiVacuumCleanersPage.pressButtonPrice();
    }

    @And("User selects a price range 150-350")
    public void userSelectAPriceRange() {
        xiaomiVacuumCleanersPage = pageFactoryManager.getXiaomiVacuumCleanersPage();
        xiaomiVacuumCleanersPage.pressSelectPriceRange150_350();
    }

    @Then("User checks prices in the range 150-350 {string}")
    public void userCheckPricesAreInTheRange(String designations) {
        xiaomiVacuumCleanersPage = pageFactoryManager.getXiaomiVacuumCleanersPage();
        List<WebElement>listPrice = xiaomiVacuumCleanersPage.getCheckPrise();
        boolean excepted = true;
        for (WebElement element: listPrice ) {
            String correctedText = element.getText().replace(designations,"");
            correctedText = correctedText.split(" to ")[0];
            double priceValue = Double.parseDouble(correctedText);
            if (priceValue < 150) excepted = false;
            else if (priceValue > 350) excepted = false;
        }
        Assert.assertTrue(excepted);
    }

    @And("User presses View button")
    public void userPressButtonView() {
        xiaomiVacuumCleanersPage = pageFactoryManager.getXiaomiVacuumCleanersPage();
        xiaomiVacuumCleanersPage.pressButtonView();
    }

    @And("User presses View as list button")
    public void userPressTheButtonViewAsAList() {
        xiaomiVacuumCleanersPage = pageFactoryManager.getXiaomiVacuumCleanersPage();
        xiaomiVacuumCleanersPage.pressButtonViewList();
    }

    @Then("User sees a list of items")
    public void userSeesAListOfItems() {
        xiaomiVacuumCleanersPage = pageFactoryManager.getXiaomiVacuumCleanersPage();
        xiaomiVacuumCleanersPage.isElementViewListVisible();
    }

    @And("User select first list item")
    public void userSelectListItem() {
        xiaomiVacuumCleanersPage = pageFactoryManager.getXiaomiVacuumCleanersPage();
        xiaomiVacuumCleanersPage.clickFirstElementList();
    }

    @And("User presses Add to Watchlist button")
    public void userPressButtonAddToWatchlist() {
        productPage = pageFactoryManager.getProductPage();
        productPage.pressButtonAddToWatchlist();
    }


    @And("User inputs field {string}")
    public void userInputUserName(String name) {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.inputFieldUserName(name);
    }

    @Then("User gets negative result")
    public void userGetANegativeResult() {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.isNoExactMatchesMessageVisible();
    }

    @And("User enters vacuum cleaners in the search bar {string} and presses ENTER")
    public void userEnterVacuumCleanersInTheSearchBarInput_textAndPressENTER(String text) {
        xiaomiVacuumCleanersPage = pageFactoryManager.getXiaomiVacuumCleanersPage();
        xiaomiVacuumCleanersPage.inputSearchField(text);
    }

    @Then("User checks list items contain {string}")
    public void checkListItemsContainResult_search(String text) {
        xiaomiVacuumCleanersPage = pageFactoryManager.getXiaomiVacuumCleanersPage();
        List<WebElement>listTitle = xiaomiVacuumCleanersPage.getListResultTitle();
        boolean excepted = false;
        for (WebElement element: listTitle ) {
            System.out.println(element.getText());
            if (element.getText().contains(text))
                excepted = true;
            break;
        }
        Assert.assertTrue(excepted);
    }

    @And("User inputs minimum price {string}")
    public void userInputPriceInput_price(String text) {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.setMinimumPrice(text);
    }

    @Then("User sees an exception")
    public void userSeesAnException() {
        searchPage = pageFactoryManager.getSearchPage();
        Assert.assertTrue(searchPage.ErrorInputPriceValue());

    }

    @And("User selects {string} check button")
    public void userSelectCheckButton(String text) {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.setRelatedSearch(text);
    }

    @And("User presses Continue button")
    public void userPressesContinueButton() {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.pressButtonContinue();
    }

    @Then("User sees Error message")
    public void userSeesErrorMessage() {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        loginPage.isErrorMessageVisible();
    }

    @And("User presses Continue with Google button")
    public void userPressesContinueWithGoogleButton() {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.clickButtonContinueWithGoogle();
        String URL = driver.getCurrentUrl();
    }

    @And("User inputs {string} mail")
    public void userInputsUserMail(String mail) {
        accountPage = pageFactoryManager.getAccountPage();
        accountPage.inputFieldMail(mail);
    }

    @And("User presses Next Button")
    public void userPressesNextButton() throws InterruptedException {
        Thread.sleep(20);
        accountPage = pageFactoryManager.getAccountPage();
        accountPage.pressButtonNext();
    }

    @And("User inputs {string} password")
    public void userInputsUserPasswordPassword(String password) {
        accountPage = pageFactoryManager.getAccountPage();
        accountPage.waitForAjaxToCompletePdp(20);
        accountPage.inputFieldPassword(password);
    }

    @Then("User sees Error message incorrect password")
    public void userSeesErrorMessageIncorrectPassword() {
        accountPage = pageFactoryManager.getAccountPage();
        accountPage.isErrorMassageVisible();
    }

    @And("User inputs {int}")
    public void userInputs(int number) {
        productPage = pageFactoryManager.getProductPage();
        productPage.inputFieldNumberProduct(number);
    }

    @Then("User sees Error message incorrect numbers")
    public void userSeesErrorMessageIncorrectNumbers() {
        productPage = pageFactoryManager.getProductPage();
        productPage.isErrorNumberMessage();
    }

    @And("User click on number field")
    public void userClickOnNumberField() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickFieldNumberProduct();
    }
}
