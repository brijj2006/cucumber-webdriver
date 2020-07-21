package org.example.pages;

import org.apache.log4j.Logger;
import org.example.base.BaseDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseDriver {

    private static final Logger logger = Logger.getLogger(HomePage.class);
    private WebDriver driver;

    public HomePage() {
        driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@class='tfB0Bf']//input[@value='Google Search']")
    private WebElement searchBtn;

    public void searchItem(String searchItem) {
        searchBox.clear();
        searchBox.sendKeys(searchItem + Keys.TAB);
        clickJSElement(searchBtn);
    }

}