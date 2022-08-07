import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteFromCart {

    private WebDriver driver;

    @Before

    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test");
    }

    @Test
    public void validDeleteFromCart() {

        driver.findElement(By.cssSelector(".level0.nav-5.parent .level0")).click();
        driver.findElement(By.cssSelector("[title='View Details']")).click();
        driver.findElement(By.cssSelector("[alt='Blue']")).click();
        driver.findElement(By.cssSelector("[title='XS'] .swatch-label")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons .button")).click();
        driver.findElement(By.cssSelector(".first.odd .a-center .btn-remove")).click();
        wait(3);

        WebElement welcometext = driver.findElement(By.cssSelector("h1"));
        Assert.assertEquals("SHOPPING CART IS EMPTY", welcometext.getText());
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
