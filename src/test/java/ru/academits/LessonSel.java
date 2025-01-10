package ru.academits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LessonSelTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        String url = "https://market.yandex.ru/?from=dist_bookmarks&win=596&clid=2721055-61";
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void testYandexMarketTitle() {
        String title = driver.getTitle();
        System.out.println("Page title: " + title);
        Assertions.assertEquals("Интернет-магазин Яндекс Маркет — покупки с быстрой доставкой", title);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Закрытие браузера после каждого теста
        }
    }
}