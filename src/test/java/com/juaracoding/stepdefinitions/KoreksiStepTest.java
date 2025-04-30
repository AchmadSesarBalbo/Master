package com.juaracoding.stepdefinitions;

import com.juaracoding.DriverSingleton;
import com.juaracoding.pages.KoreksiPage;
import com.juaracoding.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class KoreksiStepTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private KoreksiPage koreksiPage;

    public KoreksiStepTest() {
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
        koreksiPage = new KoreksiPage(driver);

        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("Admin is logged in and on the dashboard for Laporan Koreksi")
    public void adminIsOnTheDashboardForStrukturUser() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.getDashboardLabel();
    }

    @When("Admin navigates to Correction Report")
    public void adminNavigatesToCorrectionReport() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.openLaporanMenu();
        Thread.sleep(2000);
        koreksiPage.openKoreksiTab();
        String actual = koreksiPage.getKoreksiLabel();
        String expected = "Koreksi";
        Assert.assertEquals(actual,expected);
    }

    @And("Admin enters {string} in the search bar")
    public void adminEntersInTheSearchBar(String searchTerm) throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.searchAction(searchTerm);
    }

    @And("Admin inputs start date {string} and end date {string}")
    public void adminInputsStartDateAndEndDate(String date0, String date1) throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonStartDate();
        Thread.sleep(2000);
        koreksiPage.earlyDateInput(date0);
        Thread.sleep(2000);
        koreksiPage.continueDateInput(date1);
        Thread.sleep(5000);
        koreksiPage.buttonSaveDate();
    }

    @And("Admin clicks Search")
    public void adminClicksSearch() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonSearch();
    }

    @Then("Employee information should be displayed")
    public void employeeInformationShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.getDataEmployee();
        Thread.sleep(20000);
    }

    @When("Admin clicks Reset button")
    public void adminClicksResetButton() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonReset();
    }

    @Then("The page should reset to initial empty state")
    public void thePageShouldResetToInitialEmptyState() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.getKoreksiLabel();
    }

    @When("Admin click start date {string} and end date {string}")
    public void adminClickStartDateAndEndDate(String date0, String date1) throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.startDate(date0);
        Thread.sleep(2000);
        koreksiPage.endDate(date1);
    }

//    @When("Admin clicks the approve button on a correction request")
//    public void adminClicksTheApproveButtonOnACorrectionRequest() throws InterruptedException {
//        Thread.sleep(2000);
//        koreksiPage.buttonApprove();
//    }
//
//    @And("Admin confirms the approval")
//    public void adminConfirmsTheApproval() throws InterruptedException {
//        Thread.sleep(2000);
//        koreksiPage.buttonApprove();
//    }
//
//    @Then("The correction request status should be updated")
//    public void theCorrectionRequestStatusShouldBeUpdatedTo() throws InterruptedException {
//        Thread.sleep(2000);
//        koreksiPage.getStatusLabel();
//    }
}
