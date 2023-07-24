package test.ui.elements.signing;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SigninElements {
    public SelenideElement userField() {return $("#form-username");}

    public SelenideElement passwordField() {
        return $("#form-password");
    }

    public SelenideElement submitButton() {
        return $x("//button[@type='submit']");
    }
}
