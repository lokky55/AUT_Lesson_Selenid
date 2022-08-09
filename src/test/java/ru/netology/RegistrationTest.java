package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {

    @Test
    void shouldRegisterByAccountNumber() {
        Configuration.holdBrowserOpen = true;
//        Configuration.timeout = 10;    // изменить не явное ожидание
        open("http://localhost:9999");
//        $("a[href='/by-account']").click();   // поиск элемента по css   // или
        $(byText("По номеру счёта")).click();
        $("[name='number']").setValue("4055 0100 0123 4613 8564");
        $("[name='phone']").val("+79807133080");  // setValue = val
//        $("[type='button']").click();     // или
        $(byText("Продолжить")).click();
        $(withText("Успешная")).shouldBe(visible, Duration.ofSeconds(10));
        $(byText("Личный кабинет")).shouldBe(visible, Duration.ofSeconds(10));

//        $$(".tab-item").find(exactText("По номеру счёта")).click();
//        $("[name='number']").setValue("4055 0100 0123 4613 8564");
//        $("[name='phone']").setValue("+792000000000");
//        $$("button").find(exactText("Продолжить")).click();
//        $(withText("Успешная авторизация")).shouldBe(visible, Duration.ofMillis(5000));
//        $(byText("Личный кабинет")).shouldBe(visible, Duration.ofMillis(5000));
    }
}
