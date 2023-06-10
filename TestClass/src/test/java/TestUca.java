import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class TestUca {
    public WebDriver driver;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void login() {
        WebElement inputUsername;
        inputUsername = driver.findElement(By.cssSelector("#user-name"));
        inputUsername.sendKeys("standard_user");
        WebElement inputPassword;
        inputPassword = driver.findElement(By.cssSelector("#password"));
        inputPassword.sendKeys("secret_sauce");
        WebElement buscarBtn;
        buscarBtn = driver.findElement(By.cssSelector("#login-button"));
        buscarBtn.click();
    }

    public void addToCart() {
        WebElement addToCart;
        addToCart = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        addToCart.click();
        WebElement moveToCart;
        moveToCart = driver.findElement(By.cssSelector("#shopping_cart_container > a"));
        moveToCart.click();
        WebElement checkout;
        checkout = driver.findElement(By.cssSelector("#checkout"));
        checkout.click();
    }
    public void checkout() {
        WebElement firstName;
        firstName = driver.findElement(By.cssSelector("#first-name"));
        firstName.sendKeys("Omar");
        WebElement lastName;
        lastName = driver.findElement(By.cssSelector("#last-name"));
        lastName.sendKeys("Leiva");
        WebElement PC;
        PC = driver.findElement(By.cssSelector("#postal-code"));
        PC.sendKeys("10101");
        WebElement continueBtn;
        continueBtn = driver.findElement(By.cssSelector("#continue"));
        continueBtn.click();
        WebElement finish;
        finish = driver.findElement(By.cssSelector("#finish"));
        finish.click();
        WebElement backHome;
        backHome = driver.findElement(By.cssSelector("#back-to-products"));
        backHome.click();

    }

    @Test
    public void test() {
        setUp();
        login();
        addToCart();
        checkout();
        driver.quit();

    }
}
