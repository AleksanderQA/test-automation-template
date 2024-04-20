package delivery.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static delivery.utils.RandomDataGenerator.*;

public class LoginPageTest {




    @BeforeAll
    public static void setUp(){
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 1000;
    }

    @BeforeEach
    public void init(){
        Selenide.open("https://fe-delivery.tallinn-learning.ee/");
    }

    @Test
    public void logInWithInvalidCredentials(){
        $x("//*[@data-name='username-input']")
                .shouldBe(visible)
                .sendKeys(generateUsername());
        $x("//*[@data-name='password-input']")
                .shouldBe(visible)
                .sendKeys(generatePassword());
        $x("//*[@data-name='signIn-button']")
                .shouldBe(enabled)
                .click();
        $x("//*[@data-name ='authorizationError-popup']")
                .shouldBe(visible)
                .shouldBe(exist);
        $x("//*[@data-name='authorizationError-popup-close-button']")
                .click();
    }

    @Test
    public void checkForMinimalLimitValidValuesOfEntryField(){


        $x("//*[@data-name='username-input']")
                .shouldBe(visible)
                .setValue(generateInvalidUsername());

        $x("//*[@data-name='password-input']")
                .shouldBe(visible)
                .setValue(generateInvalidPassword());

        $x("//*[@data-name='username-input-error']")
                        .shouldBe(exist);

        $x("//*[@data-name='password-input']/parent::*//*[@data-name='username-input-error']")
                .shouldHave(text("Поле должно содержать минимум символов: 8"))
                        .shouldBe(exist);

        $x("//*[@data-name='signIn-button']")
                .shouldBe(disabled);
    }

    @Test
    public void checkForResponseIfEntryFieldsAreEmptyAndClickSignInButton(){

        $x("//*[@data-name='username-input']")
                .shouldBe(visible)
                .setValue("");

        $x("//*[@data-name='password-input']")
                .shouldBe(visible)
                .setValue("");


        $x("//*[@data-name='signIn-button']")
                .shouldBe(enabled)
                .click();
    }

    @Test
    public void logInWithValidData() {
        $x("//*[@data-name='username-input']")
                .shouldBe(visible)
                .sendKeys(System.getProperty("username"));
        $x("//*[@data-name='password-input']")
                .shouldBe(visible)
                .sendKeys(System.getProperty("password"));
        $x("//*[@data-name='signIn-button']")
                .shouldBe(enabled)
                .click();
    }
}
