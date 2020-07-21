package org.example.glue;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.example.base.BaseDriver;
import org.example.base.DriverManager;
import org.example.pages.HomePage;
import org.example.pages.ResultPage;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ContextConfiguration("classpath:Cucumber.xml")
@PropertySource("classpath:config/config.properties")
public class UIGlue {

    private static final Logger logger = Logger.getLogger(UIGlue.class);

    @Value("${app.base.url}")
    private String appBaseUrl;

    @Autowired
    private DriverManager driverManager;
    private WebDriver driver;
    private BaseDriver baseDriver;
    private HomePage homePage;
    private ResultPage resultPage;

    @Before({"@page_setup"})
    public void setup() {
        driver = driverManager.getDriverInstance();
        baseDriver = new BaseDriver();
        homePage = new HomePage();
        resultPage = new ResultPage();
    }

    @Before({"@Page-workflow"})
    public void secondSetup() {
        baseDriver = new BaseDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Given("^open application$")
    public void openApplication() {
        driver.get(appBaseUrl);
    }

    @When("^search for item \"([^\"]*)\"$")
    public void searchForItem(String item) throws Throwable {
        homePage.searchItem(item);
    }

    @Then("^verify element \"([^\"]*)\" is present on the page$")
    public void verifyElementIsPresentOnThePage(String elementText) throws Throwable {
        resultPage.verifyText(elementText);
    }

    @Then("^verify \"([^\"]*)\" is present on the page$")
    public void verify_is_present_on_the_page(String text) throws Throwable {
        baseDriver.verifyTextPresent(text);
    }

    @When("^click button \"([^\"]*)\"$")
    public void click_button(String btnName) throws Throwable {
        baseDriver.clickButton(btnName);
    }

    @Then("^verify menu items present on the screen$")
    public void verify_menu_items_present_on_the_screen(DataTable dataTable) throws Throwable {
        List<String> menuItems = dataTable.asList(String.class);
        for (String menu : menuItems) {
            baseDriver.verifyTextPresent(menu);
        }
    }

    @Given("^user is present on the page \"([^\"]*)\"$")
    public void user_is_present_on_the_page(String headerName) throws Throwable {
        baseDriver.verifyHeaderPresent(headerName);
    }

    @When("^click on the link \"([^\"]*)\"$")
    public void click_on_the_link(String linkText) throws Throwable {
        baseDriver.clickLinkText(linkText);
    }

    @Then("^verify upon clicking \"([^\"]*)\" new window opens with header \"([^\"]*)\"$")
    public void verifyUponClickingNewWindowOpensWithHeader(String linkText, String headerName) throws Throwable {
        baseDriver.verifyNewWindow(linkText, headerName);
    }

    @When("^refresh page$")
    public void refresh_page() throws Throwable {
        baseDriver.refreshPage();
    }

    @When("^click element \"([^\"]*)\"$")
    public void clickElement(String elementText) throws Throwable {
        baseDriver.clickElement(elementText);
    }

    @Then("^verify warning present \"([^\"]*)\"$")
    public void verifyWarningPresent(String warningText) throws Throwable {
        baseDriver.verifyParentHeaderPresent(warningText);
    }

    @When("^click on menu \"([^\"]*)\"$")
    public void clickOnMenu(String menuitem) throws Throwable {
        baseDriver.clickMenuItem(menuitem);
    }

}