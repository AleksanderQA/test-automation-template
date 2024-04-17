package delivery.ui;

import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import delivery.utils.RandomDataGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPageTest {


    @BeforeAll
    public static void setUp() {
        Configuration.browserCapabilities = new ChromeOptions();
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    public void init() {
        Selenide.open("https://fe-delivery.tallinn-learning.ee/");
    }



    @ParameterizedTest
    @CsvSource({" , ","u,p","u,pa","u,pas,","u,pass","u,passw","u,passwo","u,passwor"})
    public void checkForMinimumLimitsOfEntryLogInFields(String username, String password) {


        $x("//*[@data-name='username-input']")
                .shouldBe(visible)
                .sendKeys(username);

        $x("//*[@data-name='password-input']")
                .shouldBe(visible)
                .sendKeys(password);

        $x("//*[@data-name = 'signIn-button']")
                .shouldBe(visible)
                .shouldBe(exist)
                .shouldBe(disabled)
                .shouldBe(attribute("data-name", "signIn-button"))
                .click();
        $x("//*[@data-name='username-input-error']")
                .shouldBe(visible)
                .shouldBe(exist);

        $x("//*[@data-name='password-input']/following-sibling::*[@data-name='username-input-error']")
                .shouldBe(visible)
                .shouldBe(exist)
                .shouldHave(matchText("The field must contain  at least of characters: 8"));
    }


    // Generating username alphabetic values min = 2 max = 30 and password alphanumeric values min = 8 and max = 30
    @Test
    public void insertIncorrectLoginAndPasswordAndCheckErrorMessage() {

        $x("//*[@data-name='username-input']")
                .shouldBe(visible)
                .sendKeys(RandomDataGenerator.generateUsername());

        $x("//*[@data-name='password-input']")
                .shouldBe(visible)
                .sendKeys(RandomDataGenerator.generatePassword());

        $x("//*[@data-name = 'signIn-button']")
                .shouldBe(visible)
                .shouldBe(exist)
                .shouldBe(enabled)
                .shouldBe(attribute("data-name", "signIn-button"))
                .click();

        $x("//*[@* = 'error-popup__title']")
                .shouldBe(exist)
                .shouldBe(visible)
                .shouldHave(text("Incorrect credentials"));

        $x("//*[@* = 'authorizationError-popup-close-button']")
                .shouldBe(visible)
                .shouldBe(exist)
                .shouldHave(text("×"))
                .click();
    }

    @Test
    public void  loginWithValidData(){


        $x("//*[@data-name='username-input']")
                .shouldBe(visible)
                .shouldBe(exist)
                .sendKeys(System.getProperty("username"));

        $x("//*[@data-name='password-input']")
                .shouldBe(visible)
                .shouldBe(exist)
                .sendKeys(System.getProperty("password"));

        $x("//*[@data-name = 'signIn-button']")
                .shouldBe(visible)
                .shouldBe(enabled)
                        .click();
    }
}
