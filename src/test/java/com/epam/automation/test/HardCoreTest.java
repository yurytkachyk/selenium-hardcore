package com.epam.automation.test;

import com.epam.automation.page.GoogleCloudPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HardCoreTest {

    public static final String SEARCH_REQUEST = "Google Cloud Platform Pricing Calculator";
    public static final String NUMBER_OF_INSTANCES = "4";

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testTotalEstimatedMonthlyCost_shouldBeEqualFromMessageAndCalculator() {
        final boolean flag = new GoogleCloudPage(driver)
                .openPage()
                .enterRequest(SEARCH_REQUEST)
                .sendRequest()
                .clickOnResult()
                .fillForm(NUMBER_OF_INSTANCES)
                .addToEstimate()
                .estimateEmail()
                .openPage()
                .createRandomEmail()
                .copyAndPasteNewGeneratedEmail()
                .sendEmail()
                .checkInbox()
                .isTotalEstimatedCostFromMessageAndComputeEngineEquals();

        assertTrue(flag);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}