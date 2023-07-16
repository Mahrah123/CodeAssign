package code;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SubscriptionPackageValidationTest {
    WebDriver driver;
    
    @BeforeTest
    public void setup() {
        // Set up the Chrome driver
        WebDriverManager.ChromeDriver().setup();
        driver = new ChromeDriver();
    }
    
    @Test
    public void validateSubscriptionPackages() {
        // Navigate to the STC TV subscription page
        driver.get("https://subscribe.stctv.com/");
        
        // Find the subscription package elements for each country
        WebElement saPackage = driver.findElement(By.xpath("//div[@data-country='SA']"));
        WebElement kuwaitPackage = driver.findElement(By.xpath("//div[@data-country='Kuwait']"));
        WebElement bahrainPackage = driver.findElement(By.xpath("//div[@data-country='Bahrain']"));
        
        // Validate the subscription package types and prices for each country
        Assert.assertEquals(saPackage.findElement(By.className("package-type")).getText(), "Basic");
        Assert.assertEquals(saPackage.findElement(By.className("package-price")).getText(), "SAR 15/month");
        
        Assert.assertEquals(kuwaitPackage.findElement(By.className("package-type")).getText(), "Premium");
        Assert.assertEquals(kuwaitPackage.findElement(By.className("package-price")).getText(), "KWD 5/month");
        
        Assert.assertEquals(bahrainPackage.findElement(By.className("package-type")).getText(), "Premium Plus");
        Assert.assertEquals(bahrainPackage.findElement(By.className("package-price")).getText(), "BHD 5/month");
    }
    
    @AfterTest
    public void tearDown() {
        // Quit the driver and close the browser window
        driver.quit();
    }
}
