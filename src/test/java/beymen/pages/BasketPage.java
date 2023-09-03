package beymen.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage{
    @FindBy(className = "m-productPrice__extraPrice")
    public WebElement basketExtraPrice;

    @FindBy(className = "m-productPrice__salePrice")
    public WebElement basketPrice;

    @FindBy(id = "quantitySelect0-key-0")
    public WebElement piece;

    @FindBy(id="removeCartItemBtn0-key-0")
    public WebElement deleteButton;

    @FindBy(className = "m-empty__messageTitle")
    public WebElement emptyMessage;
}
