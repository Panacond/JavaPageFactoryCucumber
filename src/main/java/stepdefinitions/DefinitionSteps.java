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

    @And("User clicks ‘news’ button")
    public void goNewsPage() {
        homePage = pageFactoryManager.getHomePage();
        homePage.goNewsPage();
    }

    @Then("User check news list items visibility")
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
        driver.close();
    }

    @And("User makes search by keyword {string}")
    public void userEnterIntoTheSearchBarInput_text(String text) {
        homePage = pageFactoryManager.getHomePage();
        homePage.inputFieldSearch(text);
    }

    @And("User clicks ‘Search’ button")
    public void userPressButtonSearch() {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickButtonSearch();
    }

    @Then("User checks that each item in results list contains keyword {string} visible")
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

    @And("User clicks ‘Xiaomi’ button")
    public void userPressButtonXiaomi() {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickButtonXiaomi();
    }

    @And("User clicks ‘Vacuum cleaners’ button")
    public void userPressButtonVacuumCleaners() {
        xiaomiPage = pageFactoryManager.getXiaomiPage();
        xiaomiPage.pressButtonVacuumCleaners();
    }

    @And("User clicks ‘Price’ button")
    public void userPressButtonPrice() {
        xiaomiVacuumCleanersPage = pageFactoryManager.getXiaomiVacuumCleanersPage();
        xiaomiVacuumCleanersPage.clickButtonPrice();
    }

    @And("User selects a price range 150-350")
    public void userSelectAPriceRange() {
        xiaomiVacuumCleanersPage = pageFactoryManager.getXiaomiVacuumCleanersPage();
        xiaomiVacuumCleanersPage.clickSelectPriceRange150_350();
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

    @And("User clicks 'View’ button")
    public void userPressButtonView() {
        xiaomiVacuumCleanersPage = pageFactoryManager.getXiaomiVacuumCleanersPage();
        xiaomiVacuumCleanersPage.pressButtonView();
    }

    @And("User clicks ‘List view’ button")
    public void userPressTheButtonViewAsAList() {
        xiaomiVacuumCleanersPage = pageFactoryManager.getXiaomiVacuumCleanersPage();
        xiaomiVacuumCleanersPage.clickButtonViewList();
    }

    @Then("User check view change a list of items visibility")
    public void userSeesAListOfItems() {
        xiaomiVacuumCleanersPage = pageFactoryManager.getXiaomiVacuumCleanersPage();
        xiaomiVacuumCleanersPage.isElementViewListVisible();
    }

    @And("User clicks first list item")
    public void userSelectListItem() {
        xiaomiVacuumCleanersPage = pageFactoryManager.getXiaomiVacuumCleanersPage();
        xiaomiVacuumCleanersPage.clickFirstElementList();
    }

    @And("User clicks ‘Add to Watchlist’ button")
    public void userPressButtonAddToWatchlist() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickButtonAddToWatchlist();
    }


    @And("User types {string} in input field")
    public void userInputUserName(String name) {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.waitVisibilityOfElement(20, loginPage.getFieldUserName());
        loginPage.inputFieldUserName(name);
    }

    @Then("User checks that message No exact matches found visible")
    public void userGetANegativeResult() {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.isNoExactMatchesMessageVisible();
    }

    @And("User makes search by keyword {string} and presses ENTER in Vacuum cleaners page")
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

    @And("User inputs text {string} in minimum price field")
    public void userInputPriceInput_price(String text) {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.setMinimumPrice(text);
    }

    @Then("User checks that message ‘Please provide a valid price range’ visible")
    public void userSeesAnException() {
        searchPage = pageFactoryManager.getSearchPage();
        Assert.assertTrue(searchPage.ErrorInputPriceValue());

    }

    @And("User clicks {string} select button")
    public void userSelectCheckButton(String text) {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.setRelatedSearch(text);
    }

    @And("User clicks ‘Continue’ button")
    public void userPressesContinueButton() {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.clickButtonContinue();
    }

    @Then("User checks Error message")
    public void userSeesErrorMessage() {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        loginPage.isErrorMessageVisible();
    }

    @And("User inputs value {int}")
    public void userInputs(int number) {
        productPage = pageFactoryManager.getProductPage();
        productPage.inputFieldNumberProduct(number);
    }

    @Then("User checks message ‘Please enter quantity of 1 or more’ visibility")
    public void userSeesErrorMessageIncorrectNumbers() {
        productPage = pageFactoryManager.getProductPage();
        productPage.isErrorNumberMessage();
    }

    @And("User clicks ‘Quantity’ field")
    public void userClickOnNumberField() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickFieldNumberProduct();
    }
}
