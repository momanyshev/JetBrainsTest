package com.example.jetbrainstest.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhpStormPage {

    private final Logger LOG = LoggerFactory.getLogger(PhpStormPage.class);
    WebDriver driver;

    @FindBy(xpath = "//a[@href='/phpstorm/download/']")
    public WebElement ButtonDownloadPhpStorm;

    @FindBy(xpath = "//a[@href='/' and @data-test='site-logo']")
    public WebElement mainPageButton;

    @Step("проверка нажатия кнопки на главную страницу")
    public void mainPagebuttonClick(){
        LOG.info("проверка нажатия кнопки на главную страницу");
        mainPageButton.click();
    }

    @Step("проверка нажатия кнопки загрузить")
    public void ButtonDownloadPhpStormClick() {
        LOG.info("проверка нажатия кнопки загрузить");
        ButtonDownloadPhpStorm.click();
    }

    public PhpStormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
