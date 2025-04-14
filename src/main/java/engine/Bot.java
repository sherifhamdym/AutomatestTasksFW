package engine;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class Bot {
    private final Wait<WebDriver> wait;

    public Bot(WebDriver driver) {
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NotFoundException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class);
    }

    public Bot type(By by, CharSequence text) {
        wait.until(d -> {
            d.findElement(by).clear();
            d.findElement(by).sendKeys(text);
            System.out.println("Typed " + text + " into " + by);
            return true;
        });
        return this;
    }

    public Bot click(By by) {
        wait.until(d -> {
            d.findElement(by).click();
            System.out.println("Clicked " + by);
            return true;
        });
        return this;
    }

    public boolean isDisplayed(By by) {
        try {
            return wait.until(d -> d.findElement(by).isDisplayed());
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getTitle() {
        return wait.until(d -> {
            String title = d.getTitle();
            System.out.println("Title is " + title); // Optional: keep logging if needed
            return title; // Return the actual title instead of just true
        });
    }

    public Bot openURL(String url) {
        wait.until(d -> {
            d.navigate().to(url);
            System.out.println("Opened URL " + url);
            return true;
        });
        return this;
    }

    public Bot getText(By locator) {
        wait.until(d -> {
            String text = d.findElement(locator).getText();
            System.out.println("Actual Text is " + text);
            return true;
        });
        return this;
    }


    public String getDomAttribute(By by, String attributeValue) {
        return wait.until(d ->{
            String attribute = d.findElement(by).getDomAttribute(attributeValue);
            System.out.println("Actual Attribute is "+attribute);
            return attribute;
        });
    }
    public Bot uploadDocument(String filePath, By fileInputElement, By fileSubmitElement, By uploadedFile) {
        wait.until(d -> {
            d.findElement(fileInputElement).sendKeys(filePath);
            d.findElement(fileSubmitElement).click();
            WebElement successMessage = d.findElement(uploadedFile);
            System.out.println("Uploaded document with message: " + successMessage.getText());
            return true;
        });
        return this;
    }
    public String selectfromdropdownlist(By element, int listResultNumber) {

       return  wait.until(d -> {
           wait.until(x -> x.findElement(element));
           List<WebElement> options = d.findElements(element);
        String OptionNumberValue = options.get(listResultNumber).getText();
        System.out.println("Selected option is : " + OptionNumberValue);
        return OptionNumberValue;
        });
    }

}
