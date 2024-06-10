package Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class test1 {

	WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Use WebDriverManager to setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testOpenAmazon() {
        // Open Amazon.in website
        driver.get("https://www.amazon.in");

        // Assert the title of the page to verify successful navigation
        String expectedTitle = "Amazon.in";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Amazon.in not opened successfully");

        // Perform additional checks or actions as needed
        // For example, check the presence of the search bar
        WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchBar.isDisplayed(), "Search bar not found on Amazon.in");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser after the test
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        // This can be used to run the test without a test framework like TestNG
        test1 test = new test1();
        test.setUp();
        test.testOpenAmazon();
        test.tearDown();
        
    }
    
}
