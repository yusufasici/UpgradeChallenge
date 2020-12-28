package com.upgrade.pages;

import com.upgrade.utulities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoanRequestPage {

    public  LoanRequestPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "desiredAmount")
    public WebElement amount;

    @FindBy(tagName = "select")
    public WebElement purpose;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(name = "borrowerFirstName")
    public WebElement firstName;

    @FindBy(name = "borrowerDateOfBirth")
    public WebElement dob;

    @FindBy(name = "borrowerIncome")
    public WebElement income;

    @FindBy(name = "borrowerAdditionalIncome")
    public WebElement addIncome;

    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//*[contains(text(),'I have read')]")
    public WebElement agreeCheckBox;

    @FindBy(xpath = "//span[@data-auto='userLoanAmount']")
    public WebElement loanAmount;

    @FindBy(xpath = "//span[@data-auto='defaultMonthlyPayment']")
    public WebElement monthlyPay;

    @FindBy(xpath = "//div[@data-auto='defaultLoanTerm']")
    public WebElement term;

    @FindBy(xpath = "//div[@data-auto='defaultLoanInterestRate']")
    public WebElement interest;

    @FindBy(xpath = "//div[@data-auto='defaultMoreInfoAPR']")
    public WebElement APR;

    @FindBy(xpath = "//label[starts-with(@class,'header-nav')]")
    public WebElement menu;

    @FindBy(xpath = "//a[@href='/funnel/logout']")
    public WebElement signOut;
}
