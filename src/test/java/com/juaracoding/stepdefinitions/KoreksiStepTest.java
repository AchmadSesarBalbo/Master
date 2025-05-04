package com.juaracoding.stepdefinitions;

import com.juaracoding.DriverSingleton;
import com.juaracoding.pages.KoreksiPage;
import com.juaracoding.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
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

    @And("Admin inputs {string} in the search field")
    public void adminInputsInTheSearchField(String name) throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.searchAction(name);
    }

    @And("Admin clicks the Search button")
    public void adminClicksTheSearchButton() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonSearch();
    }

    @Then("The correction data related to the employee name is displayed")
    public void theCorrectionDataRelatedToTheEmployeeNameIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.getDataEmployee();
    }

    @When("Admin clicks the Reset button")
    public void adminClicksTheResetButton() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonReset();
    }

    @And("Admin selects start date {string} and end date {string}")
    public void adminSelectsStartDateAndEndDate(String startDate, String endDate) throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonStartDate();
        Thread.sleep(2000);
        koreksiPage.earlyDateInput(startDate);
        Thread.sleep(2000);
        koreksiPage.continueDateInput(endDate);
        Thread.sleep(2000);
        koreksiPage.buttonSaveDate();
    }

    @Then("The correction data within the selected date range is displayed")
    public void theCorrectionDataWithinTheSelectedDateRangeIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.getDataEmployee();
    }

    @Then("The correction data filtered by name and date is displayed")
    public void theCorrectionDataFilteredByNameAndDateIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.getDataEmployee();
    }

    @And("Admin clicks the Filter button")
    public void adminClicksTheFilterButton() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonFilter();
    }

    @And("Admin inputs unit name {string}")
    public void adminInputsUnitName(String unitName) throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.searchFilterActionValid(unitName);
    }

    @And("Admin clicks the Apply button")
    public void adminClicksTheApplyButton() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonTerapkanFilter();
    }

    @Then("The correction data related to the unit name is displayed")
    public void theCorrectionDataRelatedToTheUnitNameIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.getDataEmployee();
    }

    @When("Admin clicks the Approve button for the first correction")
    public void adminClicksTheApproveButtonForTheFirstCorrection() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.goToNextPage();
        Thread.sleep(2000);
        koreksiPage.buttonApprove();
    }

    @And("Admin clicks the Confirm button")
    public void adminClicksTheConfirmButton() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonConfirm();
    }

    @Then("A success popup should appear")
    public void aSuccessPopupShouldAppear() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.popUpUpdate();
    }

    @When("Admin clicks the Reject button for the first correction")
    public void adminClicksTheRejectButtonForTheFirstCorrection() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.goToNextPage();
        Thread.sleep(2000);
        koreksiPage.buttonReject();
    }

    @And("Admin inputs rejection reason {string}")
    public void adminInputsRejectionReason(String reason) throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.rejectReason(reason);
    }

    @And("Admin clicks the Submit rejection button")
    public void adminClicksTheSubmitRejectionButton() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonConfirm();
    }

    //Negative
    @Then("No correction data should be displayed")
    public void noCorrectionDataShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.getDataEmployee();
    }

    @And("Admin inputs invalid unit name {string}")
    public void adminInputsInvalidUnitName(String unitName) throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.searchFilterActionInvalid(unitName);
    }

    @And("Admin clicks the Submit rejection button without reason")
    public void adminClicksTheSubmitRejectionButtonWithoutReason() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.buttonConfirm();
    }

    @Then("A validation error should appear indicating reason is required")
    public void aValidationErrorShouldAppearIndicatingReasonIsRequired() throws InterruptedException {
        Thread.sleep(2000);
        koreksiPage.getValidateMessage();
        Thread.sleep(2000);
    }
}