import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LoginTest {
    private WebDriver driver;
        @Before
        public void initDriver(){
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://testfasttrackit.info/selenium-test");
        }
        @Test
    public void validLoginTest(){
        driver.findElement(By.cssSelector(".skip-link.skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("mesebogdan@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("12345P!");
        driver.findElement(By.id("send2")).click();
        WebElement welcometext = driver.findElement(By.cssSelector(".hello strong"));
            Assert.assertEquals("Hello, Mesesan Bogdan Cornel!", welcometext.getText());
    }

    @Test
    public void changeLanguageTest(){
//        select-language
        Select selectLanguageDropdown = new Select(driver.findElement(By.id("select-language")));
        selectLanguageDropdown.selectByVisibleText("German");
        wait(5);

    }

    @Test
    public void hoverOverCategoryTest() {
        Actions action = new Actions(driver);
        WebElement womenCategory = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-1.first.parent > a"));
        action.moveToElement(womenCategory).perform();
        WebElement viewAll = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-1.first.parent > ul > li.level1.view-all > a"));
        viewAll.click();
        WebElement checkkeyword = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div.col-main > div.page-title.category-title"));
        Assert.assertTrue(checkkeyword.isDisplayed());
        wait(5);
    }
    @After
    public void closeDriver(){
        driver.quit();
    }



    public static void wait(int seconds){
        try {
            Thread.sleep(seconds*1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
