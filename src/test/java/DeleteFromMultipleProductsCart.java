import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteFromMultipleProductsCart {

    private WebDriver driver;

    @Before

    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test");
    }

    @Test
    public void validDeleteFromMultipleProductsCart() {

        driver.findElement(By.cssSelector(".level0.nav-5.parent .level0")).click();
        driver.findElement(By.cssSelector("[title='View Details']")).click();
        driver.findElement(By.cssSelector("[alt='Blue']")).click();
        driver.findElement(By.cssSelector("[title='XS'] .swatch-label")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons .button")).click();
        driver.findElement(By.cssSelector(".level0.nav-6 .level0")).click();
        driver.findElement(By.cssSelector(".actions [href*=lexington]")).click();
        driver.findElement(By.cssSelector("[alt='Indigo']")).click();
        driver.findElement(By.cssSelector("[title='S'] .swatch-label")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons span")).click();
        driver.findElement(By.cssSelector(".first.odd .a-center .btn-remove")).click();
        wait(3);

        WebElement checkDeleteFromMultipleProductsCart = driver.findElement(By.cssSelector("h1"));
        Assert.assertTrue(checkDeleteFromMultipleProductsCart.isDisplayed());
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
