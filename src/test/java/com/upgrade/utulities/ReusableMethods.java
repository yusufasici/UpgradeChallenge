package com.upgrade.utulities;

import com.github.javafaker.Faker;
import com.upgrade.pages.LoanRequestPage;
import com.upgrade.pages.LogInPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class ReusableMethods {

    static LoanRequestPage loan = new LoanRequestPage();
    static Faker faker = new Faker();
    static LogInPage logIn = new LogInPage();

    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void loanRequest() {
        //For test data I am using Configuration file and Java Faker class.
        // Step 1
        Driver.getDriver().get(ConfigReader.getProperty("loanUrl"));

        // Step 2-a
        loan.amount.sendKeys(ConfigReader.getProperty("amount"));
        Select purpose = new Select(loan.purpose);
        purpose.selectByValue(ConfigReader.getProperty("purposeType"));

        //Step 2-b
        loan.submitButton.click();

        //Step 3 I used JAVA Faker class to send random credentials. I also use a Fake valid US address.
        loan.firstName.sendKeys(faker.name().firstName() + Keys.TAB +
                faker.name().lastName() + Keys.TAB +
                ConfigReader.getProperty("address") + Keys.TAB +
                ConfigReader.getProperty("city") + Keys.TAB +
                ConfigReader.getProperty("state") + Keys.TAB +
                ConfigReader.getProperty("zipCode"));
        loan.dob.sendKeys(ConfigReader.getProperty("dob"));
        loan.submitButton.click();
        loan.income.sendKeys(ConfigReader.getProperty("income"));
        loan.addIncome.sendKeys(ConfigReader.getProperty("additionalIncome") + Keys.TAB);
        loan.submitButton.click();
        loan.username.sendKeys(ConfigReader.getProperty("email"));
        loan.password.sendKeys(ConfigReader.getProperty("password"));
        loan.agreeCheckBox.click();
        loan.submitButton.click();
    }

    public static void logIn() {

        //Step 5 Login back with valid credentials.
        Driver.getDriver().get(ConfigReader.getProperty("logInUrl"));
        logIn.username.sendKeys(ConfigReader.getProperty("email"));
        logIn.password.sendKeys(ConfigReader.getProperty("password"));
        logIn.submitButton.click();
        waitFor(5);
    }
}
