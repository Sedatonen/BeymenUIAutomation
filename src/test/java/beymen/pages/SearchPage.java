package beymen.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class SearchPage extends BasePage{

    @FindBy(xpath = "//*[@class='o-productList__item']")
    public List<WebElement> getProduct;

    @FindBy(id="productListTitle")
    public WebElement searchPageTitle;
}
