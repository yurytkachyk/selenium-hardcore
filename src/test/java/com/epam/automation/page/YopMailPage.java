package com.epam.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YopMailPage {

    public static final String YOPMAIL_URL = "https://yopmail.com/en/";

    private final WebDriver driver;
    private String googleCloudWindow;
    private String yopMailWindow;

    @FindBy(xpath = "//*[@id='listeliens']/a[1]")
    private WebElement emailGenerator;

    @FindBy(css = "#egen")
    private WebElement newGeneratedEmail;

    @FindBy(css = "#input_620")
    private WebElement receivedEmail;

    @FindBy(xpath = "(//button[@class='md but text f24 egenbut'])[3]")
    private WebElement checkInboxButton;

    @FindBy(xpath = "//*[@id='mail']/div/div/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/h3")
    private WebElement totalEstimatedCostFormMessage;

    @FindBy(xpath = "//*[@id='resultBlock']/md-card/md-card-content/div/div/div/h2/b")
    private WebElement totalEstimatedCostFromComputeEngine;

    public YopMailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public YopMailPage openPage() {
        googleCloudWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(YOPMAIL_URL);
        yopMailWindow = driver.getWindowHandle();

        return this;
    }

    public YopMailPage createRandomEmail() {
        emailGenerator.click();
        return this;
    }

    public GoogleCloudPage copyAndPasteNewGeneratedEmail() {
        final String email = newGeneratedEmail.getText();

        driver.switchTo().window(googleCloudWindow);
        receivedEmail.sendKeys(email);

        return new GoogleCloudPage(driver);
    }

    public YopMailPage checkInbox() {
        driver.switchTo().window(yopMailWindow);
        checkInboxButton.click();
        return this;
    }

    public boolean getTotalEstimatedCostFromMessage() {
        final String totalFromMessage = totalEstimatedCostFormMessage.getText();
        driver.switchTo().window(googleCloudWindow);
        final String totalFromComputeEngine = totalEstimatedCostFromComputeEngine.getText();

        return totalFromComputeEngine.contains(totalFromMessage);
    }

}