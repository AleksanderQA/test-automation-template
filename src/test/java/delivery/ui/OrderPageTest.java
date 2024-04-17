package delivery.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static delivery.utils.RandomDataGenerator.*;

public class OrderPageTest {

    public void  logIn () {
        $x("//*[@data-name='username-input']")
                .shouldBe(visible)
                .sendKeys(System.getProperty("username"));
        $x("//*[@data-name='password-input']")
                .shouldBe(visible)
                .sendKeys(System.getProperty("password"));
        $x("//*[@data-name = 'signIn-button']")
                .shouldBe(visible)
                .shouldBe(visible).click();
    }

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


    @Test
    public void logInAndCreateOrder() {

        logIn();

        $x("//*[@data-name = 'username-input']")
                .shouldBe(visible)
                .setValue(generateOrderUsername());

        $x("//*[@data-name = 'phone-input']")
                .shouldBe(visible)
                .sendKeys(generatePhoneNumber());


        $x("//*[@data-name = 'comment-input']")
                .shouldBe(visible)
                .sendKeys(generateComment());


        $x("//*[@data-name = 'createOrder-button']")
                .shouldBe(enabled)
                .click();
        $x("//*[@data-name ='orderSuccessfullyCreated-popup-ok-button']")
                .shouldBe(visible).click();
        $x("//*[@data-name='logout-button']")
                .shouldBe(visible)
                .click();

    }
}
