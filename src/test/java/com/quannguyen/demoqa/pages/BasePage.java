package com.quannguyen.demoqa.pages;

import com.quannguyen.demoqa.utils.PropertiesFileUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;


public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;


    public BasePage(WebDriver driver) throws IOException {
        Properties properties = PropertiesFileUtil.readProperties(System.getProperty("env.properties"));
        PropertiesFileUtil.writeProperties(properties);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(System.getProperty("TIMEOUT_IN_SECOND"))));
    }

    public Select selectElement(By locator) {
        WebElement selectElement = waitForElementToBeClickable(locator);
        Select selectObject = new Select(selectElement);
        return selectObject;
    }

    public void inputText(By locator, String text) {
        WebElement element = waitForElementToBeClickable(locator);
        element.sendKeys(text);
    }

    public void sendKeysFromKeyBoard(By locator, Keys key ) {
        WebElement element = waitForElementToBeClickable(locator);
        element.sendKeys(key);
    }

    public void clickElement(By locator) {
        WebElement element = waitForElementToBeClickable(locator);
        element.click();
    }

    public String getTextAttribute(By locator, String attribute) {
        WebElement element = waitForElementToBeVisible(locator);
        return element.getAttribute(attribute);
    }

    public String getText(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        return element.getText();
    }

    public void moveToElement(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.perform();
    }

    public boolean isDisplayed(By locator) {
        WebElement element = waitForElementToBeClickable(locator);
        return element.isDisplayed();
    }

    public void waitForAlertToBePresent() {
        Alert element = wait.until(ExpectedConditions.alertIsPresent());
    }

    public List<WebElement> waitForListOfElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    /* Convert locator */
    public static By convertLocator(String type, String locator, String replaceText) {
        switch (type) {
            case "id":
                return By.id(String.format(locator, replaceText));
            case "name":
                return By.name(String.format(locator, replaceText));
            case "className":
                return By.className(String.format(locator, replaceText));
            case "tagName":
                return By.tagName(String.format(locator, replaceText));
            case "linkText":
                return By.linkText(String.format(locator, replaceText));
            case "partialLinkText":
                return By.partialLinkText(String.format(locator, replaceText));
            case "cssSelector":
                return By.cssSelector(String.format(locator, replaceText));
            default:
                return By.xpath(String.format(locator, replaceText));
        }

    }
}
