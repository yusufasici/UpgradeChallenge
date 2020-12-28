package com.upgrade.tests;

import com.upgrade.pages.LoanRequestPage;
import com.upgrade.pages.LogInPage;
import com.upgrade.utulities.Driver;
import com.upgrade.utulities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UITestClass {

    LoanRequestPage loan = new LoanRequestPage();
    LogInPage logIn = new LogInPage();

     @Test
     public void loanRequestTest() {

         // Step 1 to 4 handled with a reusable method.
         // Calling the Loan Request Method.
         ReusableMethods.loanRequest();

         // Step 4 I take only numbers and store them in String from default offer.
         String expectedLoanAmount = loan.loanAmount.getText().replaceAll("[^\\d.]", "");
         String expectedMonthlyPay =loan.monthlyPay.getText().replaceAll("[^\\d.]", "");
         String expectedTerm =loan.term.getText().replaceAll("[^\\d.]", "");
         String expectedInterest =loan.interest.getText().replaceAll("[^\\d.]", "");
         String expectedAPR =loan.APR.getText().replaceAll("[^\\d.]", "");
         ReusableMethods.waitFor(2);

         // Step 4-a
         loan.menu.click();
         loan.signOut.click();

         // Step 5 Login back with valid credentials.
         ReusableMethods.logIn();

         // Step 6
         String expectedOfferPage = "/offer-page";
         String actualPage = Driver.getDriver().getCurrentUrl();
         Assert.assertTrue(actualPage.contains(expectedOfferPage));

         // Step 6-a I am storing the actual data same as like Step 4 to make script more readable.
         String actualLoanAmount = logIn.loanAmount.getText().replaceAll("[^\\d.]", "");
         String actualMonthlyPay =logIn.monthlyPay.getText().replaceAll("[^\\d.]", "");
         String actualTerm =logIn.term.getText().replaceAll("[^\\d.]", "");
         String actualInterest =logIn.interest.getText().replaceAll("[^\\d.]", "");
         String actualAPR =logIn.APR.getText().replaceAll("[^\\d.]", "");

         // Step 6-a All assertions according to Requirement Document.
         SoftAssert soft = new SoftAssert();
         soft.assertEquals(actualLoanAmount,expectedLoanAmount, "Loan amount is wrong");
         soft.assertEquals(actualMonthlyPay, expectedMonthlyPay, "Monthly pay is wrong");
         soft.assertEquals(actualTerm, expectedTerm, "Term is wrong");
         soft.assertEquals(actualInterest, expectedInterest, "Interest is wrong");
         soft.assertEquals(actualAPR, expectedAPR, "APR is wrong");
         soft.assertAll();

         // Closing the driver.
         Driver.closeDriver();
     }
}
