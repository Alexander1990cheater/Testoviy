package ru.academits;

import com.codeborne.selenide.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StudentsFormTest {
    private WebDriver driver;
            @BeforeEach
    public void setUp(){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

                String url = "https://demoqa.com/automation-practice-form";
                driver.get(url);
                driver.manage().window().maximize();
            }
            @Test
    public void testInput(){
                WebElement name = driver.findElement(By.id("firstName"));
                WebElement lastName = driver.findElement(By.id("lastName"));
                WebElement gender = driver.findElement(By.xpath("//*[@id='genterWrapper']/div[2]/div[1]/label"));
                WebElement mobile = driver.findElement(By.id("userNumber"));
                WebElement submit = driver.findElement(By.id("submit"));
//                name.click();
                name.sendKeys("Александр");
                lastName.sendKeys("Мейснер");
                gender.click();
                mobile.sendKeys("1234567890");
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
                submit.click();
                WebElement studentsName = driver.findElement(By.cssSelector("div.modal-body > div > table > tbody > tr:nth-child(1) > td:nth-child(2)"));
                studentsName.getAccessibleName();
                Assertions.assertEquals("Александр Мейснер", studentsName.getAccessibleName());
            }
            @AfterEach
    public void tearDown(){
                if (driver != null){
                    driver.quit();
                }
            }


}
