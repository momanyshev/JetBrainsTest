package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.pages.PhpStormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhpStormTest extends BaseTest{
    private PhpStormPage PhpStormPage;

    @BeforeEach
    @Override
    public void setUp(){
        super.setUp();
        getDriver().get("https://www.jetbrains.com/phpstorm/");
        PhpStormPage = new PhpStormPage(getDriver());
    }
    @Test
    @DisplayName("Проверка нажатия кнопки на главную страницу")
    public void mainPageButtonClickCheck(){
        PhpStormPage.mainPagebuttonClick();
        assertEquals("https://www.jetbrains.com/", getDriver().getCurrentUrl(), "не верная ссылка");
    }
    @Test
    @DisplayName("Проверка нажатия кнопки 'загрузка'")
    public void ButtonDownloadPhpStormClickCheck(){
        PhpStormPage.ButtonDownloadPhpStormClick();
        assertEquals("https://www.jetbrains.com/phpstorm/download/#section=windows" , getDriver().getCurrentUrl(),"не верная ссылка");
    }
}
