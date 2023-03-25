import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

       //Test 1. verify that the Url is working
       //Test 2. verify user can successfully login
       //Test 3. verify computer and accessories button is working
       //Test 4. verify there is macbook under laptop category
       //Test 5. verify item can be carted
       //Test 6. verify item can be bought

public class KongaAutomationTest {
    //import the selenium webdriver
    private By ModalButton = By.id("_0a08a_3czMG ec93a_33DRT");
    private By ModalCardNumber = By.id("card-number");
    private By ModalExpiryDate = By.id("expiry");
    private By ModalPayNowButton = By.id("validateCardForm");
    private By ModalCVV = By.id("cvv");
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. open your chrome driver
        //driver = new ChromeDriver();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        //Test 1. verify that the Url is working
        //2. input the URL (https://www.konga.com/)
        driver.get("https://www.konga.com/");
        //3. Maximize the browser
        driver.manage().window().maximize();
    }
    @Test (priority = 0)
            public void kongalogin() throws InterruptedException {
        ///Test 2. verify user can successfully login
        //4. click on login button to open the login page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
        //5.Locate the email field and Input your email on the email field
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("akindelewale123@gmail.com");
        //6. locate the password field and Input your password on the password field
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("oluwasola");
        //7. click on sign in
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
    }
    @Test(priority = 1)
            public void computerandaccessories() throws InterruptedException {
        //Test 3. verify computer and accessories button is working
        //6. From the Categories, click on the “Computers and Accessories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }
    @Test(priority = 2)
            public void laptopsubcategory() throws InterruptedException {
        //Test4. verify there is macbook under laptop category
        //7. Click on the Laptop SubCategory
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        Thread.sleep(5000);
        //8. Click on the Apple MacBooks
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label")).click();
        String expectedTitle = "Apple MacBooks";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("expectedTitle"))
            //pass
            System.out.println("Apple MacBooks");
        else
            //fail
            System.out.println("blank page");
        Thread.sleep(5000);
    }
    @Test(priority = 3)
            public void additemtocart() throws  InterruptedException {
        //Test5. verify item can be carted
        //9. Add an item to the cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(5000);
        //10. click proceed to cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[2]/a/div[1]/h3")).click();
        Thread.sleep(5000);
    }
    @Test(priority = 4)
            public void buyitem() throws InterruptedException {
        //Test6. verify item can be bought
        //. click buy button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div[3]/div[1]/div[2]/div[2]/form/div[5]/div[1]/button")).click();
        //14. click checkout
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(15000);
        //15. click on change
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
        Thread.sleep(5000);
    }
    @Test(priority = 5)
            public void address() throws InterruptedException {
        //Test 7. verify existing address is usable
        //16. Select add delivery address
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(15000);
        //17. click on the already registered address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div[1]/form/button")).click();
        Thread.sleep(15000);
        //18. click on the "user address" button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(15000);
        //19. under the "payment options" click pay on now
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(15000);
        //20. Click on "continue to make payment" button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(15000);
        //21. Click on continue to payment Button
        click(ModalButton);
        //22. Locate Pay Now option and click it
        Thread.sleep(10000);
        //23. Input invalid Card Number
        setText(ModalCardNumber, 5688924);
        //24. Input Card CVV
        setText(ModalCVV, 362);
        //25. Input Card Expiry Date
        setText(ModalExpiryDate, 10 / 25);
        Thread.sleep(10000);
        //26. Click on complete payment
        click(ModalPayNowButton);
        //24. account details
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[4]/div/div[6]/div/a")).click();
        Thread.sleep(5000);
    }
        @AfterTest
        public void closeBrowser() {
        //quit browser
        driver.quit();






    }

    private void setText(By modalCardNumber, int i) {
    }

    private void click(By modalButton) {

    }


}
