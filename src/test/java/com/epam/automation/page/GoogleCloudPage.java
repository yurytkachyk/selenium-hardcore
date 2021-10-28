package com.epam.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.Keys.ENTER;

public class GoogleCloudPage {

    public static final String GOOGLE_CLOUD_URL = "https://cloud.google.com/";

    private final WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchInput;

    @FindBy(xpath = "(//b[text()='Google Cloud Platform Pricing Calculator'])[1]")
    private WebElement searchResultLink;

    @FindBy(css = "#input_74")
    private WebElement numberOfInstances;

    @FindBy(css = "#select_value_label_69")
    private WebElement series;

    @FindBy(css = "#select_option_214")
    private WebElement neededSeries;

    @FindBy(css = "#select_value_label_70")
    private WebElement machineType;

    @FindBy(css = "#select_option_473")
    private WebElement neededMachineType;

    @FindBy(css = ".ng-valid.ng-touched.ng-dirty.ng-valid-parse.ng-empty")
    private WebElement gpuCheckbox;

    @FindBy(css = "#select_value_label_505")
    private WebElement numberOfGpus;

    @FindBy(css = "#select_option_542")
    private WebElement neededNumberOfGpus;

    @FindBy(css = "#select_value_label_506")
    private WebElement gpuType;

    @FindBy(css = "#select_option_549")
    private WebElement neededGpuType;

    @FindBy(css = "#select_value_label_411")
    private WebElement localSsd;

    @FindBy(css = "select_option_494")
    private WebElement neededLocalSsd;

    @FindBy(css = "#select_value_label_73")
    private WebElement committedUsage;

    @FindBy(css = "#select_option_112")
    private WebElement neededCommittedUsage;

    @FindBy(xpath = "(//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'])[1]")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "(//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'])[5]")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "(//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'])[7]")
    private WebElement sendEmailButton;

    public GoogleCloudPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPage openPage() {
        driver.get(GOOGLE_CLOUD_URL);
        return this;
    }

    public GoogleCloudPage enterRequest(String request) {
        searchInput.click();
        searchInput.sendKeys(request);
        return this;
    }

    public GoogleCloudPage sendRequest() {
        searchInput.sendKeys(ENTER);
        return this;
    }

    public GoogleCloudPage clickOnResult() {
        searchInput.click();
        return this;
    }

    public GoogleCloudPage fillForm(String number) {
        numberOfInstances.sendKeys(number);
        series.click();
        neededSeries.click();
        machineType.click();
        neededMachineType.click();
        gpuCheckbox.click();
        numberOfGpus.click();
        neededNumberOfGpus.click();
        gpuType.click();
        neededGpuType.click();
        committedUsage.click();
        neededCommittedUsage.click();

        return this;
    }

    public GoogleCloudPage addToEstimate() {
        addToEstimateButton.click();
        return this;
    }

    public YopMailPage estimateEmail() {
        emailEstimateButton.click();
        return new YopMailPage(driver);
    }

    public YopMailPage sendEmail() {
        sendEmailButton.click();
        return new YopMailPage(driver);
    }

}