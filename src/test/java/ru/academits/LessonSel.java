package ru.academits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LessonSel {
    @Test
    public void simpleTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://market.yandex.ru/?from=dist_bookmarks&win=596&clid=2721055-61");
        driver.quit();
    }
}