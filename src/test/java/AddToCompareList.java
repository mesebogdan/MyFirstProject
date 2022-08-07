import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCompareList {

    private WebDriver driver;

    @Before

    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test");
    }
    @Test
    public void validAddingToCompareList() {

        driver.findElement(By.cssSelector(".level0.nav-5.parent .level0")).click();
        driver.findElement(By.cssSelector("[title='View Details']")).click();
        driver.findElement(By.cssSelector(".link-compare")).click();

        WebElement checkCompareList = driver.findElement(By.cssSelector(".block-compare strong span"));
        Assert.assertTrue(checkCompareList.isDisplayed());


    }
    @After
    public void closedriver(){
        driver.close();
    }



    public static void wait(int seconds){
        try {
            Thread.sleep(seconds*1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
