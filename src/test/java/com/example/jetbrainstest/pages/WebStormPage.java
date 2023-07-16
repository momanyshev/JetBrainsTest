package com.example.jetbrainstest.pages;


import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//page url = https://www.jetbrains.com/webstorm/
public class WebStormPage {
    public final Logger LOG = LoggerFactory.getLogger(WebStormPage.class);
    WebDriver driver;
    @FindBy(css = "a[data-test='button' ][href ='/webstorm/download/download-thanks.html']")
    private WebElement downloadButton;


    public Boolean checkIfDownloadButtonIsClickable(){
        LOG.info("Проверка активности кнопки загрузки");
        return downloadButton.isEnabled();
    }
    public WebStormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@href='/webstorm/whatsnew/']")
    public WebElement whatsNewButton;
    @Step("Переход на страницу Whats New")
    public void whatsNewButtonClick(){
        whatsNewButton.click();
        LOG.info("Переход на страницу Whats New");
    }
    @FindBy(xpath = "//a[@href='/webstorm/buy/']")
    public WebElement prisingButton;

}
