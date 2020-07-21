package org.example.pages;

import org.apache.log4j.Logger;
import org.example.base.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage extends BaseDriver {
    private static final Logger logger = Logger.getLogger(ResultPage.class);
    private WebDriver driver;

    public ResultPage() {
        driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[text()='All']")
    private WebElement elementToVerify;

    public void verifyText(String searchItem) {
        verifyElementPresent(searchItem);
    }

}