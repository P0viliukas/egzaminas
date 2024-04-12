import PageData.CheckoutPage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.JavascriptExecutor;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.DataGenerator.*;

public class CheckoutTest extends BaseTest{
    CheckoutPage checkoutPage;

    @Test
    void userSubmitFormMandatoryFieldOnly() throws InterruptedException {
        checkoutPage = new CheckoutPage(driver);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
        checkoutPage.enterFullname(fullname);
        checkoutPage.enterEmail(email);
        jse.executeScript("window.scrollBy(0,1000)");
        checkoutPage.clickSubmit();
        Thread.sleep(2000);
        assertEquals(fullname,checkoutPage.getItemtext(1));
        assertEquals(email,checkoutPage.getItemtext(2));
    }
    @Test
    void userSubmitFormAllFields() throws InterruptedException {
        checkoutPage = new CheckoutPage(driver);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
        checkoutPage.enterFullname(fullname);
        checkoutPage.enterEmail(email);
        checkoutPage.enterTelephone(phone);
        jse.executeScript("window.scrollBy(0,250)");
        String gender =
                checkoutPage.setGender(randomGender);
        jse.executeScript("window.scrollBy(0,250)");
        String expierience =
                checkoutPage.setExpierience(randomExP);
        jse.executeScript("window.scrollBy(0,250)");
        String skill =
                checkoutPage.setSkills(randomSkill);
        String qAtool = checkoutPage.setQAtool(randomQAtool);
        checkoutPage.enterText(quote);
        jse.executeScript("window.scrollBy(0,250)");
        checkoutPage.clickSubmit();
        Thread.sleep(2000);
        assertEquals(fullname,checkoutPage.getItemtext(1));
        assertEquals(email,checkoutPage.getItemtext(2));
        assertEquals(phone,checkoutPage.getItemtext(3));
        assertEquals(gender,checkoutPage.getItemtext(4));
        assertEquals(expierience,checkoutPage.getItemtext(5));
        assertEquals(skill,checkoutPage.getItemtext(6));
        assertEquals(qAtool,checkoutPage.getItemtext(7));
        assertEquals(quote,checkoutPage.getItemtext(8));
    }
    @Test
    void userCannotSubmitForm() {
        checkoutPage = new CheckoutPage(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
        checkoutPage.enterEmail("a");
        jse.executeScript("window.scrollBy(0,1000)");
        checkoutPage.clickSubmit();
        Assertions.assertTrue(checkoutPage.alertMessage());
    }

}
