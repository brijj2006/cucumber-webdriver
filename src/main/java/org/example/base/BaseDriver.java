package org.example.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.Set;

public class BaseDriver {

    private static final Logger logger = Logger.getLogger(BaseDriver.class);

    private DriverManager driverManager;
    private WebDriver driver;
    public String dataResourceLocation = "./src/test/resources/data/";

    public BaseDriver() {
        driverManager = BeanUtil.getBean(DriverManager.class);
        driver = driverManager.getDriverInstance();
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void moveToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public boolean verifyTextPresent(String text) {
        try {
            if (driver.findElements(By.xpath("//span[text()='" + text + "']")).size() > 0) {
                logger.info("Text present on the page : " + text);
                return true;
            } else {
                logger.error("Text not present on the page : " + text);
                return false;
            }
        } catch (Exception e) {
            logger.error("Text not present on the page : " + text);
            e.printStackTrace();
            return false;
        }
    }

    public boolean verifyHeaderPresent(String headerText) {
        try {
            if (driver.findElements(By.xpath("//h2[text()='" + headerText + "']")).size() > 0) {
                logger.info("Header present on the page : " + headerText);
                return true;
            } else {
                logger.error("Header not present on the page : " + headerText);
                return false;
            }
        } catch (Exception e) {
            logger.error("Header not present on the page : " + headerText);
            e.printStackTrace();
            return false;
        }
    }

    public boolean verifyParentHeaderPresent(String headerText) {
        try {
            if (driver.findElements(By.xpath("//h1[text()='" + headerText + "']")).size() > 0) {
                logger.info("Header present on the page : " + headerText);
                return true;
            } else {
                logger.error("Header not present on the page : " + headerText);
                return false;
            }
        } catch (Exception e) {
            logger.error("Header not present on the page : " + headerText);
            e.printStackTrace();
            return false;
        }
    }

    public boolean verifyElementPresent(String elementText) {
        try {
            if (driver.findElements(By.xpath("//div[text()='" + elementText + "']")).size() > 0) {
                logger.info("element is present on the page : " + elementText);
                return true;
            } else {
                logger.info("element is not present on the page : " + elementText);
                return false;
            }
        } catch (Exception e) {
            logger.info("element is not present on the page : " + elementText);
            e.printStackTrace();
            return false;
        }
    }

    public boolean verifyElementPresent(WebElement element) {
        try {
            if (element.isDisplayed()) {
                logger.info("element is present on the page");
                return true;
            } else {
                logger.info("element is not present on the page");
                return false;
            }
        } catch (Exception e) {
            logger.info("element is not present on the page");
            e.printStackTrace();
            return false;
        }
    }

    public void selectRadioOption(String label, String option) {
        try {
            WebElement element = driver.findElement(By.xpath("//label[contains(text(),'" + label + "')]/../../..//span[text()='" + option + "']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
            logger.info("Radio button selected as : " + option + " for label : " + label);
        } catch (Exception e) {
            logger.error("Radio button not selected as : " + option + " for label : " + label);
            e.printStackTrace();
        }

    }

    public void clickButton(String btnText) {
        try {
            WebElement element = driver.findElement(By.xpath("//button[text()='" + btnText + "']"));
            moveToElement(element);
            element.click();
            logger.info("clicked on button : " + btnText);
            Thread.sleep(3000);
        } catch (Exception e) {
            logger.error("failed to click on button : " + btnText);
            e.printStackTrace();
        }
    }

    public void clickLinkText(String linkText) {
        try {
            WebElement element = driver.findElement(By.linkText(linkText));
            moveToElement(element);
            element.click();
            logger.info("clicked on link : " + linkText);
            Thread.sleep(3000);
        } catch (Exception e) {
            logger.error("failed to click on link : " + linkText);
            e.printStackTrace();
        }
    }

    public void clickElement(String elementText) {
        try {
            WebElement element = driver.findElement(By.xpath("//div[text()='" + elementText + "']"));
            moveToElement(element);
            element.click();
            logger.info("clicked on element : " + elementText);
            Thread.sleep(3000);
        } catch (Exception e) {
            logger.error("failed to click on element : " + elementText);
            e.printStackTrace();
        }
    }

    public void clickMenuItem(String menuItem) {
        try {
            WebElement element = driver.findElement(By.xpath("//span[text()='" + menuItem + "']"));
            moveToElement(element);
            element.click();
            logger.info("clicked on menu : " + menuItem);
            Thread.sleep(3000);
        } catch (Exception e) {
            logger.error("failed to click on menu : " + menuItem);
            e.printStackTrace();
        }
    }

    public void clickJSElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void verifyNewWindow(String linkText, String headerName) {
        try {
            String parentWindow = driver.getWindowHandle();
            clickLinkText(linkText);
            Set<String> windowHandles = driver.getWindowHandles();
            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(parentWindow)) {
                    driver.switchTo().window(windowHandle);
                    logger.info("switched to new window : " + windowHandle);
                    break;
                } else {
                    continue;
                }
            }
            verifyParentHeaderPresent(headerName);
            driver.close();
            driver.switchTo().window(parentWindow);
            logger.info("switched back to the parent window : " + parentWindow);
        } catch (Exception e) {
            logger.error("failed to switch to the new window");
            e.printStackTrace();
        }
    }

    public void refreshPage() {
        try {
            driver.navigate().refresh();
            Thread.sleep(7000);
            logger.info("page refreshed successfully");
        } catch (InterruptedException e) {
            logger.error("page failed to refresh");
            e.printStackTrace();
        }
    }

    public String getText(WebElement element) {
        String textValue = null;
        try {
            textValue = element.getText().trim();
            logger.info("fetched text value : " + textValue);
        } catch (Exception e) {
            logger.error("failed to fetch text value");
            e.printStackTrace();
        }
        return textValue;
    }

    public String getWrappedText(WebElement element) {
        String textValue = null;
        try {
            textValue = element.getText().trim();
            textValue = textValue.replaceAll("[\\t\\n\\r]", "");
            logger.info("fetched text value : " + textValue);
        } catch (Exception e) {
            logger.error("failed to fetch text value");
            e.printStackTrace();
        }
        return textValue;
    }

    public String getAttributeValue(WebElement element, String attribute) {
        String attributeValue = null;
        try {
            attributeValue = element.getAttribute(attribute).trim();
            logger.info("attribute value for " + attribute + " : " + attributeValue);
        } catch (Exception e) {
            logger.error("failed to fetch attribute value for : " + attribute);
            e.printStackTrace();
        }
        return attributeValue;
    }

    public void selectValuesFromDropDown(WebElement element, String selectValue) {
        try {
            Actions actions = new Actions(driver);
            actions.sendKeys(element, selectValue).sendKeys(Keys.TAB).build().perform();
            logger.info("selected value from the dropdown : " + selectValue);
        } catch (Exception e) {
            logger.error("failed to select value from the dropdown : " + selectValue);
            e.printStackTrace();
        }
    }

    public void uploadFile(WebElement element, String fileName) {
        try {
            File file = new File(dataResourceLocation + fileName);
            element.sendKeys(file.getAbsolutePath());
            logger.info("file successfully uploaded : " + fileName);
        } catch (Exception e) {
            logger.info("file failed to upload : " + fileName);
            e.printStackTrace();
        }
    }

}