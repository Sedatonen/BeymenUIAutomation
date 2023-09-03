package beymen.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends BasePage{

    @FindBy(className = "o-productDetail__description")
    public WebElement productName;

    @FindBy(id = "priceNew")//üründe indirim yoksa bu element
    public WebElement productPrice;

    @FindBy(className = "m-price__lastPrice")//üründe indirim varsa bu element
    public WebElement productExtraPrice;

    @FindBy(xpath = ".//*[contains(@class, 'm-variation__item')][not(contains(@class, 'disabled'))]")//tükenmiş olan bedenler hariç
    public WebElement productSizes;

    @FindBy(id ="addBasket")
    public WebElement addBasketButton;

    @FindBy(className="m-notification__button")
    public WebElement basketButton;
}
