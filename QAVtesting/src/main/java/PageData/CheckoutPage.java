package PageData;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input.name")
    private WebElement fullNameInput;
    @FindBy(css = "input.email")
    private WebElement emailInput;
    @FindBy(css = "input.telephone")
    private WebElement telephoneInput;
    @FindBy(className = "wp-block-button__link")
    private WebElement buttonSubmit;
    @FindBy(className = "field-value")
    private List<WebElement> itemList;
    @FindBy(css = ".select option")
    private List<WebElement> dropdownList;
    @FindBy(css = ".contact-form-field label")
    private List<WebElement> expierienceList;
    @FindBy(css = ".contact-form-field [type=\"checkbox\"]")
    private List<WebElement> skillsList;
    @FindBy(css = ".grunion-checkbox-multiple-options label")
    private List<WebElement> skillsListText;
    @FindBy(css = "textarea.textarea")
    private WebElement textareaInput;

    public void enterFullname(String fullname) {
        waitForElementIsDisplayed(fullNameInput);
        fullNameInput.sendKeys(fullname);
    }

    public void enterEmail(String email) {
        waitForElementIsDisplayed(emailInput);
        emailInput.sendKeys(email);
    }

    public void clickSubmit() {
        waitForElementIsDisplayed(buttonSubmit);
        buttonSubmit.click();
    }

    public String getItemtext(int item) {
        waitForElementIsDisplayed(itemList.getFirst());
        return itemList.get(item - 1).getText();
    }

    public void enterTelephone(String phone) {
        waitForElementTobeEnabled(telephoneInput);
        telephoneInput.sendKeys(phone);
    }

    public String setGender(int gender) {
        waitForElementTobeEnabled(dropdownList.getFirst());
        dropdownList.get(gender - 1).click();
        return dropdownList.get(gender - 1).getText();
    }

    public String setExpierience(int ExP) {
        waitForElementTobeEnabled(expierienceList.getFirst());
        expierienceList.get(ExP - 1).click();
        return expierienceList.get(ExP - 1).getText();

    }

    public String setSkills(int skill) {
        waitForElementTobeEnabled(skillsList.getFirst());
        skillsList.get(skill - 1).click();
        return skillsListText.get(skill - 1).getText();
    }

    public String setQAtool(int QAtool) {
        waitForElementTobeEnabled(dropdownList.getFirst());
        dropdownList.get(QAtool + 3).click();
        return dropdownList.get(QAtool + 3).getText();
    }

    public void enterText(String quote) {
        waitForElementTobeEnabled(textareaInput);
        textareaInput.sendKeys(quote);
    }
    public boolean alertMessage(){
        return driver.findElement(By.className("contact-form__error")).isDisplayed();
    }

}
