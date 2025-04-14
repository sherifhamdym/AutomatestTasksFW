package com.automatestTasksFW.Pages;

import com.automatestTasksFW.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DuckDuckResultPage extends Page {
    public DuckDuckResultPage(WebDriver driver) {
        super(driver);
    }

    private static final By firstResultLink = By.xpath("(//a[@data-testid='result-extras-url-link'])[1]");


    public String getFirstResultLink() {

        return bot.getDomAttribute(firstResultLink, "href");
    }
}
