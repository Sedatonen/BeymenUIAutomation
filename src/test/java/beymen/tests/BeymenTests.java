package beymen.tests;

import beymen.pages.*;
import beymen.utilities.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.Random;

public class BeymenTests extends TestBase {
    BrowserUtils browserUtils = new BrowserUtils();
    HelperMethods helperMethods = new HelperMethods();
    BasePage basePage = new BasePage();
    SearchPage searchPage = new SearchPage();
    ProductPage productPage = new ProductPage();
    BasketPage basketPage = new BasketPage();


    @Test
    public void beymenTest() throws IOException {
        basePage.acceptCookies.click();
        basePage.genderButton.click();
        basePage.searchInput.sendKeys(helperMethods.getProductName(1));
        browserUtils.waitForVisibility(basePage.searchInput);
        basePage.searchInput.clear();
        basePage.searchInput.click();
        basePage.searchInput.sendKeys(helperMethods.getProductName(2) + Keys.ENTER);


        System.out.println(helperMethods.getProductName(2) + " Aratıldı");

        browserUtils.waitForVisibility(searchPage.searchPageTitle);

        Assert.assertTrue(searchPage.searchPageTitle.getText().contains(helperMethods.getProductName(2)));//aranan kelimeye uygun sonuçların listelendiğinin kontrolü
        Assert.assertTrue(driver.getTitle().contains(helperMethods.getProductName(2)));//aranan ürünün tarayıcının sekmesinde yazdığının kontrolü

        Random rand = new Random();
        searchPage.getProduct.get(rand.nextInt(searchPage.getProduct.size() - 1)).click();//listelenen ürünlerden rasgele birine tıklanır

        String price;
        try {
            price = productPage.productExtraPrice.getText();//indirim varsa price değeri bu olur
            System.out.println("Ekstra indirim uygulanan fiyat " + price);
        } catch (Exception e) {
            price = productPage.productPrice.getText();//indirim yoksa price değeri bu olur
            System.out.println("Normal fiyat = " + price);
        }

        helperMethods.writeDataToTxt(productPage.productName.getText() + "      " + price);

        price = price//burada replace kullanmanın sebebi ürün sayfasında bazı ürünlerin fiyatı kuruş içermediğinde virgülden sonrası boş gelmektedir
                .replaceAll("[,].*", "")
                .replaceAll(" TL", "")
                .replace(".", "");

        productPage.productSizes.click();
        productPage.addBasketButton.click();
        productPage.basketButton.click();

        String basketPrice;
        try {
            basketPrice = basketPage.basketExtraPrice.getText();//indirim varsa price değeri bu olur
            System.out.println("basketExtraPrice = " + basketPrice);
        } catch (Exception e) {
            basketPrice = basketPage.basketPrice.getText();//indirim yoksa price değeri bu olur
            System.out.println("basketPrice = " + basketPrice);
        }

        basketPrice = basketPrice//burada replace kullanmanın sebebi tüm ürünlerin fiyatı ,00 kuruş olarak geldiği içindir
                .replaceAll("[,].*", "")
                .replaceAll(" TL", "")
                .replace(".", "");

        Assert.assertEquals(basketPrice, price);//ürün sayfasındaki fiyat ile sepetteki fiyatın karşılaştırılması(kuruşlar dahil edilmemiştir)

        Select dropdown = new Select(basketPage.piece);
        if (dropdown.getOptions().size() >= 2) {//adet dropdownundaki element sayısı 1den fazla ise ürün adedi artırılır
            dropdown.selectByIndex(1);
            System.out.println("Ürün adedi 2 olarak seçildi");
        } else {//adet dropdownunda 1 üründen fazla seçilemiyorsa tek ürün ile devam edilir

            System.out.println("2. stok bulunmamaktadır");
        }

        basketPage.deleteButton.click();
        System.out.println(basketPage.emptyMessage.getText());
        Assert.assertTrue(basketPage.emptyMessage.isDisplayed());

    }
}
