package com.automatestTasksFW;

import engine.Bot;
import org.openqa.selenium.WebDriver;

public abstract class Page {

    protected final WebDriver driver;
    protected Bot bot;

    public Page(WebDriver driver) {
        this.driver = driver;
        this.bot = new Bot(driver);
    }
}
