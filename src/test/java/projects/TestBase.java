package projects;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Faker faker;
    Random random = new Random();
    Actions actions;


    @BeforeClass
    public void beforeAllTest(){


    }

    @AfterClass
    public void afterAllTest(){


    }


    @BeforeMethod
    public void beforeEachTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        faker = new Faker();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        access();

    }


    @AfterMethod
    public void afterEachTest(){
//        try {
//            Thread.sleep(3000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        if (driver !=null){
//            driver.quit();
//        }
    }


    public void access(){

        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("(//span[.='Medal table'])[1]")).click();


    }


}


