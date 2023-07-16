package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.pages.PyCharmPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PyCharmTest extends BaseTest {

    private PyCharmPage pyCharmPage;
    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        pyCharmPage = new PyCharmPage(getDriver());
    }
    @Test
    @DisplayName("Проверка активности кнопки PyCharm")
    public void pyCharmButtonIsActive(){
        pyCharmPage = new PyCharmPage(getDriver());
        Assertions.assertTrue(pyCharmPage.pyCharmButtonIsActive());
    }
    @Test
    @DisplayName("Проверка URL после нажатия кнопки PyCharm")
    public void checkUrlAfterClickPyCharmButton(){
        pyCharmPage = new PyCharmPage(getDriver());
        Assertions.assertEquals(pyCharmPage.clickPyCharmButtonAndCheckUrl(),"https://www.jetbrains.com/pycharm/","URL не равен ожидаемому");
    }
    @Test
    @DisplayName("Проверка активности кнопки Download")
    public void downloadButtonIsActive(){
        pyCharmPage = new PyCharmPage(getDriver());
        Assertions.assertTrue(pyCharmPage.downloadButtonIsActive());
    }
}
