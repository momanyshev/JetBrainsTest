package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.aquapages.AquaDownloadPage;
import com.example.jetbrainstest.pages.aquapages.AquaPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyExtension.class)
public class AquaTest extends BaseTest {

    private AquaPage aquaPage = new AquaPage(getDriver());
    private AquaDownloadPage aquaDownloadPage = new AquaDownloadPage(getDriver());

    @BeforeEach
    @Override
    @Step("Переход на страницу aqua")
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/aqua/");
    }

    @Test
    @DisplayName("Проверка перехода по ссылке на главную страницу")
    public void mainLinkChecking() {
        aquaPage.mainPageButtonClick();
        assertEquals("https://www.jetbrains.com/", getDriver().getCurrentUrl(), "Открылась неверная сслыка");
    }

    @Test
    @DisplayName("Проверка перехода по сслыке на страницу Aqua")
    public void aquaLinkChecking() {
        aquaPage.aquaPageLinkClick();
        assertEquals("https://www.jetbrains.com/aqua/", getDriver().getCurrentUrl(), "Открылась неверная сслыка");
    }

    @Test
    @DisplayName("Проверка активности кнопки Features")
    public void featuresButtonCheck() {
        assertTrue(aquaPage.featuresAquaButtonIsClickable(), "Кнопка Features не активна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Documentation")
    public void buttonCheck() {
        assertTrue(aquaPage.documentationAquaButtonIsClickable(), "Кнопка Documentation не активна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Download")
    public void downloadButtonCheck() {
        assertTrue(aquaPage.downloadAquaButtonIsClickable(), "Кнопка Download не активна");
    }

    @Test
    @DisplayName("Проверка названия кнопки Download Preview")
    public void switcherButtonName() {
        String btnName = "Download Preview";
        assertEquals(btnName, aquaPage.downloadPreviewButtonName(), "Кнопка с нужным названием не находится на странице");
    }

    @ParameterizedTest(name = "{index} - для {1}")
    @CsvSource({"0, selenium", "1, cypress", "2, playwright"})
    @DisplayName("Проверка Learn more")
    public void learnMoreSupportInAqua(int num, String name) {
        assertTrue(aquaPage.learnMore(num).contains(name), "Ссылка не ведёт на страницу " + name + " support in Aqua");
    }

    @ParameterizedTest(name = "{index} - для {1}")
    @CsvSource({"0, Windows", "1, macOS", "2, Linux"})
    @DisplayName("Проверка кликабельности кнопки Download Toolbox App")
    public void downloadToolboxAppButtonIsClickable(int num, String name) {
        aquaPage.downloadAquaButtonClick();
        assertTrue(aquaDownloadPage.downloadToolboxApp(num), "Кнопка Download Toolbox App для " + name + " не кликабельная");
    }

    @ParameterizedTest(name = "{index} - для {1}")
    @DisplayName("Проверка кликабельности кнопки Download IDE")
    @CsvSource({"0, Windows", "1, macOS", "2, Linux"})
    public void downloadIDEButtonIsClickable(int num, String name) {
        aquaPage.downloadAquaButtonClick();
        assertTrue(aquaDownloadPage.downloadIDEButton(num), "Кнопка Download IDE для " + name + " не кликабельная");
    }

    @ParameterizedTest(name = "{index} - для {1}")
    @DisplayName("Проверка первого пункта из списка системных требований")
    @CsvSource(value = {"0; Windows; 64-bit version of Windows 10 1809 and later, or Windows Server 2019 and later",
            "1; macOS; macOS 10.15 and later",
            "2; Linux; GNOME or KDE desktop"}, delimiter = ';')
    public void systemRequirementsFirstParameter(int num, String name, String firstPoint) {
        aquaPage.downloadAquaButtonClick();
        assertEquals(firstPoint, aquaDownloadPage.systemRequirementsPopupWindow(num), "Отображен неверный пункт системных требований для " + name);
    }

    @ParameterizedTest(name = "{index} - для {1}")
    @DisplayName("Проверка первого пункта из инструкции по установке")
    @CsvSource({"0, Windows, Run the aqua-2023.1.exe file that starts the Installation Wizard",
            "1, macOS, Download the aqua-2023.1.dmg macOS Disk Image file",
            "2, Linux, Note: A new instance MUST NOT be extracted over an existing one. The target folder must be empty."})
    public void installationInstructionsFirstParameter(int num, String name, String firstPoint) {
        aquaPage.downloadAquaButtonClick();
        assertTrue(aquaDownloadPage.installationInstructionsPopupWindow(num).contains(firstPoint), "Отображена неверная инструкция по установке для " + name);
    }
}
