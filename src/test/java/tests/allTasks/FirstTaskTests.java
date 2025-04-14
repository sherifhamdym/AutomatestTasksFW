package tests.allTasks;

import com.automatestTasksFW.Pages.DuckDuckPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.TestCases;

public class FirstTaskTests extends TestCases {

    /**
     * Test Case 1
     * ●	Open Google Chrome
     * ●	Navigate to [<a href="https://duckduckgo.com/">...</a>]
     * ●	Assert that the page title is [Google]
     * ●	Close Google Chrome
     */

    @Test(description = "Given I open Google Chrome, " +
            "When I navigate to [https://duckduckgo.com/], " +
            "Then I assert that the page title is [Google]")
    public void navigateToDuckDuckThenCheckPageTitle() {
//        String TC1_expectedPageTitle = "Google";
        String URL_duck = "https://duckduckgo.com/";

        // Correct Title
        String TC1_expectedPageTitle = "DuckDuckGo - Protection. Privacy. Peace of mind.";

        String actual = bot.openURL(URL_duck).getTitle();
        Assert.assertEquals(actual, TC1_expectedPageTitle, "TC 1 Title is not as expected");

    }

    /**
     * Test Case 2
     * Open Google Chrome
     * Navigate to [<a href="https://duckduckgo.com/">...</a>]
     * Assert that the DuckDuckGo logo is displayed
     * Close Google Chrome
     */
    @Test(description = "Given I open Google Chrome, " +
            "When I navigate to [https://duckduckgo.com/], " +
            "Then I assert that the DuckDuckGo logo is displayed")
    public void navigateToDuckDuckThenCheckLogoIsDisplayed() {
        DuckDuckPage duckDuckPage = new DuckDuckPage(driver);

//        String URL_duck = "https://duckduckgo.com/";
//        boolean actual = bot.openURL(URL_duck).isDisplayed(TC2_ByLogoElement);

//        bot.openURL(URL_duck);
//        boolean actualResult = duckDuckPage.logoIsDisplayed();

        boolean actual = duckDuckPage.openDuckDuckGoURL().logoIsDisplayed();
        Assert.assertTrue(actual, "TC 2 Logo is not displayed");
    }

    /**
     * Open Google Chrome
     * Navigate to [<a href="https://duckduckgo.com/">...</a>]
     * Search for [Selenium WebDriver]
     * Assert that the link of the first result is [<a href="https://www.selenium.dev/documentation/webdriver/">...</a>]
     * Close Google Chrome
     */
    @Test(description = "Given I am on the DuckDuckGo homepage, " +
            "When I search for 'Selenium WebDriver', " +
            "Then the first result should be 'https://www.selenium.dev/documentation/webdriver/'")
    public void searchForQueryAndCheckFirstResultText() {

        String TC3_searchValue = "Selenium WebDriver";
        String TC3_expectedLink = "https://www.selenium.dev/documentation/webdriver/";


        String actualResult = new DuckDuckPage(driver)
                .openDuckDuckGoURL()
                .searchFor(TC3_searchValue)
                .getFirstResultLink();
        Assert.assertEquals(actualResult, TC3_expectedLink, "TC 3 Link is not as expected");
    }
}
