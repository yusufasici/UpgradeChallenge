package com.upgrade.pages;

import com.upgrade.utulities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {


    public  LogInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

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

}
