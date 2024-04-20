package delivery.ui;

import com.codeborne.selenide.Selenide;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static delivery.utils.RandomDataGenerator.*;

public class OrderPageTest {




    public void logIn(){
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

    @BeforeAll
    public static void setUp(){
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @BeforeEach
    public void init(){
        Selenide.open("https://fe-delivery.tallinn-learning.ee/");
    }



    @Test
    public void logInAndCreateOrderWithInvalidData(){
        logIn();

        $x("//*[@data-name='username-input']")
                .shouldBe(visible)
                .shouldBe(exist)
                .sendKeys(generateInvalidUsername());

        $x("//*[@data-name='phone-input']")
                .shouldBe(visible)
                .shouldBe(exist)
                .setValue(generateInvalidPhoneNumber());

        $x("//*[@data-name='comment-input']")
                .shouldBe(visible)
                .shouldBe(exist)
                .setValue(generateComment());

        $x("//*[@data-name='username-input-error']")
                .shouldBe(exist)
                .shouldHave(text("Поле должно содержать минимум символов: 2"));

        $x("//*[@data-name='phone-input-error']")
                .shouldBe(exist)
                .shouldHave(text("Поле должно содержать минимум символов: 6"));

        $x("//*[@data-name='createOrder-button']")
                .shouldBe(disabled);
    }




    @Test
    public void logInInToServiceSubmitToOrderPageCreateOrderAndLogOut() {

        logIn();

        $x("//*[@data-name='username-input']")
                .shouldBe(visible)
                .shouldBe(exist)
                .sendKeys(generateOrderUsername());

        $x("//*[@data-name='phone-input']")
                .shouldBe(visible)
                .shouldBe(exist)
                .setValue(generatePhoneNumber());

        $x("//*[@data-name='comment-input']")
                .shouldBe(visible)
                .shouldBe(exist)
                .setValue(generateComment());

        $x("//*[@data-name='createOrder-button']")
                .shouldBe(enabled)
                .click();
        
        $x("//*[@data-name='orderSuccessfullyCreated-popup-ok-button']")
                .shouldBe(visible)
                .click();

        $x("//*[@data-name='openStatusPopup-button']")
                .shouldBe(visible)
                .click();

        $x("//*[@data-name = 'searchOrder-input']")
                .setValue("101");

        $x("//*[@data-name = 'searchOrder-submitButton']")
                .click();

        $x("//*[@class = 'status-list__status status-list__status_active']")
                .shouldHave(text("OPEN"))
                .click();

        $x("//*[@data-name = 'logout-button']")
                .shouldBe(enabled)
                .click();
    }


}
