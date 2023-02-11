package com.vesska.mobile.iOS;

import com.vesska.mobile.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.id;

public class IosTest extends TestBase {

    @Test
    @Tag("ios")
    void iosOutputTextTest() {

        String text = "iOSTest";
        step("Click Text Button", () -> {
            $(id("Text Button")).click();
        });

        step("Check initial state Output text", () -> {
            assertEquals("Waiting for text input.", $(id("Text Output")).getText());
        });

        step(format("Set value %s in the input field and press enter", text), () -> {
            $(id("Text Input")).click();
            $(id("Text Input")).sendKeys(text);
            $(id("Text Input")).pressEnter();
        });

        step("Check Output text", () -> {
            assertEquals(text, $(id("Text Output")).getText());
        });
    }
}