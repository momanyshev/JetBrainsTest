package com.example.jetbrainstest.pages.aquapages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import java.util.List;


//page_url = https://www.jetbrains.com/aqua/
public class AquaPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(AquaPage.class));
    WebDriver driver;

    @FindBy(xpath = "//a[@data-test='site-logo']")
    private WebElement mainPageButton;
    @FindBy(xpath = "//span[contains(@class,'menu-second-title-box__title') and text()='Aqua']")
    private WebElement aquaPageLink;
    @FindBy(xpath = "//a[@href='/aqua/download/' and text()='Download']")
    private WebElement downloadAquaButton;
    @FindBy(xpath = "//a[@href='/aqua/features/' and text()='Features']")
    private WebElement featuresAquaButton;
    @FindBy(xpath = "//div[@id=\"js-menu-second-desktop\"]//a[text()='Documentation']")
    private WebElement documentationAquaButton;
    @FindBy(xpath = "//a[@href='/aqua/download/' and text()='Download Preview']")
    private WebElement downloadPreviewButton;
    @FindBy(xpath = "//a[text()='Learn more']")
    private List<WebElement> learnMore;

    public void mainPageButtonClick() {
        mainPageButton.click();
        LOG.info("Переход на главную страницу");
    }

    public void aquaPageLinkClick() {
        aquaPageLink.click();
        LOG.info("Переход на страницу Aqua");
    }

    public Boolean downloadAquaButtonIsClickable() {
        LOG.info("Проверка активности кнопки Features");
        return downloadAquaButton.isEnabled();
    }

    public Boolean featuresAquaButtonIsClickable() {
        LOG.info("Проверка активности кнопки Documentation");
        return featuresAquaButton.isEnabled();
    }

    public Boolean documentationAquaButtonIsClickable() {
        LOG.info("Проверка активности кнопки Download");
        return documentationAquaButton.isEnabled();
    }

    public String downloadPreviewButtonName() {
        LOG.info("Получение названия кнопки Download Preview");
        return downloadPreviewButton.getText();
    }

    public void downloadAquaButtonClick() {
        downloadAquaButton.click();
        LOG.info("Нажатие на кнопку Download Preview");
    }

    public String learnMore(int id) {
        LOG.info("Проверка кликабельности Learn more");
        return learnMore.get(id).getAttribute("href");
    }

    public AquaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
