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
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 2000;

    WebDriver driver;
    HomePage homePage;
    NewsPage newsPage;
    SearchPage searchPage;
    XiaomiPage xiaomiPage;
    XiaomiVacuumCleanersPage xiaomiVacuumCleanersPage;
    ProductPage productPage;
    SignPage signPage;

    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User go to {string}")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User go to news page")
    public void goNewsPage() {
        homePage = pageFactoryManager.getHomePage();
        homePage.goNewsPage();

    }

    @Then("User see news list {int} items")
    public void userSeeNewsListItems(int number) throws InterruptedException {
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


    @And("User enter into the search bar {string}")
    public void userEnterIntoTheSearchBarInput_text(String text) {
        homePage = pageFactoryManager.getHomePage();
        homePage.inputFieldSearch(text);

    }

    @And("User press button search")
    public void userPressButtonSearch() {
        homePage = pageFactoryManager.getHomePage();
        homePage.pressButtonSearch();
    }

    @Then("User sees at least one item in the list containing {string}")
    public void userSeesAtLeastOneItemInTheListContainingResult_search(String text) {
        searchPage = pageFactoryManager.getSearchPage();
        List<WebElement>listTitle = searchPage.getResultTitleSearch();
        boolean excepted = false;
        for (WebElement element: listTitle ) {
            if (element.getText().contains(text))
                excepted = true;
                break;
        }
        Assert.assertTrue(excepted);
    }

    @And("User press button Xiaomi")
    public void userPressButtonXiaomi() {
        homePage = pageFactoryManager.getHomePage();
        homePage.pressButtonXiaomi();
    }

    @And("User press button vacuum cleaners")
    public void userPressButtonVacuumCleaners() {
        xiaomiPage = pageFactoryManager.getXiaomiPage();
        xiaomiPage.pressButtonVacuumCleaners();
    }

    @And("User press button price")
    public void userPressButtonPrice() {
        xiaomiVacuumCleanersPage = pageFactoryManager.getXiaomiVacuumCleanersPage();
        xiaomiVacuumCleanersPage.pressButtonPrice();
    }

    @And("User select a price range one hundred fifty to three hundred fifty")
    public void userSelectAPriceRange() {
        xiaomiVacuumCleanersPage = pageFactoryManager.getXiaomiVacuumCleanersPage();
        xiaomiVacuumCleanersPage.pressSelectPriceRange150_350();
    }

    @Then("User check prices are in the range one hundred fifty to three hundred fifty")
    public void userCheckPricesAreInTheRangeOneHundredFiftyToThreeHundredFifty() {
        xiaomiVacuumCleanersPage = pageFactoryManager.getXiaomiVacuumCleanersPage();
        List<WebElement>listPrice = xiaomiVacuumCleanersPage.getCheckPrise();
        boolean excepted = true;
        for (WebElement element: listPrice ) {
            String correctedText = element.getText().replace("$","");
            correctedText = correctedText.split(" to ")[0];
            double priceValue = Double.parseDouble(correctedText);
            if (priceValue < 150) excepted = false;
            else if (priceValue > 350) excepted = false;
        }
        Assert.assertTrue(excepted);
    }

    @And("User press button view")
    public void userPressButtonView() {
        xiaomiVacuumCleanersPage = pageFactoryManager.getXiaomiVacuumCleanersPage();
        xiaomiVacuumCleanersPage.pressButtonView();
    }

    @And("User press the button view as a list")
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

    @And("User press button Add to Watchlist")
    public void userPressButtonAddToWatchlist() {
        productPage = pageFactoryManager.getProductPage();
        productPage.pressButtonAddToWatchlist();
    }


    @Then("User view UserName")
    public void userViewUserName() {
        signPage = pageFactoryManager.getSignPage();
        signPage.isFieldUserNameVisible();
    }

    @Then("User get a negative result")
    public void userGetANegativeResult() {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.isNegativeResultVisible();
    }

    @And("User enter vacuum cleaners in the search bar {string} and press ENTER")
    public void userEnterVacuumCleanersInTheSearchBarInput_textAndPressENTER(String text) {
        xiaomiVacuumCleanersPage = pageFactoryManager.getXiaomiVacuumCleanersPage();
        xiaomiVacuumCleanersPage.inputSearchField(text);
    }

    @Then("check list items contain {string}")
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

    @And("User input price {string}")
    public void userInputPriceInput_price(String text) {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.inputFieldPrice(text);
    }

    @Then("User sees an exception")
    public void userSeesAnException() {
        searchPage = pageFactoryManager.getSearchPage();
        Assert.assertTrue(searchPage.ErrorInputPriceValue());

    }

    @And("User select check button Tomato")
    public void userSelectCheckButtonTomato() {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.setCommonName();
    }
}
