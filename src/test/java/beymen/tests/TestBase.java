package beymen.tests;

import beymen.utilities.ConfigurationReader;
import beymen.utilities.Driver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class TestBase {

    //Testten önce ve sonra yapılması gereken metodlar

    public WebDriver driver;


    @Before
    public void setUp() {

        driver = Driver.get();

        System.out.println("Driver ayağa kaldırıldı");
        driver.manage().window().maximize();
        System.out.println("Ekran maximize yapıldı.");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().deleteAllCookies();
        System.out.println("Cookiler temizlendi.");
        String url = ConfigurationReader.get("base_url");
        driver.get(url);
        System.out.println("Beymen url i açıldı.");



    }

    @After
    public void tearDown() {
        Driver.closeDriver();
    }

}
