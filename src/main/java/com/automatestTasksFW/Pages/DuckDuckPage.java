package com.automatestTasksFW.Pages;

import com.automatestTasksFW.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DuckDuckPage extends Page {
    public DuckDuckPage(WebDriver driver) {
        super(driver);
    }

    private static final By TC2_ByLogoElement = By.xpath("(//*[@title='Learn about DuckDuckGo'])[2]/img");
    private static final By searchbox = By.id("searchbox_input");

    public boolean logoIsDisplayed() {
        return bot.isDisplayed(TC2_ByLogoElement);
    }

    public DuckDuckPage openDuckDuckGoURL() {
        bot.openURL("https://www.duckduckgo.com");
        return this;
    }

    public DuckDuckResultPage searchFor(String searchTerm) {
        bot.type(searchbox, searchTerm + Keys.ENTER);
        return new DuckDuckResultPage(driver);
    }
}
