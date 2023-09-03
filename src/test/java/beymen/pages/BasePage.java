package beymen.pages;

import beymen.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptCookies;

    @FindBy(id="genderManButton")
    public WebElement genderButton;

    @FindBy(className = "default-input")
    public WebElement searchInput;

    @FindBy(className = "icon-search")
    public WebElement searchButton;



}
