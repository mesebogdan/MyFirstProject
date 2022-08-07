import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    private WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test");
    }
    @Test
    public void validRegisterTest(){

        driver.findElement(By.cssSelector(".skip-link.skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Mesesan");
        driver.findElement(By.id("middlename")).sendKeys("Bogdan");
        driver.findElement(By.id("lastname")).sendKeys("Cornel");
        driver.findElement(By.id("email_address")).sendKeys("mesebogdan@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("12345P!");
        driver.findElement(By.id("confirmation")).sendKeys("12345P!");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector(".buttons-set span")).click();
        wait(3);

    }

    @After
    public void close(){
        driver.close();
    }
    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
